package com.guying.msgcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QJYou
 * @date 2023-05-30 17:11
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "OK";
    }

}
