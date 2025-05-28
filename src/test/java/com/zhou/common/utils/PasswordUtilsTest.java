package com.zhou.common.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordUtilsTest {

    @Test
    void encode() {
        String encode = PasswordUtils.encode("123456");
        System.out.println(encode);
    }

    @Test
    void matches() {
        boolean matches = PasswordUtils.matches("123456", "$2a$10$oe7Od1DScqE0WWP67bh9xepvTul7WBhXuouUrVKhNOOtIjryCIEM.");
        System.out.println(matches);
    }
}