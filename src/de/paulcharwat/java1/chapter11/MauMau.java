package de.paulcharwat.java1.chapter11;

/**
 * Mau-Mau ist ein Kartenspiel für zwei oder mehr Personen, bei dem der gewinnt, der zuerst keine Karten mehr hat.
 * Zu Beginn erhält jeder Spieler fünf Karten aus dem verwendeten <code>Blatt</code>, hier ein Skatblatt.
 * Eine Karte wird aufgedeckt, reihum legen die Spieler jeweils eine passende Karte offen darauf ab.
 * Passen tut eine Karte dann, wenn sie in Farbe oder Rang mit der obersten Karte übereinstimmt.
 * Die einzige Ausnahme bilden Buben: Sie passen immer, der Spieler darf sich eine Kartenfarbe wünschen.
 * Hat jemand keine passende Karte, muss eine vom verdeckten Stapel der restlichen Karten gezogen werden.
 * Eine besondere Rolle spielen Siebenen und Achten:
 * Wird eine Sieben gespielt, muss der nachfolgende Spieler zwei ziehen, bei einer Acht muss er aussetzen.
 * (Sind die restlichen Karten verbraucht, wird der Stapel der abgelegten Karten ohne die oberste neu gemischt.)
 * <p>
 * Der Start eines neuen Spiels erfolgt mit <code>new MauMau(spielerAnzahl).starteSpiel();</code>.
 */
public class MauMau extends Spiel {
    private final Hand[] haende;                // eine Hand pro Spieler
    private Blatt verdeckterStapel;             // der verdeckte Stapel zum Ziehen neuer Karten
    private Karten gespielteKarten;             // die offenen, bereits ausgespielten Karten
    private boolean zweiZiehen = false;         // Flag, ob noch zwei Karten zu ziehen sind
    private Kartenfarbe wunschfarbe = null;     // letzte Wunschfarbe bei Bubenausspiel
    private boolean zuWenigKarten = false;      // Flag, ob die Karten ausgegangen sind -> Ende

    public MauMau(int spielerAnzahl) {
        super(spielerAnzahl);                                   // Aufruf des Spiel-Konstruktors
        verdeckterStapel = new Blatt();                         // neues Skat-Blatt nehmen
        verdeckterStapel.mische();                              // mischen
        haende = verdeckterStapel.teileAus(spielerAnzahl, 5);   // jeder Spieler bekommt 5 Karten
        gespielteKarten = new Karten(Blatt.MAX_ANZAHL);
        spieleKarte(verdeckterStapel.zieheObersteKarte());      // oberste Karte aufdecken
    }

    @Override
    protected int macheZug(int spieler) {
        Karte zuletztGespielteKarte = gespielteKarten.getObersteKarte();
        System.out.print("\nZuletzt gespielte Karte: " + zuletztGespielteKarte);

        switch (zuletztGespielteKarte.getRang()) {              // besondere Fälle? 7 oder Bube
        case SIEBEN:
            if (zweiZiehen) {                                   // 7 und noch nicht gezogen
                haende[spieler].fuegeHinzu(zieheNeueKarte());
                haende[spieler].fuegeHinzu(zieheNeueKarte());
                zweiZiehen = false;
                System.out.print(" - zwei gezogen");
            }
            break;
        case BUBE:                                              // Bube
            System.out.print(" - Wunschfarbe: " + wunschfarbe);
            break;
        default:                                                // sonst: normaler Spielverlauf
        }

        System.out.print("\nKartenanzahlen:");                  // Ausgabe: #Karten der Spieler
        for (Hand hand : haende) {
            System.out.print(" " + hand.getAnzahl());
        }                                                       // Ausgabe: Blatt des aktuellen Spielers
        System.out.println("\nSpieler #" + spieler + " - " + haende[spieler]);
        System.out.print("Spielzug (Karte 0…" + (haende[spieler].getAnzahl() - 1) + " oder -1 für eine ziehen): ");

        boolean karteGespielt = waehleKarte(haende[spieler]);   // Spieler wählt Karte zum Ausspielen
        if (karteGespielt) {                                    // falls 8 gespielt wurde, übernächster, sonst nächster
            return gespielteKarten.getObersteKarte().getRang() == Kartenrang.ACHT ? 2 : 1;
        } else {
            return 1;                                           // falls eine Karte gezogen wurde, nächster Spieler
        }
    }

