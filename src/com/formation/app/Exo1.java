package com.formation.app;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //Exo 1
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


        //Exo 2
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

    //Exo 3

    class Personne {
        private String nom, prenom, genre;
        private int annee_naissance;

        public Personne(String nom, String prenom, String genre, int annee) {
            this.nom = nom;
            this.prenom = prenom;
            this.genre = genre;
            annee_naissance = annee;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getAnnee_naissance() {
            return annee_naissance;
        }

        public void setAnnee_naissance(int annee_naissance) {
            this.annee_naissance = annee_naissance;
        }
}
