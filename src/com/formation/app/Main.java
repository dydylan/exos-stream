package com.formation.app;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.1)");
        int[] intArray = new Random().ints(6, 1, 20).sorted().toArray();
        Arrays.stream(intArray).forEach(System.out::println);

        System.out.println();
        System.out.println("1.2)");
        OptionalInt firstInt = Arrays.stream(intArray).findFirst();
        System.out.println(firstInt.getAsInt());

        System.out.println();
        System.out.println("1.3)");
        int sum = 0;
        sum = IntStream.of(intArray).filter((i)->i>3).sum();
        System.out.println(sum);


        System.out.println();
        System.out.println();
        System.out.println("2.1)");
        int[] tab = {-9, 3, -8, 7, -6, 2, -1};
        System.out.println("Les nombres positifs : ");
        afficherPositifs(tab);
    }

    public static void afficherPositifs(int[] tab) {
        MyFilter<int[]> filter = vars -> {
            for (int i : vars) {
                if (i > 0) System.out.println(i);
            }
        };
        filter.apply(tab);
    }
}
