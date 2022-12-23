package de.paulcharwat.java1.chapter11;

public enum Kartenrang {
    SIEBEN("7"), ACHT("8"), NEUN("9"), ZEHN("10"),  // jede Konstante übergibt nun an den ...
    BUBE("B"), DAME("D"), KOENIG("K"), AS("A");     // ... Konstruktor ihre String-Darstellung

    private final String kurzform;                  // Instanzvariable für die String-Darstellung

    private Kartenrang(String kurzform) {           // Konstruktor, der die String-Darstellung annimmt
        this.kurzform = kurzform;
    }

    public boolean istBildkarte() {
        return this == BUBE || this == DAME || this == KOENIG;
    }

    @Override
    public String toString() {
        return kurzform;                            // gibt die String-Darstellung zurück
    }
}