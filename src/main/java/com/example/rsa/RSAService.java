package com.example.rsa;



import com.example.rsa.hashing.SHA;
import com.example.rsa.key_generation.GenerationKey;
import com.example.rsa.models.ModelSignature;
import com.example.rsa.models.ModelSignatureUser;
import com.example.rsa.models.OpenKey;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigInteger;

@Service
@AllArgsConstructor
public class RSAService {

    private final RSARepository repository;
    public ModelSignatureUser encryptionFile(ModelSignature modelSignature){
        String DataFiles;
        SHA sha = new SHA();
        GenerationKey key = new GenerationKey();
        sha.setText(modelSignature.getDataFile());
        BigInteger sha_int = sha.getInteger();
        BigInteger close_exhibitor = key.getClose_exhibitor();
        BigInteger derivative = key.getDerivative();
        if(sha_int.compareTo(derivative) <= -1){
            BigInteger signature = sha_int.modPow(close_exhibitor,derivative);
            Long ID = repository.save(modelSignature.getPathFile(), modelSignature.getDataFile(), key.getOpen_exhibitor(), key.getClose_exhibitor(), key.getDerivative());

            DataFiles = modelSignature.getDataFile() + "\n" + signature.toString();
            ModelSignatureUser modelSignatureUser = new ModelSignatureUser();
            modelSignatureUser.setPathFile(modelSignature.getPathFile());
            modelSignatureUser.setDataFile(DataFiles);
            modelSignatureUser.setId(ID);
            return modelSignatureUser;

        }else{System.out.println("Ключ мал");}

        return new ModelSignatureUser();
    }

    public OpenKey OpenKey(Long id){
        BigInteger open_exhibitor = new BigInteger(repository.getOpenExhibitor(id));
        BigInteger derivative = new BigInteger((repository.getDerivative(id)));
        OpenKey openKey = new OpenKey(open_exhibitor,derivative);
        return openKey;
    }


}
