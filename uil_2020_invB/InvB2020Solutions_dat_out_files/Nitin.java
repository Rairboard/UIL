/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

import static java.lang.System.out;
public class Nitin {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("nitin.dat"));
		Queue<String> dogs = new LinkedList<String>();
		Queue<String> cats = new LinkedList<String>();
		int p = f.nextInt();
		for(int i = 1; i <= p; i++) {
			String petName = f.next();
			String species = f.next();
			if(species.equals("D"))
				dogs.add(petName);
			else
				cats.add(petName);
		}
		int a = f.nextInt();
		for(int i = 1; i <= a; i++) {
			String adopter = f.next();
			String species = f.next();
			if(species.equals("D")) {
				if(!dogs.isEmpty())
					out.println(adopter+" DOG "+dogs.remove());
				else
					out.println(adopter+" WAIT LIST DOG");
			}
			else {
				if(!cats.isEmpty())
					out.println(adopter+" CAT "+cats.remove());
				else
					out.println(adopter+" WAIT LIST CAT");
			}
		}

	}

}
