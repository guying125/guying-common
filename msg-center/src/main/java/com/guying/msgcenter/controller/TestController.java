package com.guying.msgcenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Code Farmer
 * @date 2023-05-30 17:11
 */
@Slf4j
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @PostMapping("/test2")
    public String postTest(@RequestBody String name, String code) {
        log.info("name={}, code={}", name, code);
        return name + code;
    }

}
