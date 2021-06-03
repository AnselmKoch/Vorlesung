package src.main.first;

import java.util.ArrayList;

public class WordLcm {
    private static ArrayList<String> strings = new ArrayList<String>();


    public static void main(String[] args) {


    }

    public static void kgv(int...x) {
        for(int i : x) {
            while(i % (primZahlFinden(i, i)) != 0) {

            }
        }
    }

    static int multiplizieren(int n) {
        for(int i = 0; i < n; i++) {
            int primzahl = primZahlFinden(n, n);

            if(n != primzahl) {
                if(primzahl * primzahl != n) {

                }
            }else {
                return primzahl;
            }
        }
        return 0;
    }


    static int primZahlFinden(long max, int n) {
        int p = 3;
        long searchLimit = max;

        while(p <= searchLimit) {
            long divisor = 3;
            boolean isPossiblyPrime = true;
            while(divisor * divisor <= p && isPossiblyPrime) {
                isPossiblyPrime = ((p % divisor) != 0);
                divisor += 2;
            }
            if(isPossiblyPrime) {
                if(n % p == 0) {
                    return p;
                }
            }
            p+=2;
        }
        return 0;
    }



    static void readZahlen() {
        String zahl = MyIO.promptAndRead("Bitte Zahl eingeben");
        strings.add(zahl);
        if(zahl != null) {
            readZahlen();
        }
    }
}
