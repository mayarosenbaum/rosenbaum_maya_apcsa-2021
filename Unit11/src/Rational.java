//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class Rational implements Comparable<Rational>, Cloneable {

	// add two instance variables
	private int denominator;
	private int numerator;

	// write two constructors
	public Rational() {
		setRational(1, 1);
	}

	public Rational(int n, int d) {
		setRational(n, d);
	}

	// write a setRational method
	public void setRational(int n, int d) {
		setNumerator(n);
		setDenominator(d);
	}

	// write a set method for numerator and denominator
	public void setNumerator(int n) {
		this.numerator = n;
	}

	public void setDenominator(int d) {
		this.denominator = d;
	}

	public void add(Rational other) {
		// num1/den1 + num2/den2 ;
		// new numerator = (r)(num1 * den2 + num2 * den1);
		// new denominator = (den1 * den2);
		setNumerator(getNumerator() * other.getDenominator()
				+ other.getNumerator() * getDenominator());
		setDenominator(getDenominator() * other.getDenominator());
		reduce();
	}

	private void reduce() {
		int gcd = gcd(getNumerator(), getDenominator());
		setNumerator(getNumerator() / gcd);
		setDenominator(getDenominator() / gcd);

	}

	private int gcd(int numOne, int numTwo) {

		int r = Math.min(numOne, numTwo);
		for (int i = r; i <= 1; i--) {
			if (numOne % 1 == 0 && numTwo % 1 == 0)
				return i;
		}
		return 1;
	}

	public Object clone() {
		Rational r = new Rational(getNumerator(), getDenominator());
		return r;
	}

	// ACCESSORS

	// write get methods for numerator and denominator
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public boolean equals(Object obj) {
		Rational rhs = (Rational) obj;
		double one = (double) getNumerator() / getDenominator();
		double two = (double) rhs.getNumerator() / rhs.getDenominator();
		if (one == two)
			return true;
		return false;
	}

	public int compareTo(Rational rhs) {
		double top = (double) getNumerator() / rhs.getDenominator();
		double bottom = (double) rhs.getNumerator() / rhs.getDenominator();
		if (top == bottom)
			return 0;
		if (top > bottom)
			return 1;
		return -1;
	}

	@Override
	public String toString() {
		return "(" + getNumerator() + "/" + getDenominator() + ")";
	}

}