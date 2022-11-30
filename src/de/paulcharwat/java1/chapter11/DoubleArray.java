package de.paulcharwat.java1.chapter11;

public class DoubleArray {
    public static void main(String[] args) {
        double[] feld = new double[3]; // Feld-Deklaration und -Initialisierung
        System.out.println(feld[0] + " " + feld[1] + " " + feld[2]);
        feld[0] = 10; // Zuweisung an eine Feldkomponente
        feld[1] = 20;
        feld[2] = 30;
        // feld[3] = 40; // Laufzeitfehler -> java.lang.ArrayIndexOutOfBoundsException
        System.out.println(feld[0] + " " + feld[1] + " " + feld[2]);
    }

}
