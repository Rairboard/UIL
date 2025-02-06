import java.io.File;
import java.util.*;

public class Five{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("five.dat"));
		int reps = file.nextInt();
		file.nextLine();
		for(int x = 0;x < reps;x++) {
			String[] chars = file.nextLine().split("",0);
			ArrayList<String> charList = new ArrayList<String>(Arrays.asList(chars));
			charList.sort(Comparator.naturalOrder());
			for(int y = 0; y<charList.size(); y++) {
				System.out.print(charList.get(y));
			}
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		Five a=new Five();
		a.run();
	}
}