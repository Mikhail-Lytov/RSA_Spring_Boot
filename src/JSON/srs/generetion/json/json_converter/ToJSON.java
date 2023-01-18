package generetion.json.json_converter;


import com.example.rsa.model.ModelSignature;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;

import java.io.*;
import org.apache.commons.codec.binary.Base64;

@AllArgsConstructor
public class ToJSON {
    private String path;

    public void converter() throws IOException {
        try {
            String line;
            String line_sum = "";

            ModelSignature modelSignature = new ModelSignature();

            char[] buffer = new char[0];
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader buf = new BufferedReader(fileReader);
            while ((line = buf.readLine()) != null) {
                line_sum += line + "\n";
            }
            line_sum = line_sum.substring(0,line_sum.length() - 1);
            fileReader.close();
            buf.close();

            byte[] encodedBytes = Base64.encodeBase64(line_sum.getBytes());
            modelSignature.setDataFile(new String(encodedBytes));
            modelSignature.setPathFile(path);

            path = path.replaceAll(".txt", ".json");

            Gson gson = new Gson();
            //File file1 = new File(path);
            //file1.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            gson.toJson(modelSignature, fileWriter);
            fileWriter.close();
        }catch (FileNotFoundException e){
            System.out.println("нету такого файла");
        }

        //"C:\\Users\\Lytov\\Desktop\\backend\\тест файлы\\1.json"

    }

}