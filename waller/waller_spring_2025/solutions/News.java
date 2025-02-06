import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class News {
	public static void main(String[]args)throws Exception{
		new News().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("news.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			String s = " " + file.nextLine().trim() + " ";
			if(s.matches(".*(( Thanos )|( Kang )|( Galactus )|( Ultron )|( Graviton )).*"))
				System.out.println("Calling All Heroes.");
			else if(s.matches(".*(( Magneto )|( Juggernaut )|( Sentinels )|( Mystique )|( Apocalypse )).*"))
				System.out.println("Sharpen Your Claws Wolverine.");
			else
				System.out.println("Business as Usual.");
		}
	}
}
