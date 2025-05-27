package com.zhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhou.**.mapper")
@SpringBootApplication
public class SpringBoot3Application {
    public static void main(String[] args) {
//        SpringApplication.run(SpringBoot3Application.class, args);

        SpringApplication springApplication = new SpringApplication(SpringBoot3Application.class);
        springApplication.setWebApplicationType(WebApplicationType.SERVLET);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
