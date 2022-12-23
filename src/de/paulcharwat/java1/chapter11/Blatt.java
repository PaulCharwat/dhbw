package de.paulcharwat.java1.chapter11;
import java.util.Random;

public class Blatt extends Karten {
    public static final int MAX_ANZAHL = Kartenfarbe.values().length * Kartenrang.values().length;

    public Blatt() {
        super(MAX_ANZAHL);                                      // Größe des vollständigen Blatts

        for (Kartenfarbe farbe : Kartenfarbe.values()) {        // über alle Farben laufen und ...
            for (Kartenrang wert : Kartenrang.values()) {       // ... mit allen Rängen kombinieren
                fuegeHinzu(new Karte(farbe, wert));             // Superklassenmethode aufrufen
            }
        }
    }

    public void mische() {
        for (int round = 1; round <= 10000; round++) {          // vertauscht 10000 mal ein zufälliges Paar
            vertausche(new Random().nextInt(MAX_ANZAHL), new Random().nextInt(MAX_ANZAHL));
        }
    }

    public Hand[] teileAus(int spielerAnzahl) {                 // verteilt das Blatt an die gegebene Anzahl Spieler
        return teileAus(spielerAnzahl, getAnzahl() / spielerAnzahl);    // (wenn's nicht aufgeht bleibt ein Rest)
    }

    public Hand[] teileAus(int spielerAnzahl, int kartenProSpieler) {
        if (spielerAnzahl * kartenProSpieler > getAnzahl()) {   // sollen mehr Karten ausgeteilt werden als da sind?
            return null;
        }
        Hand[] haende = new Hand[spielerAnzahl];                // Hände initialisieren
        for (int spielerIndex = 0; spielerIndex < spielerAnzahl; spielerIndex++) {
            haende[spielerIndex] = new Hand(getAnzahl());       // max. Kapazität einer Hand = ganzes Blatt
        }                                                       // (für Spiele, in denen noch gezogen wird)
        int zaehler = 0;
        while (zaehler < spielerAnzahl * kartenProSpieler) {
            Karte karte = zieheObersteKarte();                  // nächste Karte ziehen
            Hand hand = haende[zaehler++ % spielerAnzahl];      // welcher Spieler bekommt die nächste Karte?
            hand.fuegeHinzu(karte);                             // nächste Karte hinzufügen
        }
        return haende;
    }

    @Override
    public String toString() {                                  // toString()-Methode überschrieben
        return "Blatt mit " + super.toString();                 // unter Benutzung der Superklassenimplementierung
    }
}