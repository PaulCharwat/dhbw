package de.paulcharwat.java1.chapter11;

public enum Kartenfarbe {
    KREUZ, PIK, HERZ, KARO;     // braucht nun ein abschließendes Semikolon

    @Override
    public String toString() {
        switch (this) {         // switch-case funktioniert mit Aufzählungstypen
        case KREUZ:
            return "♣";
        case PIK:
            return "♠";
        case HERZ:
            return "♥";
        case KARO:
            return "♦";
        }
        return null;
    }
}