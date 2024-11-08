import java.util.*;
import java.io.*;

public class weights {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("weightsj.dat"));
        // Scanner bob = new Scanner(System.in);
        int t = bob.nextInt();
        double[] arr = {45,25,10,5,2.5};

        while(t-->0) {
            int[] cnt = new int[arr.length];
            double d = bob.nextDouble();
            d-= 45;
            d /= 2.0;
            for(int i =0 ; i < arr.length; i++)
            {
                if(d - arr[i] >= 0) {
                    d -= arr[i];
                    cnt[i]++;
                    i--;
                }
            }
            for(int i =0 ; i < arr.length; i++) {
                if(cnt[i] > 0){
                    if((int)arr[i] == arr[i])
                    System.out.print(cnt[i] + " " + (int)arr[i] + " ");
                    else {
                        System.out.print(cnt[i] + " " + arr[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new weights().run();
    }
}
