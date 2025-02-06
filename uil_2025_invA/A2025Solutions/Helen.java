/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.*;
import java.util.*;

public class Helen {
	public static void main(String[]args)throws Exception{
		new Helen().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("helen.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			String[] s = file.nextLine().trim().split(" ");
			Term one = new Term(s[0]);
			Term two = new Term(s[2]);
			Term three = new Term(s[4]);
			char symbol = s[1].charAt(0);
			String o = solve(one, two, three, symbol);
			System.out.println(o);
		}
		file.close();
	}
	public String solve(Term one, Term two, Term thr, char symbol) {
		String ret = "";
		if(one.v) {
			ret += one.var + " = ";
			double g = 0;
			switch(symbol) {
			case '+': g = solve(thr, two, '-');break;
			case '-': g = solve(two, thr, '+');break;
			case '*': g = solve(thr, two, '/');break;
			case '/': g = solve(two, thr, '*');break;
			}
			g /= one.val;
			ret += String.format("%.3f",g);
		}
		if(two.v) {
			ret += two.var + " = ";
			double g = 0;
			switch(symbol) {
			case '-': g = solve(one, thr, '+');
					  two.val *= -1;break;
			case '+': g = solve(thr, one, '-');break;
			case '*': g = solve(thr, one, '/');break;
			case '/': g = solve(one, thr, '/');break;
			}
			g /= two.val;
			ret += String.format("%.3f",g);
		}
		if(thr.v) {
			ret += thr.var + " = ";
			double g = solve(one, two, symbol);
			g /= thr.val;
			ret += String.format("%.3f",g);
		}
		return ret;
	}
	
	public double solve(Term fir, Term sec, char symbol) {
		switch(symbol) {
		case '-':return fir.val - sec.val;
		case '+':return fir.val + sec.val;
		case '*':return fir.val * sec.val;
		case '/':return fir.val / sec.val;
		}
		return Double.POSITIVE_INFINITY;
	}
}
class Term{
	boolean v;
	int val;
	char var;
	
	public Term(String s) {
		if(s.matches(".*[a-z].*")) {
			v = true;
			val = s.matches(".*[0-9].*")? Integer.parseInt(s.replaceAll("[a-z]","")): 1;
			var = s.replaceAll("[^a-z]","").charAt(0);
		}
		else
			val = Integer.parseInt(s);
	}
}