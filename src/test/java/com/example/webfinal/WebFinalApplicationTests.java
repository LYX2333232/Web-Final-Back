package com.example.webfinal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class WebFinalApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    void getTime(){
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
    }
}
