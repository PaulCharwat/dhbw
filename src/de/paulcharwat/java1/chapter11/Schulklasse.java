package de.paulcharwat.java1.chapter11;

/**
 * Eine Schulklasse ist ein benannter Behälter für <code>Schueler</code>.
 * <code>Schueler</code> können hinzugefügt, gesucht und wieder entfernt werden.
 * Die maximale Anzahl enthaltener <code>Schueler</code> ist auf 40 begrenzt.
 */
public class Schulklasse {
    private static final int MAX_GROESSE = 40; // max. Klassengröße

    private String name; // Name der Klasse
    private Schueler[] alleSchueler = new Schueler[MAX_GROESSE]; // Feld für Schüler
    private int groesse = 0; // Anzahl Schüler

    /**
     * Konstruktor für eine Schulklasse mit dem angegebenen Namen.
     *
     * @param name
     */
    public Schulklasse(String name) {
        this.name = name;
    }

    /**
     * Liefert den Namen dieser Schulklasse.
     *
     * @return Name der Schulklasse
     */
    public String getName() {
        return name;
    }

    /**
     * Liefert die aktuelle Größe dieser Schulklasse, d.h. die Anzahl der
     * enthaltenen Schüler.
     *
     * @return
     */
    public int getGroesse() {
        return groesse;
    }

    /**
     * Stellt fest, ob der angegebene Schüler in dieser Klasse enthalten ist und
     * gibt den Index zurück.
     *
     * @return <code>index</code> falls der Schüler in dieser Klasse enthalten ist,
     *         sonst <code>-1</code>
     */
    public int bestimmeIndex(Schueler schueler) {
        for (int index = 0; index < groesse; index++) { // suche schueler im Feld alleSchueler
            if (alleSchueler[index] == schueler) {
                return index; // falls gefunden
            }
        }
        return -1; // falls nicht gefunden
    }

    /**
     * Fügt den neuen Schüler der Klasse hinzu, falls die maximale Größe noch nicht
     * erreicht wurde
     * und der Schüler nicht schon enthalten war.
     *
     * @param schueler neuer Schüler
     * @return <code>true</code> falls der Schüler hinzugefügt wurde, sonst
     *         <code>false</code>
     */
    public boolean fuegeHinzu(Schueler schueler) {
        if (groesse == MAX_GROESSE || bestimmeIndex(schueler) > -1) {
            return false; // falls voll oder schon enthalten
        }
        alleSchueler[groesse++] = schueler; // neuen Schüler "hinten" im Feld speichern
        return true;
    }

    /**
     * Entfernt den Schüler aus der Klasse, falls er enthalten ist.
     *
     * @param schueler Schüler
     * @return <code>true</code> falls der Schüler entfernt wurde, sonst
     *         <code>false</code>
     */
    public boolean entferne(Schueler schueler) {
        int treffer = bestimmeIndex(schueler);
        if (treffer == -1) {
            return false; // falls kein Treffer
        }
        if (treffer < groesse - 1) { // falls der Schüler nicht der letzte ist,
            alleSchueler[treffer] = alleSchueler[groesse - 1]; // wird der letzte Schüler auf seinen Platz gesetzt
        }
        alleSchueler[--groesse] = null; // letzten Schüler entfernen
        return true;
    }

    @Override
    public String toString() {
        return "Schulklasse " + name + " (#Schüler: " + groesse + ")";
    }
}