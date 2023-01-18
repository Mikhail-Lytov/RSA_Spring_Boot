package com.example.rsa.controller;

import com.example.rsa.model.ModelSignature;
import com.example.rsa.model.ModelSignatureUser;
import com.example.rsa.model.OpenKey;
import com.example.rsa.service.RSAService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class RSAController {
    private final RSAService rsaService;




    @PostMapping("/signarutefile")
    public ModelSignatureUser signaruteFile(@RequestBody ModelSignature dataFile){
        return rsaService.encryptionFile(dataFile);
    }
    @GetMapping("/open_key/{id}")
    public OpenKey getOpenKey(@PathVariable(value = "id") long id){
        return rsaService.OpenKey(id);
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
