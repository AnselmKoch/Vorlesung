package src.main.first;


import java.math.BigInteger;
import java.util.ArrayList;

  /*Programm um Lambda und Arraystream zu üben


  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */

public class FractionStreams {

    public static ArrayList<Fraction> fractionList = new ArrayList<Fraction>();
    public static void main(String[] args) {
        addIntoArrayList();

        MyIO.writeln("Alle Werte nur sortiert");
      fractionList.stream().map(x->x.floatValue()).distinct().sorted().forEach(System.out::println);
        MyIO.writeln("---------------------------------------------------------");

        MyIO.writeln("Alle Fractions Quadriert:");
       fractionList.stream().map(x-> x.multiply(x)).distinct().forEach(System.out::println);
        MyIO.writeln("---------------------------------------------------------");

        MyIO.writeln("Alle Brüche bei denen Nenner und Zähler eine Primzahl ist in zufälliger Reihenfolge:");
       fractionList.stream().parallel().filter(x -> (MyMath.isPrime(x.numerator.longValue()) && MyMath.isPrime(x.denominator.longValue()))).forEach(System.out::println);
        MyIO.writeln("---------------------------------------------------------");

        MyIO.writeln("Alle Brüche die eine ganze Zahl sind!:");
        fractionList.stream().filter(x -> x.isInteger()).forEach(System.out::println);
        MyIO.writeln("---------------------------------------------------------");

        MyIO.writeln("Alle sin-Werte der Brüche als double sortiert!:");
        fractionList.stream().map(fraction -> Math.sin(fraction.doubleValue())).distinct().sorted().forEach(System.out::println);
        MyIO.writeln("---------------------------------------------------------");

    }

    public static void addIntoArrayList() {
        for(int i = -14; i <= 14; i++) {
            for(int j = 14; j >= -14; j--) {
                fractionList.add(new Fraction(new BigInteger(String.valueOf(i)), new BigInteger(String.valueOf(j))));
            }
        }
    }
}
