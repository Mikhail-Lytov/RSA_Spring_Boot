package com.example.rsa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post { //модель, создаёт табличку данных
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // создает для новой записи новое поле
    private Long id;
    private String path;
    private String signed_file;
    private String open_exhibitor,  derivative,  close_exhibitor;
    //private String close_exhibitor = "10515633502775227735107121108518308219115772037878032934818544518386351171346578592019726881470777485027869017842062197800631638262874513401963986033240061762479895854447719811408329384317760680494647873389392582167924875619392468732758787541519622259264108751836280243846414294784847037467683458798552265293841979390148971920480192710826566412887525851511850067991276457023477600784841805770719509199805083466828056418929364319847829204954065502453246635524000173366674616460463030487585041758567913595675458292640520781807942768084453498841202120783020793257803418631400007008145596392413764270146760836082693191571";
    public Post(String path, String signed_file, String open_exhibitor, String close_exhibitor, String derivative) {
        this.path = path;
        this.signed_file = signed_file;
        this.open_exhibitor = open_exhibitor;
        this.close_exhibitor = close_exhibitor;
        this.derivative = derivative;
    }

    public Post() {
    }

}
