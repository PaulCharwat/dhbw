package de.paulcharwat.java1.chapter11;

public class Hand extends Karten {
    public Hand(int maxAnzahl) {
        super(maxAnzahl);
    }

    @Override
    public String toString() {
        return "Hand mit " + super.toString();
    }
}