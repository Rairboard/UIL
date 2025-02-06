import java.io.File;
import java.util.Scanner;

public class Education{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("education.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			int sum = 0;
			for(int x = 0; x<3;x++) {
				sum+=file.nextInt();
			}
			System.out.println(sum);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Education a=new Education();
		a.run();
	}
}