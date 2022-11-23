package de.paulcharwat.java1.chapter10;

public class Taschenrechner {
    private static int taschenrechnerAnzahl = 0;

    private String seriennummer;
    private String modell;
    private TaschenrechnerBesitzer besitzer;    // besitzer hat jetzt den Typ TaschenrechnerBesitzer
    private boolean funktionsfaehig;

    public Taschenrechner(String seriennummer, String modell) {
        taschenrechnerAnzahl++;
        this.seriennummer = seriennummer;
        this.modell = modell;
        this.funktionsfaehig = true;
    }

    public Taschenrechner(String seriennummer, String modell, TaschenrechnerBesitzer besitzer) {
        this(seriennummer, modell);
        setBesitzer(besitzer);                  // wird jetzt auch über den Setter gesetzt
    }

    public static int getTaschenrechnerAnzahl() {
        return taschenrechnerAnzahl;
    }

    public TaschenrechnerBesitzer getBesitzer() {
        return besitzer;
    }
    public void setBesitzer(TaschenrechnerBesitzer besitzer) {
        if (this.besitzer != besitzer) {        // falls der Besitzer wechselt
            System.out.println(this + ", " + this.besitzer + " -> " + besitzer);
            if (this.besitzer != null) {        // falls alter Besitzer vorhanden
                this.besitzer.vermindereTaschenrechnerAnzahl();
            }
            if (besitzer != null) {             // falls neuer Besitzer vorhanden
                besitzer.erhoeheTaschenrechnerAnzahl();
            }
            this.besitzer = besitzer;
        }
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public String getModell() {
        return modell;
    }

    public boolean isFunktionsfaehig() {
        return funktionsfaehig;
    }
    public void setFunktionsfaehig(boolean funktionsfaehig) {
        this.funktionsfaehig = funktionsfaehig;
    }

    @Override
    public String toString() {
        return "Seriennummer: " + seriennummer + ", Modell: " + modell;
    }
}