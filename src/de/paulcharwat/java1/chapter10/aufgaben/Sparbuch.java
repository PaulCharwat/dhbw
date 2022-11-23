package de.paulcharwat.java1.chapter10.aufgaben;

public class Sparbuch extends Konto {

    public Sparbuch(long nummer) {
        super(nummer);
    }

    @Override
    public void auszahlen(double betrag) {
        if (betrag > 0) {
            if (this.getSaldo() > betrag) {
                this.auszahlen(betrag);
            }
        }
    }
}
