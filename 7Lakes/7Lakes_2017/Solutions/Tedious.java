import java.util.*;
import java.io.*;

public class Tedious{
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(new File("tedious.in"));
		int sets = sc.nextInt();
		for(int set=0;set<sets;set++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int x = sc.nextInt();
			
			double result = (2.0*x*Math.pow(a+b,3)*(b-(3*c*d)+(a*b)-23))/(x*x*Math.pow(c, 3)*Math.pow(d, 4));
			System.out.printf("%.3f\n", result);
		}
		sc.close();
	}
}