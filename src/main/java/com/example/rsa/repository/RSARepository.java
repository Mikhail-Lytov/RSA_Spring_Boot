package com.example.rsa.repository;

import com.example.rsa.model.Post;
import com.example.rsa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class RSARepository {
    @Autowired // Создание переменой,ссылающие на репозиторий
    private PostRepository postRepository;

    public Long save(String path, String text_in_file, BigInteger open_exhibitor,BigInteger close_exhibitor,BigInteger derivative){

        System.out.println(close_exhibitor);
        Post post = new Post(path, text_in_file, open_exhibitor.toString(),close_exhibitor.toString(), derivative.toString());
        postRepository.save(post);
        return post.getId();

    }
    public String getOpenExhibitor(long id){
        Post post = postRepository.findById(id).orElseThrow();
        String open_exhibitor = post.getOpen_exhibitor();
        return open_exhibitor;
    }

    public String getDerivative(long id){
        Post post = postRepository.findById(id).orElseThrow();
        String derivative = post.getDerivative();
        return derivative;
    }


}