    private boolean waehleKarte(Hand hand) {                    // eine Karte aus der Hand spielen bzw. eine Karte ziehen
        while (true) {
            int kartenIndex = scanner.nextInt();
            if (kartenIndex >= 0 && kartenIndex < hand.getAnzahl()) {   // Karte ausgewählt?
                if (istGueltigerZug(gespielteKarten.getObersteKarte(), hand.getKarte(kartenIndex))) {
                    Karte karte = hand.zieheKarte(kartenIndex); // Karte ausspielen
                    spieleKarte(karte);
                    return true;                                // es wurde eine Karte gespielt, Verlassen der Schleife
                }
            } else if (kartenIndex == -1) {                     // Eingabe -1 bedeutet: eine ziehen
                hand.fuegeHinzu(zieheNeueKarte());              // Karte ziehen
                return false;                                   // es wurde keine Karte gespielt, Verlassen der Schleife
            }
        }
    }

    private boolean istGueltigerZug(Karte obersteKarte, Karte neueKarte) {  // passt die neue Karte auf die oberste Karte?
        if (obersteKarte.getRang() == Kartenrang.BUBE) {        // liegt Bube oben?
            return neueKarte.getRang() == Kartenrang.BUBE || neueKarte.getFarbe() == wunschfarbe;   // "Bube auf Bube ist ok"
//          return neueKarte.getRang() != Kartenrang.BUBE && neueKarte.getFarbe() == wunschfarbe;   // "Bube auf Bube brennt"
        }
        if (obersteKarte.getFarbe() == neueKarte.getFarbe()) {  // passt die Farbe?
            return true;
        }
        if (obersteKarte.getRang() == neueKarte.getRang()) {    // passt der Rang?
            return true;
        }
        if (neueKarte.getRang() == Kartenrang.BUBE) {           // Bube geht immer auf Nicht-Bube
            return true;
        }
        return false;                                           // andere passen nicht
    }

    private void spieleKarte(Karte karte) {                     // diese Karte ausspielen
        gespielteKarten.fuegeHinzu(karte);
        if (karte.getRang() == Kartenrang.SIEBEN) {             // besondere Karte? 7 oder Bube
            zweiZiehen = true;
        } else if (karte.getRang() == Kartenrang.BUBE) {
            waehleWunschfarbe();
        }
    }

    private void waehleWunschfarbe() {
        int farbenIndex;
        do {                                                    // wiederholen bis Eingabe ok
            System.out.print("Gewünschte Farbe");
            for (Kartenfarbe farbe : Kartenfarbe.values()) {    // Ausgabe: alle Kartenfarben
                System.out.print(" " + farbe.ordinal() + "-" + farbe);
            }
            System.out.print("? ");
            farbenIndex = scanner.nextInt();                    // Eingabe: Index für Kartenfarbe
        } while (farbenIndex < 0 || farbenIndex >= Kartenfarbe.values().length);

        wunschfarbe = Kartenfarbe.values()[farbenIndex];        // Wunschfarbe setzen
    }

    private Karte zieheNeueKarte() {    // liefert null, wenn Stapel leer und nur eine gespielte Karte vorhanden!
        if (verdeckterStapel.getAnzahl() == 0) {                // Stapel leer?
            if (gespielteKarten.getAnzahl() > 1) {              // gibt es noch gespielte Karten?
                while (gespielteKarten.getAnzahl() > 1) {       // dann nehme alle bis auf eine
                    verdeckterStapel.fuegeHinzu(gespielteKarten.zieheKarte(0));
                }
                verdeckterStapel.mische();                      // mischen
                System.out.println("\nVerdeckten Stapel mit " + verdeckterStapel.getAnzahl() + " Karten neu aufgesetzt.");
            } else {                                            // es gibt keine gespielten Karten mehr
                zuWenigKarten = true;                           // Flag für Spielende setzen
            }
        }
        return verdeckterStapel.zieheObersteKarte();            // nächste Karte ziehen
    }

    @Override
    protected int bestimmeErgebnis(int spieler) {
        if (haende[spieler].getAnzahl() == 0) {                 // hat der Spieler keine Karten mehr?
            return spieler;                                     // dann hat er gewonnen
        }
        return zuWenigKarten ? UNENTSCHIEDEN : OFFEN;           // sonst: Karten verbraucht oder weiter
    }

    @Override
    protected void druckeErgebnis(int ergebnis) {               // Ausgabe des Ergebnisses
        System.out.println("\n" + (ergebnis == UNENTSCHIEDEN ? "Zu wenig Karten." : "Spieler #" + ergebnis + " hat gewonnen."));
    }

    public static void main(String[] args) {
        new MauMau(2).starteSpiel();                            // neues Mau-Mau-Spiel für drei Personen starten
    }
}