/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.*;
import java.util.*;

public class Ksenyia {
	public static void main(String[]args)throws Exception{
		new Ksenyia().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("ksenyia.dat"));
		int times = file.nextInt();
		HashSet<String> u = new HashSet<String>(), p = new HashSet<String>();
		file.nextLine();
		while(times-- > 0) {
			String user = file.nextLine().trim();
			String pass = file.nextLine().trim();
			//System.out.println(pass);
			String s1 = "[A-Z]\\w{7,19}";
			if(user.matches(s1) && !u.contains(user)) {
				if(pa(pass) && !p.contains(pass)) {
					System.out.println("Valid");
					p.add(pass);
					u.add(user);
				}
				else
					System.out.println("Password Invalid");
			}
			else
				if(pa(pass) && !p.contains(pass))
					System.out.println("Username Invalid");
				else
					System.out.println("Both Invalid");
		}
		file.close();
	}
	
	public boolean pa(String pass) {
		boolean b = true;
		b &= pass.matches("(^.*[A-Z].*)") && pass.matches("(^.*[!@#$%^&*?+].*)") && pass.matches("(\\S{10,30})");
		b &= pass.matches("(^.*[a-z].*)") && pass.matches("(^.*[0-9].*)") && !pass.matches(".*(.)(\\1)(\\1).*");
		return b;
	}
}
