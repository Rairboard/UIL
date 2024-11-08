import java.util.*;
import java.io.*;

public class TcGenerator {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter("Tc.txt");
        out.println("14\n" +
                "5 5 2 1\n" +
                ",,,,x\n" +
                " ,***\n" +
                "###**\n" +
                "###**\n" +
                "o##**\n" +
                "100 0 0 0 0\n" +
                "0 1 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0");
        out.println("3 3 0 0\n" +
                "###\n" +
                "o##\n" +
                "#x#\n" +
                "10 10 10\n" +
                "10 10 10\n" +
                "10 10 10");
        out.println("3 3 0 1\n" +
                ",#,\n" +
                "o*x\n" +
                ",#,\n" +
                "0 0 0\n" +
                "0 0 0\n" +
                "0 0 2");
        out.println("3 3 1 0\n" +
                ",#,\n" +
                "o*x\n" +
                ",#,\n" +
                "0 0 0\n" +
                "0 0 0\n" +
                "0 0 2");
        out.println("4 4 2 0\n" +
                "o,,, \n" +
                ",,##\n" +
                ", #x\n" +
                ",,,,\n" +
                "0 0 0 1\n" +
                "0 0 1 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "4 4 1 0\n" +
                "*,,x \n" +
                ",,,,\n" +
                ",*,*\n" +
                "o,,,\n" +
                "0 0 0 0\n" +
                "0 5 5 0\n" +
                "0 5 5 0\n" +
                "0 0 0 0");
        for (int t = 0; t < 3; t++) {
            out.println("500 500 3 3");
            for (int i = 0; i < 500; i++) {
                for (int j = 0; j < 500; j++) {
                    if (i == 0 && j == 0) {
                        out.print("o");
                        continue;
                    } else if (i == 499 && j == 499) {
                        out.print("x");
                        continue;
                    }
                    double x = Math.random();
                    if (x < 0.05) {
                        out.print(",");
                    } else if (x < 0.1) {
                        out.print(" ");
                    } else if (x < 0.55) {
                        out.print("#");
                    } else {
                        out.print("*");
                    }
                }
                out.println();
            }
            for (int i = 0; i < 500; i++) {
                for (int j = 0; j < 500; j++) {
                    if (Math.random() < 0.2) {
                        out.print((int) (Math.random() * 100));
                    } else {
                        out.print(0);
                    }
                    if (j != 499) out.print(" ");
                }
                out.println();
            }
        }
        out.println("1 8 2 3");
        out.println("o,,    x");
        out.println("0 0 0 0 0 0 0 0");
        out.println("50 50 1 0");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (i == 0 && j == 0) out.print("o");
                else if (i == 49 && j == 49) out.print("x");
                else if (i == 48 && j == 49 || i == 48 && j == 48 || i == 49 && j == 48) out.print("*");
                else out.print(",");
            }
            out.println();
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (i == 49 && j == 49) out.print("1");
                else out.print("0");
                if (j != 49) out.print(" ");
            }
            out.println();
        }
        out.println("500 500 1 10");
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                if (i == 0 && j == 0) {
                    out.print('o');
                    continue;
                }
                if (i == 499 && j == 499) {
                    out.print('x');
                    continue;
                }
                double x = Math.random();
                if (x < 0.1) {
                    out.print(',');
                }
                else {
                    out.print(' ');
                }
            }
            out.println();
        }
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                out.print('0');
                if (j != 499) out.print(' ');
            }
            out.println();
        }
        out.println("700 700 0 0");
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 700; j++) {
                if (i == 0 && j == 0) out.print('o');
                else if (i == 699 && j == 699) out.print('x');
                else out.print('*');
            }
            out.println();
        }
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 700; j++) {
                out.print(700);
                if (j != 699) out.print(" ");
            }
            out.println();
        }
        out.println("100 100 2 2");
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == 1 && j == 1) out.print('o');
                else if (i == 98 && j == 98) out.print('x');
                else if (Math.random() < 0.5) {
                    out.print('#');
                }
                else {
                    out.print('*');
                }
            }
            out.println();
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                out.print(1);
                if (j != 99) out.print(" ");
            }
            out.println();
        }
        out.close();
    }

}