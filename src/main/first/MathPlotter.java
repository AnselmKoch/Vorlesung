package src.main.first;

public class MathPlotter {

    interface D2Method{
        public double compute(double value);
    }


    public static void main(String[] args) {
        while(true) {
            switch (MyIO.promptAndRead("Geben sie den Namen der gewünschen Mathematischen Funktion ein:")) {
                case "sin": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                       return Math.sin(value);
                    }
                });

                case "cos": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return Math.cos(value);
                    }
                });

                case "exp": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return Math.exp(value);
                    }
                });

                case "log": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return Math.log(value);
                    }
                });

                case "sqrt": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return Math.sqrt(value);
                    }
                });

                case "tan": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return Math.tan(value);
                    }
                });

                case "square": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return value * value;
                    }
                });

                case "cube": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return Math.pow(value, 3);
                    }
                });

                case "quad": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        return Math.pow(value, 4);
                    }
                });

                case "tower": plot(new D2Method() {
                    @Override
                    public double compute(double value) {
                        double ergebnis = 1;
                        for(int i = 1; i <= value; i++){
                            ergebnis *= value;
                        }
                        return ergebnis;
                    }
                });

                case "stop":
                    MyIO.writeln("Programm wird beendet!");
                    break;
            }
        }
    }

    public static void plot(D2Method method) {
        double start = MyIO.readDouble("Start Wert eingeben:");
        double schrittGröße = MyIO.readDouble("Schrittgröße eingeben;");
        double stop = MyIO.readDouble("Stop Wert eingeben:");

        if(start < stop) {
            for (double i = start; i <= stop; i += schrittGröße) {
                MyIO.writeln(" " + i + ": " + method.compute(i));
            }
        }else if(start > stop){
            for (double i = stop; i <= start; i -= schrittGröße) {
                MyIO.writeln(" " + i + ": " + method.compute(i));
            }
        }else{
            MyIO.writeln(" " + start + ": " + method.compute(start));
        }
    }

}
