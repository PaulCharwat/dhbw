package de.paulcharwat.java1.chapter7;

public class Auto {
    public static int autoAnzahl;
    public String kennzeichen;
    public String modell;
    private int insassenAnzahl;
    private int tankInhalt;

    public static void main(String[] args) {
        Auto a1 = new Auto("FFB CP 811", "Auto");
        a1.einsteigen(1);
        a1.einsteigen(3);
        a1.aussteigen(2);
        a1.verbrauche(9);
        a1.tanken(10);
        Auto a2 = new Auto("M AC 457", "Auto");
        a2.einsteigen(2);
        a2.tanken(20);
        Auto a3 = new Auto("MSP DC 555", "Auto");
        a3.einsteigen(3);
        a3.tanken(30);
        Auto a4 = new Auto("FFB KC 297", "Motorrad");
        a4.einsteigen(4);
        a4.tanken(40);

        a1.print();
        System.out.println();
        a2.print();
        System.out.println();
        a3.print();
        System.out.println();
        a4.print();
        System.out.println();
        }

    public Auto(String kennzeichen, String modell) {
        this.kennzeichen = kennzeichen;
        this.modell = modell;
        autoAnzahl++;
    }

    public int einsteigen(int insassen) {
        this.insassenAnzahl = this.insassenAnzahl + insassen;
        return this.insassenAnzahl;
        //return this.insassenAnzahl += insassen;
    }

    public int aussteigen(int insassen) {
        return this.insassenAnzahl -= insassen;
    }

    public int tanken(int liter) {
        return this.tankInhalt += liter;
    }

    public int verbrauche(int liter) {
        return this.tankInhalt -= liter;
    }

    public void print() {
        System.out.println("Kennzeichen: " + this.kennzeichen);
        System.out.println("Modell: " + this.modell);
        System.out.println("Insassen: " + this.insassenAnzahl);
        System.out.println("Tankinhalt: " + this.tankInhalt);
    }
}
