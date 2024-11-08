import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;

public class histonum {
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("histonum.dat"));
		int[]list=new int[10];
		while(f.hasNext()) 
		{
			String s = f.next();
			char[]let=s.toCharArray();
			for(char a:let)
				list[a-48]++;
		}
		int x=0;
		for(int i:list)
		{
			if(i>0)
			{out.printf("%d|",x++);
			while(i-->0)
				out.print("*");
			out.println();
			}
			else x++;
		}
	}
}

/*
Student Input
35987
176253
20293805
2387
3981

Student Output
0|**
1|**
2|****
3|*****
5|***
6|*
7|***
8|****
9|***

Test Input
345987 
1762534 
2293485 
23874 
34981 
345872 
6234721 
34682837 
2345485
98989898999999999999999999999999999
21212121212

Test Output
1|********
2|***************
3|**********
4|**********
5|******
6|***
7|******
8|************
9|**********************************

*/