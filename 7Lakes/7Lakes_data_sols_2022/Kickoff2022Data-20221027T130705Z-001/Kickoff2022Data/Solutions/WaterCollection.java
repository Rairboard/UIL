import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WaterCollection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int indexOfZero = -1;
        int[] map = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = in.nextInt();
            if (map[i] == 0) indexOfZero = i;
        }

        int maxEdge = -1;

        int[] sortedMap = Arrays.copyOf(map, map.length);
        Arrays.sort(sortedMap);

        maxEdge = sortedMap[sortedMap.length - 2];
        
        int left = 0;
        int right = 0;

        while (map[indexOfZero - left] < maxEdge) {
            left++;
        }

        while (map[indexOfZero + right] < maxEdge) {
            right++;
        }

        int area = (left + right + 1) * maxEdge;

        for (int i = indexOfZero - left; i <= indexOfZero + right; i++) {
            area -= Math.min(maxEdge, map[i]);
        }

        System.out.println(area);
    }
}
