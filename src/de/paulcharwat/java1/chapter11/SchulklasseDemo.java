package de.paulcharwat.java1.chapter11;

public class SchulklasseDemo {
    public static void main(String[] args) {
        Schueler m = new Schueler("Max", "Mustermann", 2023, "123456789", "5a");
        Schueler a = new Schueler("A", "a", 2023, "234567891", "5a");
        Schueler b = new Schueler("B", "b", 2023, "345678912", "5a");
        Schueler c = new Schueler("C", "c", 2023, "456789123", "5a");
        
        Schulklasse klasse = new Schulklasse("5a");

        klasse.toString();
        klasse.fuegeHinzu(m);
        klasse.toString();
        klasse.fuegeHinzu(a);
        klasse.toString();
        klasse.fuegeHinzu(b);
        klasse.toString();
        klasse.fuegeHinzu(c);
        klasse.toString();

        klasse.entferne(a);
        klasse.toString();
    }
}
