package com.example.rsa;

import com.example.rsa.models.Post;
import com.example.rsa.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class RSARepository {
    @Autowired // Создание переменой,ссылающие на репозиторий
    private PostRepository postRepository;

    public void save(String path, String text_in_file, BigInteger open_exhibitor,BigInteger close_exhibitor,BigInteger derivative){
        Post post = new Post(path,text_in_file,open_exhibitor,close_exhibitor,derivative);
        postRepository.save(post);
    }


}
