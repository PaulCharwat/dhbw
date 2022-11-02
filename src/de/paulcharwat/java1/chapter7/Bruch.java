package de.paulcharwat.java1.chapter7;

public class Bruch {
    public final long zaehler;
    public final long nenner;

    public static void main(String[] args) {
        System.out.println(new Bruch (1,3).toString());
        System.out.println(new Bruch (2,4).toString());
        System.out.println(new Bruch (-2,3).toString());
        System.out.println(new Bruch (2,-3).toString());
        System.out.println(new Bruch (-2,-3).toString());
        System.out.println(new Bruch (1,3).negiere().toString());
        System.out.println(new Bruch (1,3).addiere(new Bruch(1,2)).toString());
        System.out.println(new Bruch (3,4).subtrahiere(new Bruch(5,6)).toString());
        System.out.println(new Bruch (2,3).kehrwert().toString());
        System.out.println(new Bruch (2,3).multipliziere(new Bruch(6,8)).toString());
        System.out.println(new Bruch (3,4).dividiere(new Bruch(5,6)).toString());
        System.out.println(new Bruch (4,6).potenziere(3).toString());
        System.out.println(new Bruch (1,2).istGleich(new Bruch(3,4)));
        System.out.println(new Bruch (3,4).istGleich(new Bruch(6,8)));
        System.out.println(new Bruch (3,4).alsDouble());
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
