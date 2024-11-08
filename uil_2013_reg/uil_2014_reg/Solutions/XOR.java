/*Region UIL 2014 Solution - #12 - XOR
Test data
12
3
2 2 1
9
2 3 3 4 3 4 3 2 2
5
2 3 5 2 5 
5
9 9 6 6 8 
7
10 8 5 6 8 6 10 
5
2 2 9 4 4 
7
2 10 10 4 10 2 4 
5
5 3 3 1 1 
11
7 4 1 2 7 4 2 9 1 1 1 
11
9 7 8 4 10 8 9 9 4 7 10 
5
8 5 5 1 8 
7
6 6 6 6 2 5 5 

Output
1
2
3
8
5
9
10
5
9
9
1
2

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class XOR{

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("xor.dat"));
        int t = sc.nextInt();
		sc.nextLine();
		while((t--)>0){
                int n = sc.nextInt(), res = 0;
                sc.nextLine();
                for(int i=0;i<n;i++)
                {
                        int x = sc.nextInt();
                        res = res^x;
                }
                System.out.println(res);
		}
	}
}
