import java.util.*;
import java.io.*;

public class Figs{
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(new File("figs.in"));
		int sets = sc.nextInt();
		for(int set=0;set<sets;set++){
			int n = sc.nextInt();
			int[] baskets = new int[n];
			int[] left = new int[n];
			for(int i=0;i<n;i++){
				baskets[i] = sc.nextInt();
				left[i] = sc.nextInt();
			}
			int figs = 0;
			boolean sol=false;
			while(!sol){
				sol=true;
				figs++;
				for(int i=0;i<n;i++){
					if(figs%baskets[i]!=left[i]||figs<baskets[i]){
						sol=false;
						break;
					}
				}
			}
			System.out.println(figs);
		}
		sc.close();
	}
}