package de.paulcharwat.java1.chapter10.aufgaben;

public class BankDemo {
    public static void main(String[] args) {
        Konto konto = new Konto(0);
        Konto sparbuch = new Sparbuch(1);
        Konto girokono = new Girokonto(2);

        System.out.println(konto.getSaldo());
        System.out.println(sparbuch.getSaldo());
        System.out.println(girokono.getSaldo());

        konto.auszahlen(10);
        sparbuch.auszahlen(10);
        girokono.auszahlen(10);

        System.out.println(konto.getSaldo());
        System.out.println(sparbuch.getSaldo());
        System.out.println(girokono.getSaldo());
    }
}
