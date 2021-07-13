package com.formation.app;

import java.util.Comparator;
import java.util.List;

public class Exo3 {

    static class Personne {
        private String nom, prenom, genre;
        private int annee_naissance;

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getGenre() {
            return genre;
        }

        public int getAnnee_naissance() {
            return annee_naissance;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setAnnee_naissance(int annee_naissance) {
            this.annee_naissance = annee_naissance;
        }

        public Personne(String prenom, String nom, String genre, int annee) {
            this.nom = nom;
            this.prenom = prenom;
            this.genre = genre;
            annee_naissance = annee;
        }

        @Override
        public String toString() {
            return "Personne{" +
                    "nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", genre='" + genre + '\'' +
                    ", annee_naissance=" + annee_naissance +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Personne> persons = List.of(
                new Personne ("Laure", "BARBE", "F", 1994),
                new Personne ("Rihab", "BETTAIEB",  "F",1991),
                new Personne ("Aurelien", "DEMOLY", "H", 1993),
                new Personne ("Tanguy" , "NGUYEN", "H", 1992),
                new Personne ("Laura", "TENET", "F", 1995),
                new Personne ("Matthieu", "BILLAUD", "H", 1992),
                new Personne ("Martin", "TOGNETTI", "h", 1988),
                new Personne ("Simon", "MAILLARD", "H", 1975),
                new Personne ("Baptiste", "BLANCHET", "A", 1985),
                new Personne ("Michel", "HADOCK", "A", 1985)
                new Personne ("Jean", "HADOCK", "H", 1975),
        );

        System.out.println("Les personnes nées après 1991 :");
        persons.stream()
                .filter(p -> p.getAnnee_naissance()>1991)
                .map(Personne::getNom)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Le nom des personnes nées en 1995 :");
        persons.stream()
                .filter(p -> p.getAnnee_naissance()==1995)
                .map(Personne::getNom)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Le nom des personnes nées avant 1990, triés par ordre alphabétique sur leur nom, et leur nombre :");
        persons.stream()
                .filter(p -> p.getAnnee_naissance()<1990)
                .map(Personne::getNom).sorted()
                .forEach(System.out::println);
        System.out.println(persons.stream()
                .filter(p -> p.getAnnee_naissance()<1990).count());

        System.out.println();
        System.out.println("Les noms et prénoms, triés par ordre alphabétique sur leur nom et leur prénom");
        persons.stream()
                .sorted(Comparator.comparing(Personne::getNom))
                .sorted(Comparator.comparing(Personne::getPrenom))
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Les personnes ayant un genre \"F\" et le nom qui commence par la lettre ‘j’");
        persons.stream()
                .filter(p ->p.getGenre().equals("F"))
                .filter(p ->p.getNom().startsWith("J"))
                .map(Personne::getNom)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Le genre en lettre minuscule de ceux ayant un genre \"h\".");
        persons.stream()
                .filter(p ->p.getGenre().equals("H"))
                .map(Personne::getGenre)
                .forEach(System.out::println);
    }
}
