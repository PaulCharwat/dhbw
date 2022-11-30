package de.paulcharwat.java1.chapter11;

import java.util.Scanner;

/**
 * Ein abstraktes Spiel, das als Superklasse für konkrete Spiele dient - geeignet
 * sind zugbasierte Ein- oder Mehrpersonenspiele wie Nim, Mau-Mau oder Tic Tac Toe.
 * Die Ausgabe des aktuellen Spielstands, die Eingabe der Spielzüge und
 * die Ausgabe des Ergebnisses erfolgt über die Konsole.
 */
public abstract class Spiel {
    protected static final int OFFEN = -2, UNENTSCHIEDEN = -1;

    protected final Scanner scanner = new Scanner(System.in);
    protected final int spielerAnzahl;
    private int ergebnis = OFFEN;                           // OFFEN, UNENTSCHIEDEN oder Gewinner

    protected Spiel(int spielerAnzahl) {                    // Subklasse bestimmt die Spieleranzahl
        this.spielerAnzahl = spielerAnzahl;
    }

    /**
     * Startet ein Spiel, bei dem solange Züge ausgeführt werden,
     * bis entweder ein Gewinner feststeht oder ein Unentschieden erreicht ist.
     */
    public final void starteSpiel() {                       // Schablonenmethode
        if (ergebnis != OFFEN) {
            System.out.println("Dieses Spiel wurde bereits gespielt.");
            return;
        }
        int spieler = 0;                                    // nächster Spieler (von 0 bis Spieleranzahl - 1)
        do {
            int delta = macheZug(spieler);
            ergebnis = bestimmeErgebnis(spieler);
            spieler = (spieler + delta + spielerAnzahl) % spielerAnzahl;
        } while (ergebnis == OFFEN);
        druckeErgebnis(ergebnis);
        scanner.close();
    }

    /**
     * Erfragt den nächsten Zug des Spielers und führt ihn aus.
     *
     * @param spieler Spieler, der am Zug ist (von 0 bis Spieleranzahl - 1)
     * @return bestimmt, wer den folgenden Zug machen darf (normalerweise: +1)
     */
    protected abstract int macheZug(int spieler);           // Subklasse definiert Verhalten

    /**
     * Überprüft, ob das Spiel noch offen ist oder bereits beendet (Gewinner steht fest bzw. Remis).
     *
     * @param spieler Spieler, der am Zug war (von 0 bis Spieleranzahl - 1)
     * @return <code>OFFEN</code>, <code>UNENTSCHIEDEN</code> oder eine Spielernummer (von 0 bis Spieleranzahl - 1)
     */
    protected abstract int bestimmeErgebnis(int spieler);   // Subklasse definiert Verhalten

    /**
     * Schreibt das Ergebnis des Spiels in die Konsole.
     *
     * @param ergebnis <code>OFFEN</code>, <code>UNENTSCHIEDEN</code> oder die Gewinnernummer (von 0 bis Spieleranzahl - 1)
     */
    protected abstract void druckeErgebnis(int ergebnis);   // Subklasse definiert Verhalten
}