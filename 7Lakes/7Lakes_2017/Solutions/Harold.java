import java.util.*;
import java.io.*;

public class Harold {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("harold.in"));
		int sets = sc.nextInt();
		for (int set = 0; set < sets; set++) {
			double cspeed = sc.nextDouble();
			double hspeed = sc.nextDouble();
			double dist = sc.nextDouble();
			
			if(cspeed<hspeed) {
				System.out.println("Oh No!");
				continue;
			}
			
			cspeed = toFPS(cspeed);
			hspeed = toFPS(hspeed);
			double time = dist/(cspeed-hspeed);
			System.out.printf("%.2f\n", time);
		}
		sc.close();
	}
	
	public static double toFPS(double s) {
		s*=5280;
		s/=3600;
		return s;
	}
}