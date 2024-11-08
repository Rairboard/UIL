import java.io.*;
import java.util.*;

public class ProdDiv{

	public static void main(String[] args) throws FileNotFoundException {
		// read in number of test cases
		Scanner sc = new Scanner(new File("proddiv.dat"));

		int t = sc.nextInt();

		while(t-- > 0){
			// read in two values then run through simulation
			int a = sc.nextInt(), b = sc.nextInt();

			System.out.println(calculate(a,b));
		}
	}

    private static boolean isprime(int x)
    {
            if(x == 1)return false;

            if(x == 2)return true;

            if(x%2 == 0)return false;

            for(int i=3;i * i <=x; i += 2)
                    if(x % i == 0)return false;

            return true;
    }
	private static int calculate(int a,int b) {

                    int ans = 0;

                    for(int i=a;i<=b;i++)
                            if(isprime(i) == true)
                                    ans = ans + 1;

                    return ans;
	}

}
