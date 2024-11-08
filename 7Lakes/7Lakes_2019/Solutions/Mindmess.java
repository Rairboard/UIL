import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Brainfrick {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("mindmess.in"));

        while (in.hasNext()) {
            char[] line = in.nextLine().toCharArray();

            GrowableByteArray arr = new GrowableByteArray();
            int arrIndex = 0;

            char[] input = null;
            int inputIndex = 0;

            for (int lineIndex = 0; lineIndex < line.length; lineIndex++) {
                char cur = line[lineIndex];

                if (cur == '>') {
                    arrIndex++;
                } else if (cur == '<') {
                    arrIndex--;
                } else if (cur == '+') {
                    arr.set(arrIndex, (byte) (arr.get(arrIndex) + 1));
                } else if (cur == '-') {
                    arr.set(arrIndex, (byte) (arr.get(arrIndex) - 1));
                } else if (cur == '.') {
                    System.out.print((char)arr.get(arrIndex));
                } else if (cur == ',') {
                    if(input == null) {
                        input = in.nextLine().toCharArray();
                    }
                    arr.set(arrIndex, (byte) (input[inputIndex++]));
                } else if (cur == '[' && arr.get(arrIndex) == 0) {
                    int loop = 1;
                    while (loop > 0) {
                        cur = line[++lineIndex];
                        if (cur == '[') {
                            loop++;
                            } else if (cur == ']') {
                                loop--;
                        }
                    }
                } else if (cur == ']' && arr.get(arrIndex) > 0) {
                    int loop = 1;
                    while (loop > 0) {
                        cur = line[--lineIndex];
                        if (cur == '[') {
                            loop--;
                        } else if (cur == ']') {
                            loop++;
                        }
                    }
                }
            }
            if(in.hasNext())
            	in.nextLine();
            System.out.println();
        }
    }

    static class GrowableByteArray {
        private int[] data;

        public GrowableByteArray() {
            this.data = new int[128];
        }

        public int get(int index) {
            if (index >= data.length) {
                data = Arrays.copyOf(data, data.length * 2);
            }
            return data[index];
    }

        public void set(int index, int num) {
            if(num < 0) {
                num += 256;
            } else if (num > 255) {
                num -= 256;
            }

            if (index >= data.length) {
                data = Arrays.copyOf(data, data.length * 2);
            }
            data[index] = num;
        }
    }
}
