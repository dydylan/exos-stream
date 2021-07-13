package com.formation.app;

public class Exo2 {

    public static void main(String[] args) {
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
