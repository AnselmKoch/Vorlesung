package src.main.first;

import java.math.BigInteger;

public class MyMath {

    /*Dieses Programm vereinfacht Mathematische Vorgänge

  Version: 09.11.2020

  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */

    public static int[] nums1 = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public static void main(String args[]) {
        String value = MyIO.promptAndRead("Bitte Bruch eingeben, den Bruchstrich mit einem '/' angeben");

        if(value.contains("/")) {
            for(int i = 0; i < value.length(); i++) {
                Character  c = value.charAt(i);
                String[] nums = new String[2];
                if(c != '/') {
                    nums[0] += c;
                }else{
                }
            }
        }
    }


    public static long nextPrime(long n) {
        for(int i = 0; i < n; i++) {
            if(isPrime(n+i)) {
                return n+i;
            }
        }
        return 0;
    }

    public static boolean isPrime(long n) {
        for(int i = 2; i <= n ; i++) {
            if(n % i == 0) {
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

    public static BigInteger getMax(BigInteger...x) {
        BigInteger min = new BigInteger("0");
        for(BigInteger i : x) {
            min = min.intValue() <= i.intValue() ? i : min;
        }
        return min;
    }

    public static long getMax(long...x) {
        long min = Long.MIN_VALUE;
        for(long i : x) {
            min = min <= i ? i : min;
        }
        return min;
    }

    public static double getMax(double...x) {
        double min = Double.MIN_VALUE;
        for(double i : x) {
            min = min <= i ? i : min;
        }
        return min;
    }

    public static float getMax(float...x) {
        float min = Float.MIN_VALUE;
        for(float i : x) {
            min = min <= i ? i : min;
        }
        return min;
    }


    public static int getMax(int...x) {
        int min = Integer.MIN_VALUE;
        for(int i : x) {
            min = min <= i ? i : min;
        }
        return min;
    }

    public static String catAll(int[] n) {
        String ergebnis = "";
        for(int i = 0; i < n.length; i++) {
            ergebnis += "," + Integer.toString(n[i]);
        }
        return ergebnis;
    }

    public static String catAll(double[] n) {
        String ergebnis = "";
        for(int i = 0; i < n.length; i++) {
            ergebnis += "," + Double.toString(n[i]);
        }
        return ergebnis;
    }

    public static String catAll(long[] n) {
        String ergebnis = "";
        for(int i = 0; i < n.length; i++) {
            ergebnis += "," + Long.toString(n[i]);
        }
        return ergebnis;
    }

    public static String catAll(String[] n) {
        String ergebnis = "";
        for(int i = 0; i < n.length; i++) {
            ergebnis += "," + n[i];
        }
        return ergebnis;
    }

    public static int multiplayAll(int[] n) {
        int ergebnis = 0;
        for(int i : n) {
            ergebnis*=1;
        }
        return ergebnis;
    }

    public static long multiplyAll(long[] n) {
        long ergebnis = 0;
        for(long i: n) {
            ergebnis += i;
        }
        return ergebnis;
    }

    public static double multiplyAll(double[] n) {
        double ergebnis = 0;
        for(double i: n) {
            ergebnis += i;
        }
        return ergebnis;
    }

    public static int addAll(int[] n) {
        int ergebnis = 0;
        for(int i: n) {
            ergebnis += i;
        }
        return ergebnis;
    }
    public static long addAll(long[] n) {
        long ergebnis = 0;
        for(long i: n) {
            ergebnis += i;
        }
        return ergebnis;
    }
    public static double addAll(double[] n) {
        double ergebnis = 0;
        for(double i: n) {
            ergebnis += i;
        }
        return ergebnis;
    }


}
