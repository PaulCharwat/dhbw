package de.paulcharwat.java1.chapter10.aufgaben;

/**
 * Ein Konto mit Kontonummer und Saldo, das Ein- und Auszahlungen unterstützt.
 * 
 * @author ...
 */
public class Konto {
    private final long nummer;      // Kontonummer
    private double saldo = 0;       // aktueller Saldo

    /**
     * Konto-Konstruktor.
     * 
     * @param nummer Kontonummer
     */
    protected Konto(long nummer) {
        super();                    // optional
        this.nummer = nummer;
    }

    /**
     * Liefert die Kontonummer.
     * 
     * @return Kontonummer
     */
    public long getNummer() {
        return nummer;
    }

    /**
     * Liefert den aktuellen Saldo des Kontos.
     * 
     * @return Saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Erhöht den Saldo um den genannten Betrag.
     * 
     * @param betrag negative Werte werden ignoriert
     */
    public void einzahlen(double betrag) {
        if (betrag > 0) {
            saldo += betrag;
        }
    }

    /**
     * Vermindert den Saldo um den genannten Betrag.
     * 
     * @param betrag negative Werte werden ignoriert
     */
    public void auszahlen(double betrag) {
        if (betrag > 0) {
            saldo -= betrag;
        }
    }

    @Override
    public String toString() {
        return nummer + ": " + saldo + " Euro";
    }
}