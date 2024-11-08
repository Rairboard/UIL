import java.util.*;
import java.io.*;

public class rack {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("rackj.dat"));
        // Scanner bob = new Scanner(System.in);
        int t = bob.nextInt();
        while(t-->0) {
            char[][] mat = new char[bob.nextInt()][bob.nextInt()];
            bob.nextLine();
            for(int i = 0; i < mat.length; i++) {
                mat[i] = bob.nextLine().toCharArray();
            }
            int cnt = 0;
            for(int i = 0; i < mat.length; i++) {
                out: for (int j = 0; j < mat[i].length; j++) {
                    if(mat[i][j] == 'S') {
                        int[] arr = {-1,0,1,0,1,-1,1,-1};
                        int[] arr1 = {0,1,0,-1,1,-1,-1,1};
                        for(int p = 0; p < arr.length; p++) {
                            try
                            {
                                if(mat[i+arr[p]][j+arr1[p]] != '.'){
                                    continue out;
                                }
                            }
                            catch(Exception e){}
                        }
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void main(String[] args) throws Exception {
        new rack().run();
    }
}
