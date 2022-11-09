package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MatchFunction {
    public static void main(String[] args) {
        Function<Integer,Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        //System.out.println(squareFunction.apply(5));
        //System.out.println(squareFunction.apply(25));

        //System.out.println(square(5));

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        // Un Predicate no es más que una función que trabaja sobre un tipo y genera un boolean.
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(2));

        Predicate<Student> isApprovated = student -> student.getCalificacion() > 6.0;
        Student student = new Student(5.9);
        System.out.println(isApprovated.test(student));

    }

    static class Student {
        private double calificacion;

        public Student(double calificacion) {
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }

        public void setCalificacion(double calificacion) {
            this.calificacion = calificacion;
        }
    }

    static int square(int x){
      return x * x;
    };
}
