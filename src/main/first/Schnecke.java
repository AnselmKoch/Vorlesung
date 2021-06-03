package src.main.first;

public class Schnecke {

    static int n;
    static int count=1;
    static String name = "Anselm_Koch_";
    static char[][] matrix;

    public static void main(String[] args) {
        n = MyIO.readInt("Zahl zwischen 0 und 49 eingeben");
        if ((n <= 0) || (n > 49)) {
            MyIO.writeln("Die Zahl muss zwischen 0 und 49 sein!");
            n = 1;
        }

        matrix = new char[n][n];

        for (int y = 0; y < n; y++){
            for (int x = 0; x < n; x++){
                matrix[x][y] = ' ';
            }
        }


        drawSchnecke(n,n,0);

        for(int i = 0; i < matrix.length; i++) {
            int yaxis = matrix[i].length;

            for(int j = 0; j < yaxis; j++) {
                MyIO.write(matrix[j][i] + " ");
            }
            MyIO.writeln("");
        }
    }

    public static void drawSchnecke(int x, int y, int durchlauf) {
            int currentDurchlauf = durchlauf;
            int currentX = x - 1;
            int currentY = y - 1;

            if((currentX > 0) && (currentY > 0)) {

            if (durchlauf == 0) {
                for (int i = currentDurchlauf; i < currentX; i++) {
                    matrix[i][currentY] = writeName(count);
                    count++;
                }
            } else {
                for (int i = currentDurchlauf - 1; i < currentX; i++) {
                    matrix[i][currentY] = writeName(count);
                    count++;
                }
            }
            for (int i = currentY; i > currentDurchlauf; i--) {
                matrix[currentX][i] = writeName(count);
                count++;
            }
            for (int i = currentX; i > currentDurchlauf; i--) {
                matrix[i][durchlauf] = writeName(count);
                count++;
            }
            for (int i = currentDurchlauf; i < currentY - 1; i++) {
                matrix[currentDurchlauf][i] = writeName(count);
                count++;
            }
            drawSchnecke(currentX - 1, currentY - 1, currentDurchlauf + 2);

        }
    }

    public static char writeName(int i) {
        while(i > name.length()) {
            i -= name.length();
        }
        return name.charAt(i-1);
    }
}

