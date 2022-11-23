package de.paulcharwat.java1.chapter10;

public class Nim extends Spiel {
    private static final int START = 50;            // Anzahl zu Beginn
    private static final int MAX = 10;              // max. Anzahl für einen Zug

    private int anzahl = START;                     // aktuelle Anzahl

    public Nim() {
        super(2);                                   // Nim ist ein Zweipersonenspiel
    }

    @Override
    protected int macheZug(int spieler) {
        System.out.print("Anzahl: " + anzahl + ", Spieler #" + spieler + " (1-" + MAX + ")? ");
        int zug;
        do {
            zug = scanner.nextInt();
        } while (zug < 1 || zug > MAX);             // wdh. wenn Eingabe ungültig
        anzahl -= zug;                              // Anzahl reduzieren
        return 1;                                   // der andere Spieler ist dran
    }

    @Override
    protected int bestimmeErgebnis(int spieler) {
        if (anzahl < 1) {                           // letzter entfernt?
            return spieler;                         // aktueller Spieler hat gewonnen
        }
        return OFFEN;
    }

    @Override
    protected void druckeErgebnis(int ergebnis) {
        System.out.println("Spieler #" + ergebnis + " hat gewonnen.");
    }

    public static void main(String[] args) {
        new Nim().starteSpiel();                    // neues Nim-Spiel starten
    }
}