package src.main.first;

import sun.awt.Symbol;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/*Dieses Programm enthält Methoden welche die Abfrage und Ausgabe von Werten in der Konsole vereinfachen

  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */


public class MyIO {

    private MyIO() {}

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyIO.writeln(MyIO.readFraction("Bitte Zähler des gewünschten Bruchs eingeben", "Bitte Nenner des gewünschten Bruchs eingeben").toString());
    }

    public static Fraction readFraction(String prompt1, String prompt2){
        BigInteger nenner, zähler;
        zähler = readZähler(prompt1);
        nenner = readNenner(prompt2);
        return new Fraction(zähler, nenner);
    }
    private static BigInteger readZähler(String prompt) {
        MyIO.writeln(prompt);
        BigInteger returnInt;
        try{
            returnInt = new BigInteger(scanner.nextLine());
            return returnInt;
        }catch (NumberFormatException e) {
            MyIO.writeln("Zähler ungültig, bitte probiere es nochmal");
        }
        return readZähler(prompt);
    }

    private static BigInteger readNenner(String prompt) {
        MyIO.writeln(prompt);
        BigInteger returnInt;
        try{
            returnInt = new BigInteger(scanner.nextLine());
            return returnInt;
        }catch (NumberFormatException e) {
            MyIO.writeln("Nenner ungültig, bitte probiere es nochmal");
        }
        return readNenner(prompt);
    }


    public static String promptAndRead(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }


    public static long readLong(String prompt) {
        System.out.println(prompt);
        return Long.valueOf(scanner.nextLine().trim());
    }

    public static double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.valueOf(scanner.nextLine().trim());
    }

    public static float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.valueOf(scanner.nextLine().trim());
    }

    public static BigInteger readBigInt(String prompt) {
        System.out.println(prompt);
        return new BigInteger(scanner.nextLine().trim());
    }

    public static BigDecimal readBigDeciman(String prompt) {
        System.out.println(prompt);
        return new BigDecimal(scanner.nextLine().trim());
    }

    public static void write(String string){
        System.out.print(string);
    }

    public static void writeln(String string) {
        System.out.println(string);
    }

}
