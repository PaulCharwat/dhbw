package de.paulcharwat.java1.chapter11;

public class StringArray {
    private static String[] zahlwoerter = new String[] {
            "null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwölf",
            "viele" };

    /**
     * Liefert zu jeder nichtnegativen ganzen Zahl ein passendes Zahlwort.
     *
     * @param zahl
     * @return zahlwort
     */
    public static String getZahlwort(int zahl) {
        return zahl < 0 ? "FEHLER" : zahl <= 12 ? zahlwoerter[zahl] : zahlwoerter[13];
    }
}
