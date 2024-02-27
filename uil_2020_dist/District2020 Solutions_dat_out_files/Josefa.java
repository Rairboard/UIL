/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.util.*;
import java.io.*;
public class Josefa {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("josefa.dat"));
		int n = f.nextInt();
		while(f.hasNext()) {
			int i = f.nextInt();
			String bin = Integer.toBinaryString(i);
			if(bin.length()>8)
				bin = bin.substring(bin.length()-8);
			else if(bin.length()<8) {
				int zeroes = 8 - bin.length();
				for(int x = 1;x<=zeroes;x++)
					bin = "0" + bin;
			}
			System.out.println(i + " = " + bin);
		}
	}   
}
