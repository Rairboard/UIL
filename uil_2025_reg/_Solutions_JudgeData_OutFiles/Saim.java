import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Saim {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("saim.dat"));
		int times = file.nextInt();
		int[] h = new int[] {1000, 1500, 800, 1000};
		int[] rt = new int[] {100, 100, 120, 80};
		int[] rb = new int[] {200, 260, 220, 150};
		int[] lb = new int[] {40, 20, 50, 80};
		int[] record = new int[3];
		file.nextLine();
		while(times-- > 0) {
			int you = file.next().charAt(0) - 'A', saim = file.next().charAt(0) - 'A';
			int ym = 1, sm = 1;
			int rounds = file.nextInt();
			file.nextLine();
			String[] sts = null, sty = null;
			if(rounds != 0) {
				sty = file.nextLine().trim().split("\\s+");
				sts = file.nextLine().trim().split("\\s+");
			}
			int yh = h[you], sh = h[saim];
			boolean done = false;
			for(int i = 0; i < rounds; i++) {
				ym = 1;
				switch(sty[i]) {
				case "RT": sh -= sm * rt[you]; break;
				case "RB": sh -= sm * rb[you]; ym = 2; break;
				case "LB": yh += lb[you]; break;
				case "LT": ym = 0; break;
				}
				if(sh <= 0) {
					record[0]++;
					System.out.println("You");
					done = true;
					break;
				}
				sm = 1;
				switch(sts[i]) {
				case "RT": yh -= ym * rt[saim]; break;
				case "RB": yh -= ym * rb[saim]; sm = 2; break;
				case "LB": sh += lb[saim]; break;
				case "LT": sm = 0; break;
				}
				if(yh <= 0) {
					record[2]++;
					System.out.println("Saim");
					done = true;
					break;
				}
			}
			if(!done) {
				record[1]++;
				System.out.println("Draw");
			}
			//System.out.println(yh+" "+sh);
		}
		System.out.println(record[0] + "-" + record[1] + "-" + record[2]);
	}
	
	public static void main(String[]args)throws Exception{
		new Saim().run();
	}
}
