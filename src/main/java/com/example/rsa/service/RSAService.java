package com.example.rsa.service;

import com.example.rsa.model.ModelSignature;
import com.example.rsa.model.ModelSignatureUser;
import com.example.rsa.model.OpenKey;

public interface RSAService {
    ModelSignatureUser encryptionFile(ModelSignature modelSignature);
    OpenKey OpenKey(Long id);
}
