package de.paulcharwat.java1.chapter7;

public class Bruch {
    public final long zaehler;
    public final long nenner;

    public static void main(String[] args) {
        
    }

    public Bruch(long zaehler, long nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public Bruch negiere() {
        return new Bruch(-this.zaehler, this.nenner);
    }

    public Bruch addiere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.nenner + bruch.zaehler * this.nenner, this.nenner * bruch.nenner);
    }

    public Bruch subtrahiere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.nenner - bruch.zaehler * this.nenner, this.nenner * bruch.nenner);
    }

    public Bruch kehrwert() {
        return new Bruch(this.nenner, this.zaehler);
    }

    public Bruch multipliziere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.zaehler, this.nenner * bruch.nenner);
    }

    public Bruch dividiere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.nenner, this.nenner * bruch.zaehler);
    }

    public Bruch potenziere(int exponent) {
        return new Bruch((long) Math.pow(this.zaehler, exponent), (long) Math.pow(this.nenner, exponent));
    }

    public boolean istGleich(Bruch bruch) {
        return this.zaehler * bruch.nenner == bruch.zaehler * this.nenner;
    }

    public double alsDouble() {
        return (double) this.zaehler / this.nenner;
    }

    public String toString() {
        return this.zaehler + "/" + this.nenner;
    }
}
