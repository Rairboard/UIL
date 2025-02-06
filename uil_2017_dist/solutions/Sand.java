import java.io.File;
import java.util.Scanner;

public class Sand{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("sand.dat"));
		int reps = file.nextInt();
		for(int x = 0;x < reps;x++) {
			int h = file.nextInt();
			for(int y = 0; y < h; y++) {
				for(int z = 0; z <= y; z++) {
					System.out.print("$");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		Sand a=new Sand();
		a.run();
	}
}