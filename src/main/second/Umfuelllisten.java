package src.main.second;

/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 */

import src.main.first.MyIO;

import java.util.ArrayList;
import java.util.Arrays;

public class Umfuelllisten {

    private static ArrayList<int[]> umfuellungen = new ArrayList();
    private static int[][] LINKS;
    private static int[] volume = new int[5];

    private static void fuellUm(int[] state) {
        fuellUm(state.clone(), 0, 1);
        fuellUm(state.clone(), 0, 2);
    }

    private static void fuellUm(int[] state, int from, int to) {
        int restVolume = volume[to] - state[to];
        if (restVolume > 0) {
            if (state[from] >= restVolume) {
                state[to] = volume[to];
                state[from] -= restVolume;
            } else {
                state[to] += state[from];
                state[from] = 0;
            }
        }
        if (!umfuellungen.stream().anyMatch(c -> Arrays.equals(c, state))) {
            umfuellungen.add(state);
            for (int[] toFill : LINKS) {
                fuellUm(state.clone(), toFill[0], toFill[1]);
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            volume[i] = MyIO.readInt("Volumen des " + (i+1) +". Behälters eingeben...");
        }

        LINKS = new int[][] {{0,1},{0,2},{0,2},{1,2},{1,3},{2,3},{2,4},{3,0},{3,4}};
        int[] startVolume = {volume[0],0,0,0,0};
        umfuellungen.add(startVolume);
        fuellUm(startVolume);

        umfuellungen.stream().map(Arrays::toString).sorted().forEach(System.out::println);
    }
}
