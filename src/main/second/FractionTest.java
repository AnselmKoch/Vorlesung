
/**
 * Testet alle Methoden der Fraction-Klasse
 *
 *  @author Robin Schüle, Martin Marsal, Matthias Vollmer, Anselm Koch
 * @version 2021-11-03
 */

package src.main.second;

import static org.junit.Assert.*;
import org.junit.Test;
import src.main.first.Fraction;

import java.math.BigInteger;


public class FractionTest {

    /**
     * Alle Fractions die im Laufe des testens von Nutzen sein können
     */
    Fraction fractionA = new Fraction(3,10);
    Fraction fractionB = new Fraction(5,8);
    Fraction fractionWith0 = new Fraction(0,5);
    Fraction fractionWithNegative = new Fraction(-5,8);
    Fraction fractionWithLargeNumber = new Fraction(99999,9999);
    Fraction fracture1 = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(3));
    Fraction fractureWithZeroDenominator = new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(0));
    Fraction fractureWithZeroNumerator = new Fraction(BigInteger.valueOf(0), BigInteger.valueOf(3));


    /**
     * Testet die verschiedenen Rechenmethoden mit einem Bruch der 0 als Nenner oder Zähler enthält
     */
    @Test(expected = ArithmeticException.class)
    public void testAddWithZeroDenominator() {
        fracture1.add(fractureWithZeroDenominator);
    }
    @Test(expected = ArithmeticException.class)
    public void testSubtractWithZeroDenominator() {
        fracture1.subtract(fractureWithZeroDenominator);
    }
    @Test(expected = ArithmeticException.class)
    public void testMultiplyWithZeroDenominator() {
        fracture1.multiply(fractureWithZeroDenominator);
    }
    @Test(expected = ArithmeticException.class)
    public void testDivideWithZeroDenominator() {
        fracture1.divide(fractureWithZeroDenominator);
    }

    //Tests mit 0 im Zähler
    @Test
    public void testAddWithZeroNominator() {
        assertEquals(2, fracture1.add(fractureWithZeroNumerator).numerator.intValue());
        assertEquals(3, fracture1.add(fractureWithZeroNumerator).denominator.intValue());
    }
    @Test
    public void testSubtractWithZeroNominator() {
        assertEquals(2, fracture1.subtract(fractureWithZeroNumerator).numerator.intValue());
        assertEquals(3, fracture1.subtract(fractureWithZeroNumerator).denominator.intValue());
    }
    @Test
    public void testMultiplyWithZeroNominator() {
        assertEquals(0, fracture1.multiply(fractureWithZeroNumerator).intValue());
    }
    @Test(expected = ArithmeticException.class)
    public void testDivideWithZeroNumerator() {
        fracture1.divide(fractureWithZeroNumerator);
    }

    /**
     * Vergleicht zwei Brüche miteinander und achtet darauf dass das Ergebnis >=1 ist
     */
    @Test
    public void testCompareLower() {
        Fraction higherA = new Fraction(5,2);
        Fraction lowerB = new Fraction(3,2);

        assertTrue(!(fractionWith0.compareTo(higherA) >= 1));
        assertTrue(fractionWithLargeNumber.compareTo(lowerB) >= 1);
        assertTrue(!(fractionWithNegative.compareTo(higherA) >= 1));
        assertTrue(lowerB.compareTo(higherA) >= -1);
    }

    /**
     * Vergleicht zwei Brüche miteinander und achtet darauf dass das Ergebnis <=1 ist
     */
    @Test
    public void testCompareHigher() {
        Fraction higherA = new Fraction(5,2);
        Fraction lowerB = new Fraction(3,2);

        assertTrue(fractionWith0.compareTo(lowerB) <= 1);
        assertTrue(fractionWithLargeNumber.compareTo(lowerB) <= 1);
        assertTrue(fractionWithNegative.compareTo(higherA) <= 1);
        assertTrue(higherA.compareTo(lowerB) <= 1);
    }

    /**
     * Vergleicht zwei Brüche miteinander und achtet darauf dass das Ergebnis =0 ist
     */

    @Test
    public void testCompareEqual() {
        Fraction equalA = new Fraction(5,5);
        Fraction equalB = new Fraction(5,5);

        assertTrue(fractionWithNegative.compareTo(fractionWithNegative) == 0);
        assertTrue(fractionWithLargeNumber.compareTo(fractionWithLargeNumber) == 0);
        assertTrue(fractionWith0.compareTo(fractionWith0) == 0);
        assertTrue(equalA.compareTo(equalB) == 0);
    }


    /**
     *Subtrahiert den erwarteten und den eigentlichen Float Werte voneinander und überprüft ob der unterschied jeweils größer oder kleiner als Delta ist
     *
     * Also ist bereits überprüft ob die Werte tatsächlich nicht übereinstimmen oder ob es einfach nur ungenau ist.
     */
    @Test
    public void testFloatValue() {
        double delta = 0.1;
        assertTrue(((fractionWithLargeNumber.numerator.floatValue() / fractionWithLargeNumber.denominator.floatValue()) - fractionWithLargeNumber.floatValue() <= delta
                || (fractionWithLargeNumber.floatValue() - (fractionWithLargeNumber.numerator.floatValue() / fractionWithLargeNumber.denominator.floatValue()) >= delta)));

        assertTrue(((fractionWith0.numerator.floatValue() / fractionWith0.denominator.floatValue()) - fractionWith0.floatValue() <= delta
                || (fractionWith0.floatValue() - (fractionWith0.numerator.floatValue() / fractionWith0.denominator.floatValue()) >= delta)));

        assertTrue(((fractionWithNegative.numerator.floatValue() / fractionWithNegative.denominator.floatValue()) - fractionWithNegative.floatValue() <= delta
                || (fractionWithNegative.floatValue() - (fractionWithNegative.numerator.floatValue() / fractionWithNegative.denominator.floatValue()) >= delta)));

        assertTrue(((fractionA.numerator.floatValue() / fractionA.denominator.floatValue()) - fractionA.floatValue() <= delta
                || (fractionA.floatValue() - (fractionA.numerator.floatValue() / fractionA.denominator.floatValue()) >= delta)));

    }


    /**
     *Subtrahiert den erwarteten und den eigentlichen Double Werte voneinander und überprüft ob der unterschied jeweils größer oder kleiner als Delta ist
     *
     * Also ist bereits überprüft ob die Werte tatsächlich nicht übereinstimmen oder ob es einfach nur ungenau ist.
     */
    @Test
    public void testDoubleValue() {
        double delta = 0.1;
        assertTrue(((fractionWithLargeNumber.numerator.doubleValue() / fractionWithLargeNumber.denominator.doubleValue()) - fractionWithLargeNumber.doubleValue() <= delta
        || (fractionWithLargeNumber.doubleValue() - (fractionWithLargeNumber.numerator.doubleValue() / fractionWithLargeNumber.denominator.doubleValue()) >= delta)));

        assertTrue(((fractionWith0.numerator.doubleValue() / fractionWith0.denominator.doubleValue()) - fractionWith0.doubleValue() <= delta
                || (fractionWith0.doubleValue() - (fractionWith0.numerator.doubleValue() / fractionWith0.denominator.doubleValue()) >= delta)));

        assertTrue(((fractionWithNegative.numerator.doubleValue() / fractionWithNegative.denominator.doubleValue()) - fractionWithNegative.doubleValue() <= delta
                || (fractionWithNegative.doubleValue() - (fractionWithNegative.numerator.doubleValue() / fractionWithNegative.denominator.doubleValue()) >= delta)));

        assertTrue(((fractionA.numerator.doubleValue() / fractionA.denominator.doubleValue()) - fractionA.doubleValue() <= delta
                || (fractionA.doubleValue() - (fractionA.numerator.doubleValue() / fractionA.denominator.doubleValue()) >= delta)));

    }

    /**
     * Testet ob die longValue-Methode richtige Werte liefert
     */
    @Test
    public void testLongValue() {
        assertEquals(fractionWithLargeNumber.numerator.longValue() / fractionWithLargeNumber.denominator.longValue(), fractionWithLargeNumber.longValue());
        assertEquals(fractionWith0.numerator.longValue() / fractionWith0.denominator.longValue(), fractionWith0.longValue());
        assertEquals(fractionWithNegative.numerator.longValue() / fractionWithNegative.denominator.longValue(), fractionWithNegative.longValue());
        assertEquals(fractionA.numerator.longValue() / fractionA.denominator.longValue(), fractionA.longValue());
    }


    /**
     * Testet ob die intValue-Methode richtige Werte liefert
     */
    @Test
    public void testIntValue() {
        assertEquals(fractionWithLargeNumber.numerator.intValue() / fractionWithLargeNumber.denominator.intValue(), fractionWithLargeNumber.intValue());
        assertEquals(fractionWith0.numerator.intValue() / fractionWith0.denominator.intValue(), fractionWith0.intValue());
        assertEquals(fractionWithNegative.numerator.intValue() / fractionWithNegative.denominator.intValue(), fractionWithNegative.intValue());
        assertEquals(fractionA.numerator.intValue() / fractionA.denominator.intValue(), fractionA.intValue());
    }

    /**
     * Testet ob die isInteger-Methode funktioniert
     */
    @Test
    public void testIsInteger() {
        Fraction testBooleanA = new Fraction(8,8);
        Fraction testBooleanB = new Fraction(5,8);

        assertTrue(testBooleanA.isInteger() == true);
        assertTrue(testBooleanB.isInteger() == false);
    }

    /**
     * Testet ob die toString-Methode funktioniert
     */
    @Test
    public void testToString() {
        System.out.println("To String: " + fractionA.toString());

        assertTrue(fractionA.toString().equals("3/10"));
    }


    /**
     * Testet ob man Brüche mit der multiply-Methode richtig und korrekt multiplizieren kann
     */
    @Test
    public void testFractionMultiplikation() {

        System.out.println("Multiplikation " + fractionA.multiply(fractionB).toString());

        //Fraction mit großer Zahl multiplizieren
        assertEquals(8888, fractionWithLargeNumber.multiply(fractionB).denominator.intValue());

        //Fraction mit negativer Zahl multiplizieren
        assertEquals(-25,fractionWithNegative.multiply(fractionB).numerator.intValue());

        //Fraction mit 0 mulitplizieren
        assertEquals(0, fractionWith0.multiply(fractionA).intValue());

        //Fraction nur multiplizieren
        assertEquals(3, fractionA.multiply(fractionB).numerator.intValue());
        assertEquals(16, fractionA.multiply(fractionB).denominator.intValue());
    }

    /**
     * Testet ob man Brüche mit der divide-Methode richtig und korrekt dividieren kann
     */
    @Test
    public void testFractionDivision() {

        System.out.println("Division " + fractionA.divide(fractionB).toString());

        assertEquals(12, fractionA.divide(fractionB).numerator.intValue());
        assertEquals(25, fractionA.divide(fractionB).denominator.intValue());
    }

    /**
     * Testet ob man Brüche mit der add-Methode richtig und korrekt addieren kann
     */
    @Test
    public void testFractionAddition() { ;

        System.out.println("Addition: " + fractionA.add(fractionB).toString());

        assertEquals(37, fractionA.add(fractionB).numerator.intValue());
        assertEquals(40, fractionA.add(fractionB).denominator.intValue());
    }

    /**
     * Testet ob man Brüche mit der subtract-Methode richtig und korrekt subtrahieren kann
     */
    @Test
    public void testFractionSubtraktion() {

        System.out.println("Subtraktion: " + fractionA.subtract(fractionB).toString());

        assertEquals(-13,fractionA.subtract(fractionB).numerator.intValue());
        assertEquals(40, fractionA.subtract(fractionB).denominator.intValue());
    }

}
