package com.example.rsa.Json;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class test {

    public void gra() throws IOException {
        byte[] encodedBytes = Base64.encodeBase64("Пивет".getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
        System.out.println("decodedBytes " + new String(decodedBytes));

        Json_pac jsonPac = new Json_pac(1, "Misha");
        Gson gson = new Gson();
        FileWriter file = new FileWriter("C:\\Users\\Lytov\\Desktop\\backend\\тест файлы\\1.json");
        gson.toJson(jsonPac, file);
        file.close();
    }

}
