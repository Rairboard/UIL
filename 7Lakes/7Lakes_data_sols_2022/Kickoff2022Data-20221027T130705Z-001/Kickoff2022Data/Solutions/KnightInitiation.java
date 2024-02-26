import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class KnightInitiation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt(), X = in.nextInt();
            in.nextLine();
            int[] line = new int[N];
            char[] friendIndexes;
            int sumNonFriends = 0;
            ArrayList<Integer> friends = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                line[j] = in.nextInt();
            }
            in.nextLine();

            friendIndexes = in.nextLine().replaceAll(" ", "").toCharArray();
            for (int j = 0; j < N; j++) {
                if (friendIndexes[j] == '1') {
                    friends.add(line[j]);
                } else {
                    sumNonFriends += line[j];
                }
            }

            if (sumNonFriends >= X) {
                System.out.println(0);
            } else {
                Collections.sort(friends);
                Collections.reverse(friends);

                int count = 0;
                int sum = sumNonFriends;
                while (sum < X) {
                    sum += friends.remove(0);
                    count++;
                }
                System.out.println(count);
            }
        }
    }
}
