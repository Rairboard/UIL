//Solution - UIL Region 2019
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Rosa {

    static ArrayList file1Out;
    static ArrayList file2Out;
    static ArrayList Dif;

    public static Map<String, String> readFile(String key, Scanner keyb) {
        Map<String, String> Current = new TreeMap<>();
        try {

            String data[] = keyb.nextLine().split(",");
            int location = -1;
            for (int i = 0; i < data.length; i++) {

                if (data[i].equals(key)) {
                    location = i;
                }
            } 
            String line = keyb.nextLine();
            while (!line.contains("EOF")) {
                String Line[] = line.split(",");
                Current.put(Line[location], line);
                line = keyb.nextLine();
            }
        } catch (Exception dude) {
            System.out.println("BAD " + dude);
        }
        return Current;
    }

    static void Output1(String file1N, String file2N, Map<String, String> DataSet1, Map<String, String> DataSet2) {
        System.out.println(file1N + " Missing from " + file2N);

        for (String key1 : DataSet1.keySet()) {
            if (DataSet2.get(key1) == null) {
                System.out.println(DataSet1.get(key1));
            }
        }
    }

    static void Diff(Map<String, String> DataSet1, Map<String, String> DataSet2) {
        System.out.println("Difference between Files");

        for (String key1 : DataSet1.keySet()) {
            if (DataSet2.get(key1) != null && !(DataSet1.get(key1).equals(DataSet2.get(key1)))) {
                System.out.println(DataSet1.get(key1));
                System.out.println(DataSet2.get(key1));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner keyb = new Scanner(new File("Rosa.dat"));
        int num = Integer.parseInt(keyb.nextLine().trim());

        for (int i = 0; i < num; i++) {
            Map<String, String> DataSet1;
            Map<String, String> DataSet2;
            String key = keyb.nextLine();

            String file1 = keyb.nextLine();

            DataSet1 = readFile(key, keyb);
            String file2 = keyb.nextLine();
            DataSet2 = readFile(key, keyb);

            Output1(file1, file2, DataSet1, DataSet2);
            Output1(file2, file1, DataSet2, DataSet1);
            Diff(DataSet1, DataSet2);
        }
    }
}
