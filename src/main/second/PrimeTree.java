package src.main.second;


/**
 * Erstellt mehrere Threads nacheinander in Baumstruktur, jeder Thread untersucht jede Zahl darauf ob
 * sie eine Primzahl ist.
 * Das besondere an diesem Programm ist dass es zwar die Threats löscht aber es parallel schneller neue
 * erzeugt was zurfolge hat, dass das Programm unendlich lange neue Threads erstellt und diese parallel wieder löscht
 * Außerdem geht werden nicht nur Primzahlen generiert.
 @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 **/

public class PrimeTree extends Thread {
    private int p;
    private PrimeTree left, right;
    private int buffer = -1;

    PrimeTree(int prime) {
        super("Primer- " + prime);
        p = prime;
        this.start();
    }

    public static void main(String[] args) {
        PrimeTree primeTree = new PrimeTree(2);
        for (int i = 2; i <= 100; primeTree.send(i++)) ;
        primeTree.send(0);

        System.out.println(currentThread() + " main beendet");

    }

    @Override
    public void run() {
        System.out.println(currentThread() + " Primzahl: " + p);
        while (true) {
            int n = receive();
            if (n == 0) {
                if (left != null) left.send(n);
                if (right != null) right.send(n);
                break;
            }else {
                if (n % p != 0) {
                    if (left != null) left.send(n);
                    else left = new PrimeTree(n);
                    if (right != null) right.send(2*n+p);
                    else right = new PrimeTree(2 * n + p);
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
