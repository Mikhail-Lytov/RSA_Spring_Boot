package com.example.rsa;


import com.example.rsa.hashing.SHA;
import com.example.rsa.key.GenerationKey;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

@Service
@AllArgsConstructor
public class RSAService {

    public FileSystemResource encryptionFile(MultipartFile file) throws IOException {
        System.out.println("Вошел");
        SHA sha_ = new SHA();
        System.out.println("вышел");
        GenerationKey key = new GenerationKey();
        System.out.println("не вышел");
        byte[] text = file.getBytes();
        String text_string = new String(text);
        System.out.println(text_string);
        sha_.setText(text_string);
        BigInteger sha_int = sha_.getInteger();

        //key.key_generation();
        BigInteger close_exhibitor = key.getClose_exhibitor();

        BigInteger derivative = key.getDerivative();
        System.out.println(close_exhibitor);
        System.out.println(derivative);
        if(sha_int.compareTo(derivative) <= -1){
            BigInteger signature = sha_int.modPow(close_exhibitor,derivative);
            //FileWriter file_signature = new FileWriter(name_file_txt);
            //file_signature.write(line_sum + "\n" + signature.toString());
            //file_signature.close();

        }else{System.out.println("Ключ мал");}
        File file1 = new File("C:\\Users\\Lytov\\Desktop\\backend\\тест файлы\\2.txt");
        file1.createNewFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("Привет");
        fileWriter.close();
        return new FileSystemResource("C:\\Users\\Lytov\\Desktop\\backend\\тест файлы\\2.txt");

    }
    //https://www.youtube.com/watch?v=oGK2KufvxM0


}
