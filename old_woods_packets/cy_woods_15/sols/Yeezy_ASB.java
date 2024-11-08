import java.util.Scanner;
import java.io.File;

public class Yeezy {

	public static void main(String[] args) throws Exception{
		Yeezy y = new Yeezy();
		y.run();
	}
	
	void run() throws Exception{
		Scanner file = new Scanner(new File("yeezy.dat"));
		int times = file.nextInt();
		file.nextLine();
		for (int asdf = 0; asdf<times; asdf++){
			double wage = file.nextDouble();
			System.out.println("Case " + (asdf+1) + ": " + (0.25*((43*20)*wage)>=2000));
			if (file.hasNextLine())
				file.nextLine();
		}
	}

}
