package com.lida.dy.cal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(System.getProperty("file.encoding"));
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
    }
}
