import java.util.*;
import java.io.*;

public class Clothes{
	private static class Clothing implements Comparable<Clothing>{
		String n, t, c, s;
		public Clothing(String name, String type, String color, String store){
			n=name;
			t=type;
			c=color;
			s=store;
		}
		public int compareTo(Clothing b){
			if(!this.t.equals(b.t)){
				return this.t.compareTo(b.t);
			}
			else if(!this.c.equals(b.c)){
				return this.c.compareTo(b.c);
			}
			else 
				return this.s.compareTo(b.s);
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("clothes.in"));
		int sets = sc.nextInt();
		for(int set=0;set<sets;set++){
			int n = sc.nextInt();
			Clothing[] arr = new Clothing[n];
			for(int i=0;i<n;i++){
				arr[i] = new Clothing(sc.next(),sc.next(),sc.next(),sc.next());
			}
			Arrays.sort(arr);
			for(int i=0;i<n;i++){
				System.out.println(arr[i].n);
			}
		}
		sc.close();
	}
}