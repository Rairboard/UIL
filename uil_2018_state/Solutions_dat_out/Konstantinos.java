//UIL State 2018 - Konstantinos - Sample Solution
import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
public class Konstantinos {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("Konstantinos.dat"));
		while(f.hasNext()){
			int p1=f.nextInt();
			int q1=f.nextInt();
			int r1=f.nextInt();
			int p2=f.nextInt();
			int q2=f.nextInt();
			int r2=f.nextInt();
			double dist = sqrt(pow(p2-p1,2) + pow(q2-q1,2));
			double radSum = r1+r2;
			if(dist == radSum)
				out.println("EXTERNALLY TANGENT");
			else
			if(dist > radSum)
				out.println("NON-INTERSECTING");
		    else
			if(abs(r1-r2)==dist)
				out.println("INTERNALLY TANGENT");
			else
			if(abs(r1-r2)>dist)
				out.println("NESTED");
			else
				out.println("INTERSECTING");
		}
	}
}

                              
          	