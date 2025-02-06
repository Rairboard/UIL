import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Soup {
    public static void main(String[]args)throws Exception{
        new Soup().run();
    }
    
    public void run()throws Exception{
        Scanner file=new Scanner(new File("soup.dat"));
        int times=file.nextInt();
        file.nextLine();
        while(times-->0){
            String X = file.nextLine().trim().toLowerCase().replaceAll("\\s+",""), 
            Y = file.nextLine().trim().toLowerCase().replaceAll("\\s+","");
            int m = X.length(), n = Y.length();
            int L[][] = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0)
                        L[i][j] = 0;
                    else if (X.charAt(i - 1) == Y.charAt(j - 1))
                        L[i][j] = L[i - 1][j - 1] + 1;
                    else
                        L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
            System.out.println(L[m][n]);
        }
    }
}
