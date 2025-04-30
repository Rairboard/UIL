import java.util.*;
import static java.lang.System.out;
import java.io.*;
public class Joseph {

	public static void main(String[] args) throws IOException
	{
		Scanner f = new Scanner(new File("joseph.dat"));
		ArrayList<Integer> scores1 = new ArrayList<Integer>();
		ArrayList<Integer> scores2 = new ArrayList<Integer>();
		ArrayList<String> names1 = new ArrayList<String>();
		ArrayList<String> names2 = new ArrayList<String>();
		ArrayList<Match> matches = new ArrayList<Match>();
		Scanner line1 = new Scanner(f.nextLine());
		Scanner line2 = new Scanner(f.nextLine());
		Scanner line3 = new Scanner(f.nextLine());
		Scanner line4 = new Scanner(f.nextLine());
		while(line1.hasNext())
			{
			names1.add(line1.next());	
			scores1.add(line2.nextInt());
			}
		while(line3.hasNext())
			{
			names2.add(line3.next());	
			scores2.add(line4.nextInt());
			}
		int minDiff = Integer.MAX_VALUE;
		int dater1 = -1;
		int dater2 = -1;
		for(int i = 0; i < scores1.size(); i++) 
		{
			minDiff = Integer.MAX_VALUE;
			for(int j = 0; j < scores2.size(); j++) 
			{
				int diff = Math.abs(scores1.get(i) - scores2.get(j));
				if(diff <= minDiff) 
				{
					minDiff = diff;
					dater1 = i;
					dater2 = j;
				}
				if(minDiff <= 10 && dater2 == j) 
				{
					matches.add(new Match(names1.get(dater1),names2.get(dater2),minDiff));
					minDiff = Integer.MAX_VALUE;
				}
			}				
		}			
		Collections.sort(matches);
		for(Match m:matches)
			out.println(m);
		line1.close();line2.close();line3.close();line4.close();
		f.close();
	}
	
	public static class Match implements Comparable<Match>{
		
		String dater1,dater2;
		int matchScore;
		
		public Match(String dater1, String dater2, int matchScore) {
			super();
			this.dater1 = dater1;
			this.dater2 = dater2;
			this.matchScore = matchScore;
		}
		
		public int compareTo(Match o) {
			if(matchScore < o.matchScore)
				return -1;
			else if(matchScore > o.matchScore)
				return 1;
			else if(dater1.compareTo(o.dater1) != 0) 
				return dater1.compareTo(o.dater1);
			else
				return dater2.compareTo(o.dater2);
		}
		
		public String toString()
		{
			return dater1 + " " + dater2 + " " + matchScore;
		}		
	}
}
