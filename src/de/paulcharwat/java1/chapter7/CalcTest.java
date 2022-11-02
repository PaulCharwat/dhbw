package de.paulcharwat.java1.chapter7;

public class CalcTest {
    public static void main(String[] args) {
        Calculator c1 = new Calculator("AT24-203.963", "AT24", "Ich");
        Calculator.druckeAnzahl();

        Calculator c2 = new Calculator("AT24-203.964", "AT24");
        Calculator.druckeAnzahl();

        c1.druckeDaten();
        c2.druckeDaten();
    }
}
