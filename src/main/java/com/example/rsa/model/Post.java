package com.example.rsa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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

}
