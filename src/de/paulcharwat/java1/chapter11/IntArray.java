package de.paulcharwat.java1.chapter11;

public class IntArray {

    public static int[] primzahlen = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79,
            83, 89, 97 };

    public static void main(String[] args) {
        int[] quadratzahlen = new int[10]; // Feld-Deklaration und Initialisierung
        for (int index = 0; index < 10; index++) {
            quadratzahlen[index] = index * index; // Setzen der aktuellen Feldkomponente
        }

        System.out.println("Drei zum Quadrat ist " + quadratzahlen[3]);
        System.out.println("Acht zum Quadrat ist " + quadratzahlen[8]);

        int sum = 0;
        for (int index = 0; index < 10; index++) {
            sum += quadratzahlen[index]; // Auslesen der aktuellen Feldkomponente
        }
        System.out.println("Die Summe der Quadratzahlen von 0^2 bis 9^2 ist " + sum);

        // durchlaufe alle Primzahlen und gebe sie aus (zwei Varianten)

        for (int index = 0; index < primzahlen.length; index++) { // mit herkömmlicher for-Schleife
            System.out.println(index + " - " + primzahlen[index]);
        }

        for (int primzahl : primzahlen) { // mit erweiterter for-Schleife
            System.out.println(primzahl);
        }
    }
}
