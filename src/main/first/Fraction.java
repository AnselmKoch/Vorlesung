/**
 * Implementiert eine Klasse die Brüche mit BigInteger darstellt
 *
* @author Robin Schüle, Martin Marsal, Matthias Vollmer, Anselm Koch
 * @version 2020-12-07
 */

package src.main.first;

import java.io.Serializable;
import java.math.BigInteger;

public final class Fraction extends Number implements Comparable<Fraction>, Serializable {

    public BigInteger numerator;
    public BigInteger denominator;
    public Fraction (BigInteger numerator, BigInteger denominator){


		if (BigInteger.ZERO.equals(denominator)) {
			throw new IllegalArgumentException("Durch Null teilen geht nicht");
		}

		//Bei negativen Nenner werden die Vorzeichen gedreht
		if(denominator.signum() == -1){
			numerator = numerator.negate();
			denominator = denominator.negate();
		}

		//Brüche kürzen indem Zähler und Nenner durch ihren GGT geteilt werden
		BigInteger ggt = numerator.gcd(denominator);
		this.numerator = numerator.divide(ggt);
		this.denominator = denominator.divide(ggt);

	}
	public Fraction (long numerator, long denominator){
		this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
	}


	public int compareTo(Fraction r) {
		return numerator.multiply(r.denominator).compareTo(denominator.multiply(r.numerator));
	}

	public int intValue() {
		return numerator.divide(denominator).intValue();
	}

	public long longValue() {
		return numerator.divide(denominator).longValue();
	}

	public float floatValue() {
		return (float)doubleValue();
	}

	public double doubleValue() {
		return numerator.doubleValue() / denominator.doubleValue();
	}

	public Fraction add(Fraction r){
		return new Fraction(numerator.multiply(r.denominator).add(denominator.multiply(r.numerator)), denominator.multiply(r.denominator));
	}

	public Fraction subtract(Fraction r){
		return new Fraction(numerator.multiply(r.denominator).subtract(denominator.multiply(r.numerator)), denominator.multiply(r.denominator));
	}

	public Fraction multiply(Fraction r){
		return new Fraction(numerator.multiply(r.numerator), denominator.multiply(r.denominator));
	}

	public Fraction divide(Fraction r){
		return new Fraction(numerator.multiply(r.denominator), denominator.multiply(r.numerator));
	}

	public String toString(){
		if (isInteger()) return numerator.toString();
		else return numerator.toString() + "/" + denominator.toString();
	}

	public boolean isInteger(){
		return denominator.equals(BigInteger.ONE);

	}

	public static void main(String[] args) {

		//Verschiedene Tests der Methoden

		Fraction a = new Fraction(2,3);
		MyIO.writeln("Bruch A: " + a.toString());

		Fraction b = new Fraction(1,4);
		MyIO.writeln("Bruch B: " + b.toString());

		MyIO.writeln("A + B = " + a.add(b).toString());         // 2/3 + 1/4 = 11/12
		MyIO.writeln("A - B = " + a.subtract(b).toString());    // 2/3 - 1/4 =  5/12
		MyIO.writeln("A * B = " + a.multiply(b).toString());    // 2/3 * 1/4 =  1/6
		MyIO.writeln("A / B = " + a.divide(b).toString());      // 2/3 / 1/4 =  8/3

		Fraction c = new Fraction(-4,-2);
		MyIO.writeln("Bruch C: " + c.toString());

		if (c.isInteger()) MyIO.writeln("C ist Ganzzahl");
		else MyIO.writeln("C is kein Ganzzahl");

		Fraction d = new Fraction(-18,7);
		MyIO.writeln("Bruch D: " + d.toString());

		MyIO.writeln("Bruch D als int: " + d.intValue());
		MyIO.writeln("Bruch D als long: " + d.longValue());
		MyIO.writeln("Bruch D als float: " + d.floatValue());
		MyIO.writeln("Bruch D als double: " + d.doubleValue());
	}
}
