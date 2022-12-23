package de.paulcharwat.java1.chapter11;

public class Karten {
    private Karte[] karten;
    private int anzahl = 0;

    public Karten(int maxAnzahl) {                      // Konstruktor
        super();
        karten = new Karte[maxAnzahl];
    }

    public void fuegeHinzu(Karte karte) {               // Karte hinzufügen
        karten[anzahl++] = karte;
    }
    public Karte getObersteKarte() {                    // oberste Karte abfragen
        return anzahl > 0 ? karten[anzahl - 1] : null;
    }
    public Karte getKarte(int index) {                  // bestimmte Karte abfragen
        return karten[index];
    }
    public Karte zieheObersteKarte() {                  // oberste Karte entfernen
        return anzahl > 0 ? karten[--anzahl] : null;
    }
    public Karte zieheKarte(int index) {                // bestimmte Karte entfernen
        Karte karte = karten[index];
        while (++index < anzahl) {                      // dabei rutschen alle weiter ...
            karten[index - 1] = karten[index];          // ... hinten liegenden einen vor
        }
        anzahl--;
        return karte;
    }
    public void vertausche(int index1, int index2) {    // zwei bestimmte Karten vertauschen
        Karte karte = karten[index1];
        karten[index1] = karten[index2];
        karten[index2] = karte;
    }
    public int getAnzahl() {                            // aktuelle Größe abfragen
        return anzahl;
    }

    @Override
    public String toString() {                          // Anzahl und Aufzählung aller enthaltenen Karten
        String ergebnis = anzahl + " Karten:";
        for (int index = 0; index < anzahl; index++) {
            ergebnis += " " + karten[index];
        }
        return ergebnis;
    }
}