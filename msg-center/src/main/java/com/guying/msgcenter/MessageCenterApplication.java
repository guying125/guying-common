package com.guying.msgcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author QJYou
 * @date 2023-05-30 16:04
 */
@SpringBootApplication(scanBasePackages = {"com.guying.msgcenter"})
@MapperScan("com.guying.msgcenter.repository")
public class MessageCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageCenterApplication.class, args);
    }
}
