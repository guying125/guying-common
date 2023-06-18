package com.guying.fourlayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Code Farmer
 * @since current time
 */
@SpringBootApplication(scanBasePackages = {"com.guying.fourlayer"})
//@MapperScan("com.guying.fourlayer.repository.**.mapper")
public class FourLayerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FourLayerApplication.class, args);
    }
}
