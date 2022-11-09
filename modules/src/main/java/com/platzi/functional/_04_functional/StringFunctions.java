package com.platzi.functional._04_functional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        System.out.println(quote.apply("Hola mundo"));

        BinaryOperator<String> concatenar = (text, symbol) -> text + symbol;
        System.out.println(concatenar.apply("Hola mundo", "!"));

        BiFunction<Integer, Integer, Integer> multiplicacion = (x, y) -> x * y;
        System.out.println(multiplicacion.apply(5, 5));

        List<BiFunction<String, Integer, String>> formateadores;

    }
}
