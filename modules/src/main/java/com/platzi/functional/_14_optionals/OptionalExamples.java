package com.platzi.functional._14_optionals;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        List<String> names = getNames();
        if(names != null){
            // Operar con nombres.
        }

        Optional<List<String>> optionalNames = getOptionalNames();
        if(optionalNames.isPresent()){

        }

        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));
        //optionalNames.flatMap();
        //optionalNames.map();

        Optional<String> valuablePlayer = optionalValueablePlayer();
        String valueablePlayerName = valuablePlayer.orElseGet(() -> "No Player");
    }

    static List<String> getNames(){
        List<String> list = new LinkedList<>();

        return Collections.emptyList();
    }

    static String mostValueablePlayer(){
        return null;
    }

    static int mostExpensiveItem(){
        return -1;
    }

    static Optional<List<String>> getOptionalNames(){
        List<String> nameList = new LinkedList<>();

        return Optional.of(nameList);
        //return Collections.emptyList();
    }

    static Optional<String> optionalValueablePlayer(){
        //return Optional.ofNullable();
        try {

            return Optional.of("Juan David");
        }catch (Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

}
