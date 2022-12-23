package de.paulcharwat.java1.chapter11;

import static de.paulcharwat.java1.chapter11.Kartenfarbe.*; // statischer Import aller Kartenfarben
import static de.paulcharwat.java1.chapter11.Kartenrang.*;  // statischer Import aller Kartenränge

public class KarteDemo {
    public static void main(String[] args) {
        Karte karte1 = new Karte(KREUZ, BUBE);          // direkter Zugriff auf importierte Werte
        Karte karte2 = new Karte(HERZ, ZEHN);           // direkter Zugriff auf importierte Werte

        System.out.println(karte1.getFarbe());
        System.out.println(karte1.getRang());
        System.out.println(karte2);
    }
}