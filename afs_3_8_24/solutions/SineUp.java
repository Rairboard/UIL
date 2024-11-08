import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

//Given diameter of circumcircle for a triangle, and two angles of the triangle
//find third angle and lengths of three sides.
public class SineUp
{
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("sineup.dat"));
		
		while(f.hasNext())
		{
			int D = f.nextInt();
			int A = f.nextInt();
			int B = f.nextInt();
			int C = 180-A-B;
			double a = D*sin(toRadians(A));
			double b = D*sin(toRadians(B));
			double c = D*sin(toRadians(C));
			out.printf("Circumcircle diameter = %d\nAngles are %d, %d and %d\nCorresponding sides are %.0f, %.0f and %.0f\n",D,A,B,C,a,b,c);
		}
	}
}
/*
Student Input
100 40 60
50 45 45
70 90 60

Student Output
Circumcircle diameter = 100
Angles are 40, 60 and 80
Corresponding sides are 64, 87 and 98
Circumcircle diameter = 50
Angles are 45, 45 and 90
Corresponding sides are 35, 35 and 50
Circumcircle diameter = 70
Angles are 90, 60 and 30
Corresponding sides are 70, 61 and 35

Test Input
100 40 60
50 45 45
70 90 60
10 45 90
999 33 66
618 78 25
26 60 60

Test Output
Circumcircle diameter = 100
Angles are 40, 60 and 80
Corresponding sides are 64, 87 and 98
Circumcircle diameter = 50
Angles are 45, 45 and 90
Corresponding sides are 35, 35 and 50
Circumcircle diameter = 70
Angles are 90, 60 and 30
Corresponding sides are 70, 61 and 35
Circumcircle diameter = 10
Angles are 45, 90 and 45
Corresponding sides are 7, 10 and 7
Circumcircle diameter = 999
Angles are 33, 66 and 81
Corresponding sides are 544, 913 and 987
Circumcircle diameter = 618
Angles are 78, 25 and 77
Corresponding sides are 604, 261 and 602
Circumcircle diameter = 26
Angles are 60, 60 and 60
Corresponding sides are 23, 23 and 23
*/