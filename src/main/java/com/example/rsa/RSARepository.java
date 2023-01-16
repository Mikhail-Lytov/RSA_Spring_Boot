package com.example.rsa;

import com.example.rsa.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RSARepository {
    @Autowired // Создание переменой,ссылающие на репозиторий
    private PostRepository postRepository;


}
