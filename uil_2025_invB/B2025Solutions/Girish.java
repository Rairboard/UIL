/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.*;
import java.util.*;

public class Girish {
	public static void main(String[]args)throws Exception{
		new Girish().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("girish.dat"));
		String line = file.nextLine().trim();
		ArrayList<Double> avgs = new ArrayList<Double>();
		ArrayList<Num> a = new ArrayList<Num>();
		TreeMap<Integer,Num> tm = new TreeMap<Integer,Num>();
		double sum1 = 0;
		int count = 0;
		while(!line.equals("----------")) {
			count++;
			String[] sdf = line.split(" ");
			int[] mn = new int[sdf.length];
			double sum = 0;
			for(int i = 0; i < mn.length; i++)
				mn[i] = Integer.parseInt(sdf[i]);
			for(int i : mn) {
				sum += i;
				if(!tm.containsKey(i)) {
					Num n = new Num();
					n.val = i;
					n.count = 1;
					n.missing = false;
					a.add(n);
					tm.put(i, n);
				}
				else
					tm.get(i).count++;
			}
			for(int i:tm.keySet()) {
				boolean b = true;
				int j = 0;
				while(j < mn.length && b)
					b &= i != mn[j++];
				tm.get(i).missing |= b;
			}
			sum1 += sum;
			avgs.add(sum / mn.length);
			line = file.nextLine().trim();
		}
		Collections.sort(avgs);
		Collections.sort(a);
		sum1 /= count;
		double med = 0;
		if(avgs.size() % 2 == 0)
			med = (avgs.get(avgs.size() / 2) + avgs.get(avgs.size() / 2 - 1)) / 2;
		else
			med = avgs.get(avgs.size() / 2);
		System.out.printf("Median Mean: %.2f%n",med);
		System.out.printf("Mean Sum: %.2f%n",sum1);
		System.out.printf("Mode Kinda: %d%n",a.get(0).val);
		//System.out.println(avgs);
		file.close();
	}
}
class Num implements Comparable<Num>{
	int val, count;
	boolean missing;
	
	public int compareTo(Num n) {
		if(!missing && n.missing)
			return 1000;
		if(missing && !n.missing)
			return -1000;
		return n.count - count;
	}
	
	public String toString() {
		return "" + val+" "+count+" "+missing;
	}
}