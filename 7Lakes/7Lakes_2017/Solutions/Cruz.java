import java.util.*;
import java.io.*;

public class Cruz{
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(new File("cruz.in"));
		int sets = sc.nextInt();
		for(int set=0;set<sets;set++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			int count = 0;
			for(int i=0;i<n;i++){
				String line = sc.next();
				for(int c=0;c<m;c++){
					if(line.charAt(c)=='#')count++;
				}
			}
			int time = count * j;
			if(time<=k)System.out.println("YES");
			else System.out.println("NO");
		}
		sc.close();
	}
}