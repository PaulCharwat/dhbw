package de.paulcharwat.java1.chapter11;

public class Karte {
    private final Kartenfarbe farbe;
    private final Kartenrang rang;

    public Karte(Kartenfarbe farbe, Kartenrang rang) {
        super();
        this.farbe = farbe;
        this.rang = rang;
    }

    public Kartenfarbe getFarbe() {
        return farbe;
    }

    public Kartenrang getRang() {
        return rang;
    }

    @Override
    public String toString() {
        return farbe + "-" + rang;
    }
}