package de.paulcharwat.java1.chapter10;

public class TaschenrechnerAusleihe {
    public static void main(String[] args) {
        Taschenrechner taschenrechner1 = new Taschenrechner("123", "TI-30");
        Taschenrechner taschenrechner2 = new Taschenrechner("456", "HP-12C");
        Schueler schueler = new Schueler("Roger", "Rabbit", 1988, "123", "8c");
        Lehrer lehrer = new Lehrer("Fred", "Flintstone", 1960, "456", 3000, "Herr");

        System.out.println("Schüler " + schueler.getName() + " hat " + schueler.getTaschenrechnerAnzahl() + " Taschenrechner.");
        System.out.println("Lehrer " + lehrer.getName() + " hat " + lehrer.getTaschenrechnerAnzahl() + " Taschenrechner.");
        taschenrechner1.setBesitzer(schueler);
        System.out.println("Schüler " + schueler.getName() + " hat " + schueler.getTaschenrechnerAnzahl() + " Taschenrechner.");
        System.out.println("Lehrer " + lehrer.getName() + " hat " + lehrer.getTaschenrechnerAnzahl() + " Taschenrechner.");
        taschenrechner1.setBesitzer(lehrer);
        System.out.println("Schüler " + schueler.getName() + " hat " + schueler.getTaschenrechnerAnzahl() + " Taschenrechner.");
        System.out.println("Lehrer " + lehrer.getName() + " hat " + lehrer.getTaschenrechnerAnzahl() + " Taschenrechner.");
        taschenrechner2.setBesitzer(lehrer);
        System.out.println("Schüler " + schueler.getName() + " hat " + schueler.getTaschenrechnerAnzahl() + " Taschenrechner.");
        System.out.println("Lehrer " + lehrer.getName() + " hat " + lehrer.getTaschenrechnerAnzahl() + " Taschenrechner.");
    }
}