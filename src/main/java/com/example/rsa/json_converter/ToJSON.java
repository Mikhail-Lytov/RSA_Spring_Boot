package com.example.rsa.json_converter;

import com.example.rsa.models.ModelSignature;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;

import java.io.*;
import org.apache.commons.codec.binary.Base64;

@AllArgsConstructor
public class ToJSON {
    private String path;

    public void converter() throws IOException {
        String line;
        String line_sum = "";

        ModelSignature modelSignature = new ModelSignature();
        char[] buffer = new char[0];
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader buf = new BufferedReader(fileReader);
        while ((line = buf.readLine()) != null){
            line_sum += line + "\n";
        }
        fileReader.close();
        buf.close();

        byte[] encodedBytes = Base64.encodeBase64(line_sum.getBytes());
        /*modelSignature.setDataFile(new String(encodedBytes));
        modelSignature.setPathFile(path);
*/

        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter("C:\\Users\\Lytov\\Desktop\\backend\\тест файлы\\1.json");
        gson.toJson(modelSignature, fileWriter);
        fileWriter.close();


    }

}
