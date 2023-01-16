package com.example.rsa;

import com.example.rsa.Json.test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RsaApplication {

    public static void main(String[] args) throws IOException {
        test Test = new test();
        Test.gra();
        SpringApplication.run(RsaApplication.class, args);
    }

}
