import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class GameSummary
{
	String teamWinning = "";

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("summary.dat"));
		int times = file.nextInt();
		file.nextLine();
		for(int e = 0; e < times; e ++){
			String t1 = file.next();
			String t2 = file.next();
			int numOfScores = file.nextInt();
			file.nextLine();
			char t1letter = t1.charAt(0);
			char t2letter = t2.charAt(0);
			int t1total = 0;
			int t2total = 0;
			int numOfLeadChanges = 0;
			int numOfTies = 0;
			for(int x = 0; x < numOfScores; x ++){
				char teamName = file.next().charAt(0);
				int points = file.nextInt();
				int newTeamScore = 0;
				if(teamName == t1letter){
					newTeamScore = t1total + points;
					if((t1total < t2total || t1total == t2total) && newTeamScore > t2total){
						numOfLeadChanges++;
					}
					t1total+=points;
				}
				else if(teamName == t2letter){
					newTeamScore = t2total + points;
					if((t2total < t1total || t1total == t2total) && newTeamScore > t1total){
						numOfLeadChanges++;
					}
					t2total+=points;
				}
				if(t1total == t2total){
					numOfTies ++;
				}
			}
			System.out.println("* GAME SUMMARY *");
			System.out.println(t1 + " " + t1total);	
			System.out.println(t2 + " " + t2total);
			System.out.println("Number of Lead Changes: " + numOfLeadChanges);
			System.out.println("Number of Ties: " + numOfTies);
			System.out.println();
		}
		
	}

	public static void main(String[] args)throws Exception
	{
		GameSummary a=new GameSummary();
		a.run();
	}
}