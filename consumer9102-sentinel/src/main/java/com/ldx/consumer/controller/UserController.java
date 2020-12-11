package com.ldx.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getUser")
    public String getUser(Integer id) {
        return restTemplate.getForObject("http://provider/getUser?id=" + id, String.class);
    }

    @RequestMapping("/regis")
    public String regis() {
        return "regis sentinel";
    }

    @RequestMapping("/valid")
    public String valid() {
        return "valid sentinel";
    }

    /** 服务降级 **/
    @RequestMapping("/user")
    @SentinelResource(value = "user",
            blockHandlerClass = MyBlockException.class,
            blockHandler = "handle",
            fallbackClass = MyBlockException.class,
            fallback = "javaerror")
    public String user(Long id) {
        int i = 1/0;//java异常，由fallback里的javaerror来兜底
        return "要查询的用户id：" + id;
    }


}
