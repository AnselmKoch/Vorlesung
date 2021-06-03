package src.main.first;

public class LongOrder {

    static long long1, long2, long3, long4;


    public static void main(String[] args) {
        long1 = MyIO.readLong("1. Wert eingeben");
        long2 = MyIO.readLong("2. Wert eingeben");
        long3 = MyIO.readLong("3. Wert eingeben");
        long4 = MyIO.readLong("4. Wert eingeben");

        int i = sort(long1,long2,long3,long4).length;

         for(long longString : sort(long1,long2,long3,long4)) {
             MyIO.writeln(i + ": " + longString);
                i--;
        }

    }

    public static long[] sort(long...longs) {
        long ergebnis = 0;
        for(int i = 0; i < longs.length; i++) {
            for(int j = i; j < longs.length; j++) {
                if(longs[j] > longs[i]) {
                    ergebnis = longs[j];
                    longs[j] = longs[i];
                    longs[i] = ergebnis;
                }
            }
        }
        return longs;
    }

}
