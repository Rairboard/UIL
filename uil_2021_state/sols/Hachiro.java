import java.io.File;
import java.io.IOException;
import java.util.*;

public class Hachiro {

	public static void main(String[] args) throws IOException 
	{
		System.out.println("6A District 33 Soccer Table");
		System.out.printf("%-8s%3s%3s%3s%3s%4s\n", "Team","W","T","L","P","GD");
		Scanner f = new Scanner(new File("hachiro.dat"));
		Map<String,Team> table = new TreeMap<String,Team>();
		int matches = f.nextInt();
		for(int n = 1; n <= matches; n++) 
		{
			String homeTeam = f.next();
			int hScore = f.nextInt();
			String visitingTeam = f.next();
			int vScore = f.nextInt();
			if(!table.containsKey(homeTeam))
				table.put(homeTeam, new Team(homeTeam));
			if(!table.containsKey(visitingTeam))
				table.put(visitingTeam, new Team(visitingTeam));
			Team home = table.get(homeTeam);
			Team away = table.get(visitingTeam);
			home.gdiff += hScore - vScore;
			away.gdiff += vScore - hScore;
			if(hScore==vScore)
			{
				home.ties++;
				home.points++;
				table.put(homeTeam, home);				
				away.ties++;
				away.points++;
				table.put(visitingTeam, away);
			}
			else 
			{
				String winner = hScore>vScore?homeTeam:visitingTeam;
				String loser = hScore<vScore?homeTeam:visitingTeam;
				Team t = table.get(winner);
				t.wins++;
				t.points+=3;
				table.put(winner, t);
				t = table.get(loser);
				t.losses++;
				table.put(loser, t);			
			}	
		}
		ArrayList<Team> sortable = new ArrayList<Team>();
		Set<String> keys = table.keySet();
		for(String s:keys)
			sortable.add(table.get(s));
		Collections.sort(sortable);
		for(Team t:sortable)
			System.out.printf("%-8s%3d%3d%3d%3d%4d\n",t.name,t.wins,t.ties,t.losses,t.points,t.gdiff);
		f.close();
	}
	
	public static class Team implements Comparable<Team>
	{
		String name;
		int wins,ties,losses,points,gdiff;
		
		public Team(String n)
		{
			name = n;
		}
		
		public int compareTo(Team o) 
		{
			if(points!=o.points)
				return o.points - points;
			else if(gdiff!=o.gdiff)
				return o.gdiff - gdiff;
			return 0;
		}			
	}
}


