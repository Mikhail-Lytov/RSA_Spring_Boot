package com.example.rsa;

import com.example.rsa.models.ModelSignature;
import com.example.rsa.models.ModelSignatureUser;
import com.example.rsa.models.Post;
import com.example.rsa.repo.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@AllArgsConstructor
public class RSAController {
    private final RSAService rsaService;




    @PostMapping("/signarutefile")
    public ModelSignatureUser signaruteFile(@RequestBody ModelSignature dataFile){
        return rsaService.encryptionFile(dataFile);
    }
    /*@GetMapping("/RSA")
    public String blogmain(Model model){
        Iterable<Post> posts = postRepository.findAll();       //Массив данных из таблицы
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @PostMapping("/blog")
    public String RSA_LOL(){
        Post post  = new Post();
        postRepository.save(post);
        return "";
    }*/

   /* @PostMapping("/signarutefile")
    public FileSystemResource signatureFile(@RequestBody MultipartFile file, @ModelAttribute DataFile text) throws IOException {
        System.out.println(file.getOriginalFilename());
        return rsaService.encryptionFile(file);
    }*/
}
