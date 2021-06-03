package src.main.first;

import java.io.*;

public class Janus {
   public static FileReader fileReader;

    static {
        try {
            fileReader = new FileReader("src/main/first/Janus.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static BufferedReader bufferedReader = new BufferedReader(fileReader);

    public static void main(String[] args) throws IOException {


        while(bufferedReader.readLine() != null) {
            if(bufferedReader.readLine() != null) {
                System.out.println(bufferedReader.readLine());
            }
        }
    }
}
