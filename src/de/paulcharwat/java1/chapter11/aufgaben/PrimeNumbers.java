package de.paulcharwat.java1.chapter11.aufgaben;

import java.util.Scanner;

public class PrimeNumbers {

    /**
     * Generiert die ersten <code>size</code> Primzahlen und gibt sie
     * aufsteigend sortiert als Feld zurück.
     * 
     * @param size Anzahl der zu generierenden Primzahlen
     * @return Feld der Größe <code>size</code> mit den ersten Primzahlen
     */
    public static int[] generatePrimes(int size) {
        int[] primes = new int[size];
        int x = 0;
        for (int i = 2; x < size; i++) {
            boolean isPrimzahl = true;
            for (int j = 2; j < i && isPrimzahl; j++) {
                if ((i % j) == 0) {
                    isPrimzahl = false;
                }
            }
            if (isPrimzahl) {
                primes[x++] = i;
            }
        }
        return primes;
    }

    /**
     * Gibt das angegebene <code>int</code>-Feld auf der Konsole aus.
     * 
     * @param values
     */
    public static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            System.out.print(", ");
        }
    }

    public static void main(String[] args) {
        System.out.print("Wie viele Primzahlen sollen generiert werden? ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();
        int[] primes = generatePrimes(size);
        System.out.print("Ergebnis:");
        print(primes);
    }
}