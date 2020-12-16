package com.hippo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HippoWebApplication {

    public static void main(String[] args) {
        System.out.println("---------启动开始--------");

        SpringApplication.run(HippoWebApplication.class, args);

        System.out.println("---------启动结束--------SUCCESS");
    }

}
