import java.util.Scanner;
import java.io.File;

public class DeathStar {

	public static void main(String[] args) throws Exception{
		DeathStar d = new DeathStar();
		d.run();
	}
	
	void run() throws Exception{
		Scanner file = new Scanner(new File("DeathStar.dat"));
		int times = file.nextInt();
		file.nextLine();
		for (int asdf = 0; asdf<times; asdf++){
			String word = file.nextLine();
			if (word.equals("Empire"))
				System.out.println("False");
			else
				System.out.println("True");
		}
	}

}
