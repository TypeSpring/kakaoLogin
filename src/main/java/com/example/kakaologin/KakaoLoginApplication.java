package com.example.kakaologin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class KakaoLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaoLoginApplication.class, args);
    }

}
