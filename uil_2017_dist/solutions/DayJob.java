import java.io.File;
import java.util.Scanner;

public class DayJob{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("dayjob.dat"));
		int reps = file.nextInt();
		int sum = 0;
		for(int q=0; q<reps+1; q++)
		{
			if(file.nextLine().contains("GMO")) {
				sum++;
			}
		}
		System.out.print(sum + " food(s) contain(s) GMOs");
	}

	public static void main(String[] args)throws Exception
	{
		DayJob a=new DayJob();
		a.run();
	}
}