import java.util.*;
import java.io.*;

public class Lyrics{
	
	public static int min(int a, int b, int c){
		return Math.min(Math.min(a,b),c);
	}
	
	public static int editDist(String[] l, String[] k){ //find edit distance
		int lp = l.length, kp = k.length; //store lengths
		int[][] dist = new int[lp+1][kp+1]; //distance matrix for subproblems
		for(int i=0;i<=lp;i++){
			for(int j=0;j<=kp;j++){
				if(i==0) //base case
					dist[i][j] = j;
				else if(j==0) //base case
					dist[i][j] = i;
				else if(l[i-1].equals(k[j-1])) //if equal, continue
					dist[i][j] = dist[i-1][j-1];
				else  //get the min distance of remove, insert, and replace operations
					dist[i][j] = 1 + min(dist[i][j-1], dist[i-1][j], dist[i-1][j-1]);
			}
		}
		return dist[lp][kp];
	}
	
	public static String[] readLines(int m, Scanner sc){ //helper method
		ArrayList<String> temp = new ArrayList<String>();
		for(int i=0;i<m;i++){
			String[] s = sc.nextLine().split(" ");
			for(int j=0;j<s.length;j++){
				temp.add(s[j]);
			}
		}
		String[] sa = new String[temp.size()];
		return temp.toArray(sa);
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("lyrics.in"));
		int T = sc.nextInt(); //test cases
		for(int t = 0;t<T;t++){
			int m = sc.nextInt(); //lines to read
			sc.nextLine();
			String[] lyrics = readLines(m, sc);
			String[] key = readLines(m, sc);
			System.out.println(editDist(lyrics, key));
		}
	}
}