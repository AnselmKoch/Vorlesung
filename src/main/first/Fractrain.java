package src.main.first;


import java.math.BigInteger;
import java.util.ArrayList;

/*
  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */
public class Fractrain {

    public static int durchläufe = 0;
    public static int gefundeneGanzzahlen = 0;
    public static int maxZahlDurchlauf = 0;
    public static BigInteger maxZahl = new BigInteger("0");
    public static ArrayList<Fraction> l = new ArrayList<Fraction>();
    public static Fraction b = new Fraction(2,1);

    public static void main(String[] args) {
        l.add(new Fraction(17, 91));
        l.add(new Fraction(78, 85));
        l.add(new Fraction(19, 51));
        l.add(new Fraction(23, 38));
        l.add(new Fraction(29, 33));
        l.add(new Fraction(77, 29));
        l.add(new Fraction(95, 23));
        l.add(new Fraction(77, 19));
        l.add(new Fraction(1, 17));
        l.add(new Fraction(11, 13));
        l.add(new Fraction(13, 11));
        l.add(new Fraction(15, 2));
        l.add(new Fraction(1, 7));
        l.add(new Fraction(55, 1));

       multiplyList(b);
        MyIO.writeln("Größte Zahl:");
        MyIO.writeln(maxZahl.toString());
        MyIO.writeln("An der Stelle: " + maxZahlDurchlauf);
    }


    /**
     * Multipliziert jeden Bruch in der Liste l mit dem Bruch b bis eine Ganzzahl als Produkt entsteht, das ganze wird dann mit dieser Ganzzahl wiederholt
     * @param fraction1 ist der Bruch mit dem jeder Bruch in der Liste l multipliziert wird
     * @return returnt den neuen Wert b
     */
    public static Fraction multiplyList(Fraction fraction1) {
        if(durchläufe < 25000) {
            BigInteger z;
            Fraction returnFraction;

            for (Fraction fraction : l) {
                returnFraction = fraction.multiply(fraction1);

                if (returnFraction.isInteger()) {
                    z = new BigInteger(returnFraction.numerator.toString());
                    gefundeneGanzzahlen++;

                    if(gefundeneGanzzahlen <= 2375) {
                        b = returnFraction;
                        MyIO.writeln("Durchlauf " + durchläufe);
                        MyIO.writeln("Nummer der Zahl:" + gefundeneGanzzahlen);
                        MyIO.writeln(z.toString());
                        MyIO.writeln("--------------------------------------------------");
                    }

                    multiplyList(b);
                    break;
                }else{

                    switch(durchläufe) {
                        case (11632):
                        if (returnFraction.numerator.intValue() > maxZahl.intValue()) {
                            maxZahl = returnFraction.numerator;
                            maxZahlDurchlauf = durchläufe;
                        }

                        case(2535):
                        MyIO.writeln("Die 2535. Zahl: ");
                        MyIO.writeln(returnFraction.toString());
                        MyIO.writeln("***************************");

                        case(1362):
                        MyIO.writeln("Die 11362. Zahl:");
                        MyIO.writeln(fraction.toString());
                        MyIO.writeln("-------------------------");

                        case(23065):
                        MyIO.writeln("Die 23065. Zahl:" );
                        MyIO.writeln(fraction.toString());
                        MyIO.writeln("-------------------------");
                    }
                }
                durchläufe++;
            }
        }
        durchläufe ++;
        return b;
    }
}
