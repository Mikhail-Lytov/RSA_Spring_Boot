package generetion.json.json_converter;

import com.example.rsa.model.ModelSignature;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;


import java.io.*;

public class jsonToTXT {

    public jsonToTXT(String path) throws IOException {

        String line;
        String line_sum = "";

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            line_sum += line + "\n";
        }
        line_sum = line_sum.substring(0,line_sum.length() - 1);

        ModelSignature modelSignature = new Gson().fromJson(line_sum, ModelSignature.class);
        String pathModel = modelSignature.getPathFile();
        String dataFiles = modelSignature.getDataFile();
        byte[] base = Base64.decodeBase64(dataFiles);
        dataFiles = new String(base);
        path = path.replaceAll(".json", ".txt");
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(dataFiles);
        fileWriter.close();




    }


}
