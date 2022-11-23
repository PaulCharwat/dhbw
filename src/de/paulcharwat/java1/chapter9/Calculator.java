package de.paulcharwat.java1.chapter9;

import de.paulcharwat.java1.chapter10.Person;

public class Calculator {
	public static final double PI = 3.14159265358979323846;

	private static int taschenrechnerAnzahl = 0;
	private String seriennummer;
	private String modell;
	private Person besitzer;
	private Boolean funktionsfaehig;

	public String getSeriennummer() {
		return seriennummer;
	}

	public String getModell() {
		return modell;
	}

	public Person getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Person besitzer) {
		this.besitzer = besitzer;
	}

	public Boolean getFunktionsfaehig() {
		return funktionsfaehig;
	}

	public void setFunktionsfaehig(Boolean funktionsfaehig) {
		this.funktionsfaehig = funktionsfaehig;
	}

	public static void main(String[] args) {
	}

	public Calculator(String seriennummer, String modell) {
		this.seriennummer = seriennummer;
		this.modell = modell;
		taschenrechnerAnzahl++;
	}

	public Calculator(String seriennummer, String modell, Person besitzer) {
		this(seriennummer, modell);
		this.besitzer = besitzer;
	}

	public static void druckeAnzahl() {
		System.out.println("Anzahl der Taschenrechner: " + taschenrechnerAnzahl);
	}

	@Override
	public String toString() {
		return "Seriennummer: " + seriennummer + ", Modell: " + modell;
	}

	public static boolean isEven(long n) {
		return n % 2 == 0;
	}

	public static double abs(double x) {
		return x >= 0 ? x : -x;
	}

	public static long abs(long x) {
		return x >= 0 ? x : -x;
	}

	public static double arithmeticMean(long x, long y) {
		return (x + y) / 2.0;
	}

	public static double geometricMean(long x, long y) {
		return Math.sqrt((double) x * y);
	}

	public static long divisorSum(long n) {
		long sum = 0;
		for (long t = 1; t <= n; t++) {
			if (n % t == 0) {
				sum += t;
			}
		}
		return sum;
	}

	public static boolean isPerfect(long n) {
		return divisorSum(n) == 2 * n;
	}

	public static boolean isPrime(long n) {
		if (n < 2) {
			return false;
		}
		for (int t = 2; t < n; t++) {
			if (n % t == 0) {
				return false;
			}
		}
		return true;
	}

	public static double powerRecursive(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n > 0) {
			return x * powerRecursive(x, n - 1);
		} else {
			return 1 / powerRecursive(x, -n);
		}
	}

	public static double powerIterative(double x, int n) {
		boolean negativeExponent = (n < 0);
		if (negativeExponent) {
			n = -n;
		}
		double product = 1;
		for (int i = 1; i <= n; i++) {
			product *= x;
		}
		return negativeExponent ? 1 / product : product;
	}

	public static int digitSum(long value) {
		if (value <= 9) {
			return (int) value;
		}
		return (int) (value % 10) + digitSum(value / 10);
	}

	public static double sum(double x, double y) {
		return x + y;
	}

	public static long max(long x, long y) {
		return x > y ? x : y;
	}

	public static long min(long x, long y) {
		return x < y ? x : y;
	}

	public static int ggT(int x, int y) {
		if (x == y) {
			return x;
		}
		if (x > y) {
			return ggT(x - y, y);
		}
		return ggT(x, y - x);
	}

	public static long ggT(long x, long y) {
		if (x == y) {
			return x;
		}
		if (x > y) {
			return ggT(x - y, y);
		}
		return ggT(x, y - x);
	}

	public static long factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static long doubleFactorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * doubleFactorial(n - 2);
	}

	public static long fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
