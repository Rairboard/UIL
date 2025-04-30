/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

public class Akash {
    public static void main(String[] args) {
        solve();
        //solvePrint();
    }

    public static void solve() {
        int MAX = 19;

        int [] arr = new int[MAX];

        for(int x = 0;  x < MAX; x++) {
            arr[x] = 2 + x;
        }

        StringBuilder out = new StringBuilder();

        for(Integer x : arr) {
            out.append(x).append(" ");
        }

        System.out.println(out.toString().trim());

        for(int x = 2; x <= 20; x++) {
            boolean removed = false;
            for(int i = 0; i < MAX; i++) {
                if(arr[i] % x == 0 && arr[i] != x) {
                    arr[i] = -1;
                    removed = true;
                }
            }
            if(removed) {
                StringBuilder s = new StringBuilder();

                for(Integer a : arr) {
                    if(a != -1) {
                        s.append(a).append(" ");
                    }
                }
                System.out.println(s.toString().trim());
            }
        }
    }

    public static void solvePrint() {
        System.out.println("2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        System.out.println("2 3 5 7 9 11 13 15 17 19");
        System.out.println("2 3 5 7 11 13 17 19");
    }
}
