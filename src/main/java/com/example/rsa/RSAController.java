package com.example.rsa;

import com.example.rsa.model.DataFile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@AllArgsConstructor
public class RSAController {
    private final RSAService rsaService;
    @PostMapping("/signarutefile")
    public FileSystemResource signatureFile(@RequestBody MultipartFile file, @ModelAttribute DataFile text) throws IOException {
        System.out.println(file.getOriginalFilename());
        return rsaService.encryptionFile(file);
    }
}
