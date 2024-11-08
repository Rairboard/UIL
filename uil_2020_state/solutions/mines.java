import java.util.*;
import java.io.*;

public class mines {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("mines.dat"));
//        Scanner bob = new Scanner(System.in);
        int n = bob.nextInt();
        while(n-->0) {
            int r = bob.nextInt();
            int c = bob.nextInt();
            bob.nextLine();
            char[][] mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = bob.nextLine().toCharArray();
            }
            int x = 0;
            int y = 0;
            for (int i = 0; i < r; i++) {
               for(int j = 0; j < c; j++) {
                   if(mat[i][j] == 'G') {
                       x = i;
                       y = j;
                   }
                   if(mat[i][j] == 'L') {
                       mat[i][j] = '#';
                       int[] arr = {-1,0,1,0,1,-1,1,-1};
                       int[] arr1 = {0,1,0,-1,1,-1,-1,1};
                       for(int p = 0; p < 8; p++) {
                           try
                           {
                               mat[i+arr[p]][j+arr1[p]] = '#';
                           }
                           catch(Exception e){}
                       }
                   }
               }
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(x);
            q.add(y);
            boolean found = false;
            while(!q.isEmpty())
            {
                int r1 = q.poll();
                int c1 = q.poll();
                if(r1 < 0 || r1 >= r || c1 < 0 || c1 >= c || mat[r1][c1] == '#')
                {
                    continue;
                }
                if(mat[r1][c1] == 'H')
                {
                    found = true;
                    break;
                }

                mat[r1][c1] = '#';
                int[] arr = {-1,0,1,0};
                int[] arr1 = {0,1,0,-1};
                for(int i =0 ; i < 4; i++) {
                    q.offer(r1+arr[i]);
                    q.offer(c1+arr1[i]);
                }
            }
            System.out.println(found == true ? "My Baby!" : "Dadgummit!");
        }
    }

    public static void main(String[] args) throws Exception {
        new mines().run();
    }
}
