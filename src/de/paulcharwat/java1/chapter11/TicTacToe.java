package de.paulcharwat.java1.chapter11;

/**
 * Tic Tac Toe ist ein Zweipersonenspiel, das auf einem 3x3-Feld gespielt wird.
 * Die Spieler setzen abwechselnd ihre Steine. Wer zuerst drei in einer Reihe
 * hat (horizontal, vertikal oder diagonal), hat gewonnen. Gelingt dies keinem
 * der beiden, bevor das Spielfeld voll ist, endet das Spiel unentschieden.
 * <p>
 * Der Start eines neuen Spiels erfolgt mit <code>new TicTacToe().starteSpiel();</code>.
 */
public class TicTacToe extends Spiel {
    private static final char[] symbole = {'X', 'O'};   // Symbole der Spieler

    private char[][] spielfeld = new char[][] {         // Spielfeld mit Rahmen
        {'┌', '─', '─', '─', '┐'},                      // Zeile 0 (oberer Rand) bis ...
        {'│', ' ', ' ', ' ', '│'},
        {'│', ' ', ' ', ' ', '│'},
        {'│', ' ', ' ', ' ', '│'},
        {'└', '─', '─', '─', '┘'}                       // ... Zeile 4 (unterer Rand)
    };
    private int zugAnzahl = 0;                          // Anzahl der getätigten Züge

    public TicTacToe() {
        super(2);                                       // Tic Tac Toe ist ein Zweipersonenspiel
    }

    @Override
    protected int macheZug(int spieler) {
        druckeSpielfeld();
        int zeile, spalte;
        do {                                            // wiederholen bis gültige Eingabe vorliegt
            System.out.print("Zug für Spieler " + symbole[spieler] + " (Zeile↩, Spalte↩): ");
            zeile = scanner.nextInt();
            spalte = scanner.nextInt();
        } while (Math.min(zeile, spalte) < 1 || Math.max(zeile, spalte) > 3 || spielfeld[zeile][spalte] != ' ');
        spielfeld[zeile][spalte] = symbole[spieler];
        zugAnzahl++;
        return 1;
    }

    @Override
    protected int bestimmeErgebnis(int spieler) {       // nach drei gleichen in einer Reihe suchen
        for (int zeile = 1; zeile <= 3; zeile++) {      // alle Zeilen prüfen
            char ersterInZeile = spielfeld[zeile][1];
            if ((ersterInZeile != ' ') && (ersterInZeile == spielfeld[zeile][2]) && (ersterInZeile == spielfeld[zeile][3])) {
                return spieler;
            }
        }
        for (int spalte = 1; spalte <= 3; spalte++) {   // alle Spalten prüfen
            char ersterInSpalte = spielfeld[1][spalte];
            if ((ersterInSpalte != ' ') && (ersterInSpalte == spielfeld[2][spalte]) && (ersterInSpalte == spielfeld[3][spalte])) {
                return spieler;
            }
        }
        char obenLinks = spielfeld[1][1];               // absteigende Diagonale prüfen
        if ((obenLinks != ' ') && (obenLinks == spielfeld[2][2]) && (obenLinks == spielfeld[3][3])) {
            return spieler;
        }
        char untenLinks = spielfeld[3][1];              // aufsteigende Diagonale prüfen
        if ((untenLinks != ' ') && (untenLinks == spielfeld[2][2]) && (untenLinks == spielfeld[1][3])) {
            return spieler;
        }                                               // keine drei gleichen in einer Reihe gefunden
        if (zugAnzahl == 9) {                           // wenn Feld voll
            return UNENTSCHIEDEN;                       // dann: unentschieden
        }
        return OFFEN;                                   // sonst: Spiel noch offen
    }

    @Override
    protected void druckeErgebnis(int ergebnis) {
        druckeSpielfeld();
        System.out.println(ergebnis == UNENTSCHIEDEN ? "Unentschieden." : symbole[ergebnis] + " hat gewonnen.");
    }

    private void druckeSpielfeld() {                    // Spielfeld inkl. Rahmen und Indizes ausgeben
        System.out.println("     1 2 3");
        for (int zeile = 0; zeile < 5; zeile++) {
            System.out.print(" " + (1 <= zeile && zeile <= 3 ? zeile : " "));
            for (char zeichen : spielfeld[zeile]) {
                System.out.print(" " + zeichen);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new TicTacToe().starteSpiel();                  // neues Tic-Tac-Toe-Spiel starten
    }
}