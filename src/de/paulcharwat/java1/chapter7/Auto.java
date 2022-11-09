package de.paulcharwat.java1.chapter7;

public class Auto {
    public static int autoAnzahl;
    public String kennzeichen;
    public String modell;
    private int insassenAnzahl;
    private int tankInhalt;

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
  
        }

    public Auto(String kennzeichen, String modell) {
        this.kennzeichen = kennzeichen;
        this.modell = modell;
        autoAnzahl++;
    }

    
    /** 
     * @param insassen Anzahl der hinzukommenden Insassen
     * @return neue Insassenanzahl
     */
    public int einsteigen(int insassen) {
        this.insassenAnzahl = this.insassenAnzahl + insassen;
        return this.insassenAnzahl;
        //return this.insassenAnzahl += insassen;
    }

    
    /** 
     * @param insassen Anzahl der aussteigenden Insassen
     * @return Anzahl der Verbleibenden Insassen
     */
    public int aussteigen(int insassen) {
        return this.insassenAnzahl -= insassen;
    }

    
    /** 
     * @param liter Anzahl der getankten Liter
     * @return neuer Tankinhalt
     */
    public int tanken(int liter) {
        return this.tankInhalt += liter;
    }

    
    /** 
     * @param liter Anzahl der verbrauchten Liter
     * @return Verbleibender Tankinhalt
     */
    public int verbrauche(int liter) {
        return this.tankInhalt -= liter;
    }

    public void print() {
        System.out.println("Kennzeichen: " + this.kennzeichen);
        System.out.println("Modell: " + this.modell);
        System.out.println("Insassen: " + this.insassenAnzahl);
        System.out.println("Tankinhalt: " + this.tankInhalt);
    }

    
}
