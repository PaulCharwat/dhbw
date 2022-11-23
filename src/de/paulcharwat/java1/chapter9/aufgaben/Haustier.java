package de.paulcharwat.java1.chapter9.aufgaben;

public class Haustier {
    private String name;
    private int anzahlBeine;

    public String getName() {
        return name;
    }

    public int getAnzahlBeine() {
        return anzahlBeine;
    }

    protected Haustier(String name) {
        super();
        this.name = name;
    }

    protected Haustier(String name, int anzahlBeine) {
        super(); // optional
        this.name = name;
        this.anzahlBeine = anzahlBeine;
    }

    @Override
    public String toString() {
        return "Name: " + name + "Beine: " + anzahlBeine;
    }
}