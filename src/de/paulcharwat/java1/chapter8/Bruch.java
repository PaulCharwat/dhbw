package de.paulcharwat.java1.chapter8;

public class Bruch {
    public static final Bruch NULL = new Bruch(0, 1);
    public static final Bruch EINS = new Bruch(1, 1);
    public static final Bruch MINUSEINS = new Bruch(-1, 1);
    public static final Bruch HALB = new Bruch(1, 2);
    public static final Bruch ZWEI = new Bruch(2, 1);

    private final long zaehler;
    private final long nenner;

    public static Bruch getBruch(long zaehler, long nenner) {
        if (nenner == 0) {
            return null;
        } else if (zaehler == 0) {
            return NULL;
        } else if (zaehler == nenner) {
            return EINS;
        } else if (-zaehler == nenner) {
            return MINUSEINS;
        } else if (zaehler == nenner * 2) {
            return HALB;
        } else if (zaehler == nenner / 2) {
            return ZWEI;
        }
        return new Bruch(zaehler, nenner);
    }

    private Bruch(long zaehler, long nenner) {
        long ggt = ggT(zaehler, nenner);

        if (nenner < 0) {
            this.zaehler = -(zaehler / ggt);
            this.nenner = -(nenner / ggt);
        } else {
            this.zaehler = zaehler / ggt;
            this.nenner = nenner / ggt;
        }

    }

    private static long ggT(long x, long y) {
        if (x == y) {
            return x;
        }
        if (x > y) {
            return ggT(x - y, y);
        }
        return ggT(x, y - x);
    }

    public Bruch addiere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.nenner + bruch.zaehler * this.nenner, this.nenner * bruch.nenner);
    }

    public Bruch subtrahiere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.nenner - bruch.zaehler * this.nenner, this.nenner * bruch.nenner);
    }

    public Bruch multipliziere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.zaehler, this.nenner * bruch.nenner);
    }

    public Bruch dividiere(Bruch bruch) {
        return new Bruch(this.zaehler * bruch.nenner, this.nenner * bruch.zaehler);
    }

    public Bruch negiere() {
        return new Bruch(-this.zaehler, this.nenner);
    }

    public Bruch kehrwert() {
        return new Bruch(this.nenner, this.zaehler);
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

    public static Bruch kuerzen(Bruch bruch) {
        long zaehler = bruch.zaehler;
        long nenner = bruch.nenner;
        long teiler = Calculator.ggT(zaehler, nenner);
        return new Bruch(zaehler / teiler, nenner / teiler);
    }

    public String toString() {
        return this.zaehler + "/" + this.nenner;
    }

}
