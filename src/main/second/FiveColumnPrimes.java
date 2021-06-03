package src.main.second;

  /**
   * Erstellt insgesammt 5 Threads die jeweils alle Zahlen von 2 bis 4567 darauf überprüfen
   * ob sie Primzahlen sind, jeder Thread gibt die gefundenen Primzahlen in seiner eigenen
   * Spalte in der Konsole (mit Nr. gekenntzeichnet) aus.


  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 **/


public class FiveColumnPrimes extends Thread{

    private int p;
    private FiveColumnPrimes next;
    private int buffer = -1;
    private int pipeNr;
    private static final int pipeAmount = 5, primesAmount = 4567;

    FiveColumnPrimes(int pipeNr, int prime) {
        super("Primer- " + prime + ", Prime-Nr. " + pipeNr);
        p = prime;
        this.pipeNr = pipeNr;
        this.start();
    }

    public static void main(String[] args) {
        for(int i = 1; i <= pipeAmount; i++) {
            FiveColumnPrimes fiveColumnPrimes = new FiveColumnPrimes(i, 2);
            for(int j = 3; j<primesAmount+1; j++) {
                if(j != primesAmount) {
                    fiveColumnPrimes.send(j);
                }else{
                    fiveColumnPrimes.send(0);
                }
            }
        }

        System.out.println(currentThread() + " main beendet");

    }
    @Override
    public void run() {
        String printString = "";
        for(int i = 1; i < this.pipeNr; i++) {
            printString += "                     ";
        }
        printString += "Nr." + pipeNr + " Primzahl:" + p;
        System.out.println(printString);
        while(true){
            int n = receive();
            if(n==0) {
                if(next != null) next.send(n);
                break;
            }
            if(n%p != 0) {
                if(next != null) {
                    next.send(n);
                }else{
                    next = new FiveColumnPrimes(this.pipeNr, n);
                }
            }
        }
    }

    synchronized int receive() {
        int result = 0;
        try{
            while((result = buffer) < 0) wait();

            buffer=-1;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }



    synchronized void send(int i) {
        try{
            while(buffer >= 0) {
                wait();
            }
                buffer = i;
                notify();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
