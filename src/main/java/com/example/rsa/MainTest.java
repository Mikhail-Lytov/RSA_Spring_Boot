package com.example.rsa;

import com.example.rsa.json_converter.ToJSON;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        ToJSON toJSON = new ToJSON("C:\\Users\\Lytov\\Desktop\\backend\\тест файлы\\1.txt");
        toJSON.converter();

    }
}
