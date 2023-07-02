package com.guying.common.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author QJYou
 * @since 2023-07-01 19:48
 */
@SpringBootApplication(scanBasePackages = {"com.guying.common.util"})
public class CommonUtilApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonUtilApplication.class, args);
    }
}
