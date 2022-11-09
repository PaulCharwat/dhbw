package de.paulcharwat.java1.chapter8;

public class Vektor {

	private int x;
	private int y;
	private int z;
	
	public DreidimensionaleVektoren(int px, int py,int pz) {
		x = px;
		y = py;
		z = pz;
	}
	
	public static void main(String[] args) {
		System.out.println(new DreidimensionaleVektoren(3, 8, 1).addieren(new DreidimensionaleVektoren(1, 5, 8)).toString());
		System.out.println(new DreidimensionaleVektoren(3, 8, 1).subtrahieren(new DreidimensionaleVektoren(1, 5, 8)).toString());
		System.out.println(new DreidimensionaleVektoren(3, 8, 1).multiplizieren(new DreidimensionaleVektoren(1, 5, 8)));
		System.out.println(new DreidimensionaleVektoren(3, 8, 1).kreuzprodukt(new DreidimensionaleVektoren(1, 5, 8)).toString());
	}
	
	public DreidimensionaleVektoren addieren(DreidimensionaleVektoren dreidimesionaleVektoren) {
		return new DreidimensionaleVektoren(x+dreidimesionaleVektoren.x, y+dreidimesionaleVektoren.y, z+dreidimesionaleVektoren.z);
	}
	public DreidimensionaleVektoren subtrahieren(DreidimensionaleVektoren dreidimesionaleVektoren) {
		return new DreidimensionaleVektoren(x-dreidimesionaleVektoren.x, y-dreidimesionaleVektoren.y, z-dreidimesionaleVektoren.z);
	}	
	public int multiplizieren(DreidimensionaleVektoren dreidimensionaleVektoren) {
		return (x*dreidimensionaleVektoren.x + y*dreidimensionaleVektoren.y + z*dreidimensionaleVektoren.z);
	}
	public DreidimensionaleVektoren kreuzprodukt(DreidimensionaleVektoren dreidimesionaleVektoren) {
		return new DreidimensionaleVektoren(y+dreidimesionaleVektoren.z - z*dreidimesionaleVektoren.y, z*dreidimesionaleVektoren.x - x*dreidimesionaleVektoren.z, x*dreidimesionaleVektoren.y - y*dreidimesionaleVektoren.x);
	}
	public String toString() {
        return "(" + x + "|"+ y + "|"+ z + ")";
    }
	

}
