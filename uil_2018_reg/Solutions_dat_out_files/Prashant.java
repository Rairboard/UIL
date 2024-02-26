//UIL Region 2018 - Prashant
import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Math.*;

/*
A B C
A B C C
A B A B
A B C A B C D
A B C C C
C D E A D
A B C D E
A B B A C D C D E E
A B C D E F G H I J K
A B C D E F G H I J K L M
A B C D E F G H I J K L M N O
A A A A A 
A B D D D D
Q E F G I
B A A 
H
*/

public class Prashant {
	public static void main(String [] args) throws FileNotFoundException 
	{ 
		Scanner f = new Scanner(new File("prashant.dat"));
		while(f.hasNext()) 
		{
			String s = f.nextLine();//read data line as string
//			out.println(s);
			args = s.split(" ");//parse into args array
			int num = args.length;//assign length of array to num
			Map<String,Integer> map = new HashMap<String,Integer>();
			for(String a:args)
				if(map.get(a)==null)
					map.put(a,1);
				else
				{
					int x = map.get(a);
					map.put(a,x+1);
				}
//		out.println(map);
		long dup = 1;
		for(String a:map.keySet())
			dup*=fact(map.get(a));
		
		long com = fact(num);
//		out.println(num+"! = "+com);
//		out.println("dup! = "+dup);
		out.println(com/dup);
		}
	}
	public static long fact(long n)
	{
		if (n<=1)
			return 1;
		return n*fact(n-1);
	}
}
/*
Input:
A B C
A B C C
A B A B
A B C A B C D
A B C C C
C D E A D
A B C D E
A B B A C D C D E E
A B C D E F G H I J K
A B C D E F G H I J K L M
A B C D E F G H I J K L M N O
A A A A A 
A B D D D D
Q E F G I
B A A 
H

Output:
6
12
6
630
20
60
120
113400
39916800
6227020800
1307674368000
1
30
120
3
1

*/