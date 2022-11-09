package de.paulcharwat.java1.chapter8;

public class Vektor {

	private int x;
	private int y;
	private int z;
	
	public Vektor(int px, int py,int pz) {
		x = px;
		y = py;
		z = pz;
	}
	
	public static void main(String[] args) {
		System.out.println(new Vektor(3, 8, 1).addieren(new Vektor(1, 5, 8)).toString());
		System.out.println(new Vektor(3, 8, 1).subtrahieren(new Vektor(1, 5, 8)).toString());
		System.out.println(new Vektor(3, 8, 1).multiplizieren(new Vektor(1, 5, 8)));
		System.out.println(new Vektor(3, 8, 1).kreuzprodukt(new Vektor(1, 5, 8)).toString());
	}
	
	public Vektor addieren(Vektor dreidimesionaleVektoren) {
		return new Vektor(x+dreidimesionaleVektoren.x, y+dreidimesionaleVektoren.y, z+dreidimesionaleVektoren.z);
	}
	public Vektor subtrahieren(Vektor dreidimesionaleVektoren) {
		return new Vektor(x-dreidimesionaleVektoren.x, y-dreidimesionaleVektoren.y, z-dreidimesionaleVektoren.z);
	}	
	public int multiplizieren(Vektor Vektor) {
		return (x*Vektor.x + y*Vektor.y + z*Vektor.z);
	}
	public Vektor kreuzprodukt(Vektor dreidimesionaleVektoren) {
		return new Vektor(y+dreidimesionaleVektoren.z - z*dreidimesionaleVektoren.y, z*dreidimesionaleVektoren.x - x*dreidimesionaleVektoren.z, x*dreidimesionaleVektoren.y - y*dreidimesionaleVektoren.x);
	}
	public String toString() {
        return "(" + x + "|"+ y + "|"+ z + ")";
    }
	

}
