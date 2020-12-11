package com.ldx.consumer.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockException {

    // 降级方法，注意static, 注意返回值，形参要和正常方法一样；形参多一个BlockException
    public static String handle(Long id, BlockException blockException) {
        return "服务有问题，降级了";
    }

    public static String javaerror(Long id) {
        return "服务有java异常";
    }
}
