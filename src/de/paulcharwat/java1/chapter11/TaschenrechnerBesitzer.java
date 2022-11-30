package de.paulcharwat.java1.chapter11;

/**
 * Interface für einen potenziellen Besitzer von einem oder mehreren
 * Taschenrechnern.
 */
public interface TaschenrechnerBesitzer {
    /**
     * Gibt die Anzahl der Taschenrechner an, die dieser
     * <code>TaschenrechnerBesitzer</code> aktuell besitzt.
     *
     * @return Anzahl der Taschenrechner
     */
    int getTaschenrechnerAnzahl();

    /**
     * Erhöht die Anzahl der Taschenrechner um eins.
     */
    void erhoeheTaschenrechnerAnzahl();

    /**
     * Vermindert die Anzahl der Taschenrechner um eins.
     */
    void vermindereTaschenrechnerAnzahl();
}