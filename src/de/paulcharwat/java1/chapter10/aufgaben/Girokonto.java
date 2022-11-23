package de.paulcharwat.java1.chapter10.aufgaben;

public class Girokonto extends Konto {

    public Girokonto(long nummer) {
        super(nummer);
        this.einzahlen(50);
    }
}
