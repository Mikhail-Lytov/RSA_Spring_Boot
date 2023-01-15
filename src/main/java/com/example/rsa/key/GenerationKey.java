package com.example.rsa.key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Random;

import static java.math.BigInteger.probablePrime;


@Getter
public class GenerationKey {
    private BigInteger open_exhibitor = BigInteger.ONE;
    private BigInteger close_exhibitor;
    private BigInteger euler_function;
    private int maxleng = 1024;
    private BigInteger second_number;
    private BigInteger derivative;
    private BigInteger first_number;

    public GenerationKey(){
        key_generation();
    }
    public void key_generation(){
        first_number = probablePrime(1024,new Random());
        second_number = probablePrime(1024, new Random());
        derivative = first_number.multiply(second_number);
        BigInteger first_number_sub_1 = first_number.subtract(BigInteger.ONE);
        BigInteger second_number_sub_1 = second_number.subtract(BigInteger.ONE);
        euler_function = first_number_sub_1.multiply(second_number_sub_1);
        generation();

    }
    private void generation(){
        open_exhibitor = probablePrime(maxleng / 2, new Random());
        while (euler_function.gcd(open_exhibitor).compareTo(BigInteger.ONE) > 0 && open_exhibitor.compareTo(euler_function) < 0){
            open_exhibitor.add(BigInteger.ONE);
        }

        close_exhibitor = open_exhibitor.modInverse(euler_function);
    }
}
