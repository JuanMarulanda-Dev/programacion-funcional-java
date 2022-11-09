package com.platzi.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prueba {

    public static void main(String[] args) {
        String test1 = "(())";
        String test2 = "({()()}[()])";
        String test3 = "{[]}()]";
        String test4 = "]";

        System.out.println(isStringValid(test4));

    }

    private static boolean isStringValid(String cadena){
        Map<Character, Character> closeCharacters = new HashMap(){{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack();

         String cadenaArray[] = cadena.split("");

        for (String i: cadenaArray) {
            Character character = i.charAt(0);
            if(isOpen(character)){
                stack.push(character);
            }else{
                try {
                    Character topChar = stack.pop();

                    if(closeCharacters.get(topChar) != character){
                        return false;
                    }

                }catch (Exception e){
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    private static boolean isOpen(Character character){
        Character[] openCharacteres = {'(', '{', '['};
        return Arrays.stream(openCharacteres).anyMatch(character1 -> character1.equals(character));
    }

}
