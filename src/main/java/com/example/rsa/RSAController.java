package com.example.rsa;

import com.example.rsa.model.DataFile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@AllArgsConstructor
public class RSAController {

    @PostMapping("/signarutefile")
    public String signatureFile(@RequestBody MultipartFile file, @ModelAttribute DataFile text){
        return "Ну типо";
    }
}
