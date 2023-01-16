package com.example.rsa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RsaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RsaApplication.class, args);
    }

}
