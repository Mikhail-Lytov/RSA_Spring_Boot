package com.example.rsa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
@Entity
public class Post { //модель, создаёт табличку данных
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // создает для новой записи новое поле
    private Long id;
    private String path;
    private String text_in_file;

    private BigInteger open_exhibitor, close_exhibitor, derivative;

    public Post(String path, String text_in_file, BigInteger open_exhibitor, BigInteger close_exhibitor, BigInteger derivative) {
        this.path = path;
        this.text_in_file = text_in_file;
        this.open_exhibitor = open_exhibitor;
        this.close_exhibitor = close_exhibitor;
        this.derivative = derivative;
    }

    public Post() {
    }

}
