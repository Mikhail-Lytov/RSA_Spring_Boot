package com.example.rsa.service;

import com.example.rsa.model.ModelSignature;
import com.example.rsa.model.ModelSignatureUser;
import com.example.rsa.model.OpenKey;
import com.example.rsa.repository.RSARepository;
import com.example.rsa.utils.hashing.SHA;
import com.example.rsa.utils.key_generation.GenerationKey;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import org.apache.commons.codec.binary.Base64;

@Service
@AllArgsConstructor
public class RSAServiceImpl implements RSAService{
    private final RSARepository repository;
    @Override
    public ModelSignatureUser encryptionFile(ModelSignature modelSignature) {
        byte[] bite_base64 = Base64.decodeBase64(modelSignature.getDataFile());
        modelSignature.setDataFile(new String(bite_base64));

        String DataFiles;
        SHA sha = new SHA();
        GenerationKey key = new GenerationKey();
        sha.setText(modelSignature.getDataFile());
        BigInteger sha_int = sha.getInteger();
        BigInteger close_exhibitor = key.getClose_exhibitor();
        BigInteger derivative = key.getDerivative();
        if(sha_int.compareTo(derivative) <= -1){
            BigInteger signature = sha_int.modPow(close_exhibitor,derivative);
            //String signature_base_64 = Base64.encodeBase64String(("\n" + signature.toString()).getBytes());

            Long ID = repository.save(modelSignature.getPathFile(), modelSignature.getDataFile(), key.getOpen_exhibitor(), key.getClose_exhibitor(), key.getDerivative());

            DataFiles = Base64.encodeBase64String((modelSignature.getDataFile() + "\n" + signature).getBytes());
            ModelSignatureUser modelSignatureUser = new ModelSignatureUser();
            modelSignatureUser.setPathFile(modelSignature.getPathFile());
            modelSignatureUser.setDataFile(DataFiles);
            modelSignatureUser.setId(ID);
            return modelSignatureUser;

        }else{System.out.println("Ключ мал");}

        return new ModelSignatureUser();
    }

    @Override
    public OpenKey OpenKey(Long id) {
        BigInteger open_exhibitor = new BigInteger(repository.getOpenExhibitor(id));
        BigInteger derivative = new BigInteger((repository.getDerivative(id)));
        OpenKey openKey = new OpenKey(open_exhibitor,derivative);
        return openKey;
    }
}
