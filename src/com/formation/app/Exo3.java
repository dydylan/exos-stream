package com.formation.app;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Exo3 {

    static class Personne {
        private String nom, prenom, genre, ville;
        private int annee_naissance;


        private double salaire;

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

        public String getVille() { return ville; }

        public double getSalaire() { return salaire; }


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

        public void setVille(String ville) { this.ville = ville; }

        public void setSalaire(double salaire) { this.salaire = salaire; }


        public Personne(String prenom, String nom, String genre, int annee, double salaire, String ville) {
            this.nom = nom;
            this.prenom = prenom;
            this.genre = genre;
            annee_naissance = annee;
            this.salaire = salaire;
            this.ville = ville;
        }

        @Override
        public String toString() {
            return "Personne{" +
                    "nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", genre='" + genre + '\'' +
                    ", ville='" + ville + '\'' +
                    ", annee_naissance=" + annee_naissance +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Personne> persons = List.of(
                new Personne ("Laure", "BARBE", "F", 1994, 2360.50, "Nantes"),
                new Personne ("Rihab", "BETTAIEB",  "F",1991, 2040.90, "Nantes"),
                new Personne ("Aurelien", "DEMOLY", "H", 1993, 2000.0, "Rennes"),
                new Personne ("Tanguy" , "NGUYEN", "H", 1992, 2300.0, "Lille"),
                new Personne ("Laura", "TENET", "F", 1995, 2205.89, "Lyon"),
                new Personne ("Matthieu", "BILLAUD", "H", 1992, 2650.70, "Paris"),
                new Personne ("Martin", "TOGNETTI", "h", 1988, 1980.0, "Bordeaux"),
                new Personne ("Simon", "MAILLARD", "H", 1975, 3022.39, "Lyon"),
                new Personne ("Baptiste", "BLANCHET", "A", 1985, 2380.70, "Lyon")
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
                .map(p ->{
                    p.setGenre(p.getGenre().toLowerCase());
                    return p;
                })
                .filter(p -> p.getGenre().equals("h"))
                .forEach(System.out::println);


        System.out.println();
        System.out.println("La moyenne des salaires dans la ville de Lyon");
        persons.stream()
                .filter(personne -> personne.getVille().equals("Lyon"))
                .mapToDouble(Personne::getSalaire).average()
                .ifPresent(System.out::println);
    }
}
