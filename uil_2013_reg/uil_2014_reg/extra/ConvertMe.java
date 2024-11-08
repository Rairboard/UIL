/*Region UIL 2014 Solution - #3 ConvertMe
Test data
13
4 8
10 25
1 35
42 68
10 25
70 25
79 59
63 65
6 46
82 28
62 92
96 43
28 37

Output
2
3
-1
3
3
-1
-1
-1
8
-1
4
-1
-1

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConvertMe{
    public static int n,m;
    public static int[][] dp = new int[1001][1001];
    public static int min(int x,int y)
    {
            if(x < y)return x;
            return y;
    }
    public static int doit(int pos,int div)
    {
                if(pos > m)return (int)1e9;

                if(pos == m)
                        return 0;

                if(dp[pos][div] != -1)
                        return dp[pos][div];

                dp[pos][div] = (int)1e9;

                for(int i=2;i*i<=pos;i++)
                if(pos % i == 0)
                {
                        dp[pos][div] = min(dp[pos][div], 1 + doit(pos + i, pos));
                        if(i != pos/i)
                                dp[pos][div] = min(dp[pos][div], 1 + doit(pos + pos/i, pos));
                }

                return dp[pos][div];
    }
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("convertme.dat"));
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0){

                    n = sc.nextInt();
                    m = sc.nextInt();

                    for(int i=0;i<=(int)1e3;i++)
                            for(int j=0;j<=(int)1e3;j++)
                                dp[i][j] = -1;

                    if(n > m)System.out.println(-1);
                    else
                    {
                            int ans = doit(n,0);
                            if(ans >= (int)1e9)System.out.println(-1);
                            else System.out.println(ans);
                    }
		}

	}

}
