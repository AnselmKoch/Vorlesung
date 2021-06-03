package src.main.first;

public class Matrix {

    int n;
    int m;
    double[][] matrix;

    public Matrix (int n, int m, double x){
        matrix = new double[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; x < n; x++){
                matrix[i][j] = 0.0;
            }
        }
    }
    public Matrix (double[][] matrix){
        this.matrix = matrix;
        this.n = this.matrix.length;
        this.m = this.matrix[0].length;
    }

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new double[n][m];

        for (int y = 0; y < n; y++){
            for (int x = 0; x < n; x++){
                matrix[x][y] = 0.0;
            }
        }
    }

    public static void main(String[] args) {
        Matrix test = new Matrix(new double[][] {
                { 0, 1, 0, 0, 0},
                { 0, 0, 1, 0, 0},
                { 0, 0, 0, 1, 0},
                { 0, 0, 0, 0, 1},
                {-1,-1, 2, 0, 1}
        });

        Matrix test2 = new Matrix(new double[][]{
                { 0, 1, 0, 0, 0},
                { 0, 0, 1, 0, 0},
                { 0, 0, 0, 1, 0},
                { 0, 0, 0, 0, 1},
                {-1,-1, 2, 0, 1}
        });

        MyIO.writeln("Matrix:");
        MyIO.writeln(test2.toString());
        for (int i = 1; i <= 21; i++){
            MyIO.writeln("Potenz: " + i);
            test2 = test2.multiply(test);
            MyIO.writeln(test2.toString());
        }
    }

    public String toString (){
        String string = "";
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                string += this.getValue(i,j) + " ";
            }
            string += '\n';
        }
        return string;
    }

    public void setValue(int i, int j, double x) {
        if((i > 0) && (j > 0)) {
            this.matrix[i - 1][j - 1] = x;
        }
    }

    public double getValue(int i, int j) {
        if((i > 0) && (j > 0)) {
            return this.matrix[i-1][j-1];
        }else {
            return 0.0;
        }
    }

    public Matrix add(Matrix other) {
        if((this.m == other.m) && (this.n == other.n)) {
            Matrix newMatrix = new Matrix(this.n, this.m);
            for (int i = 0; i < this.n; i++) {
                for(int j = 0; j < this.m; j++) {
                    double newValue = this.getValue(i,j) + other.getValue(i,j);
                    newMatrix.setValue(i,j, newValue);
                }
            }
            return newMatrix;
        }else{
            return new Matrix(0,0);
        }
    }

    public Matrix multiply (Matrix other) {
        if (this.n == other.m && this.m == other.n) {
            Matrix newMatrix = new Matrix(this.n,other.m);
            for (int m = 1; m <= newMatrix.n; m++) {
                for (int n = 1; n <= newMatrix.m; n++) {
                    double cell = 0;
                    for (int c = 1; c <= this.m; c++){
                        cell += getValue(m,c) * other.getValue(c,n);
                    }
                    newMatrix.setValue(m, n, cell);
                }
            }
            return newMatrix;
        } else return new Matrix(1,1);
    }

}
