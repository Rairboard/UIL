import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class DataCount
{
	static Scanner f;
	public static void main(String [] args) throws FileNotFoundException 
	{
		int count = 0;
		f = new Scanner(new File("accounting.dat"));
		while(f.hasNext()){f.nextLine();count++;}//7
		f = new Scanner(new File("awepairs.dat"));
		while(f.hasNext()){f.nextLine();count++;}//10
		f = new Scanner(new File("cursed.dat"));
		while(f.hasNext()){f.nextLine();count++;}//10
		//Data Count - no data file
		f = new Scanner(new File("gpa.dat"));
		while(f.hasNext()){f.nextLine();count++;}//20
		f = new Scanner(new File("gridsearch.dat"));
		while(f.hasNext()){f.nextLine();count++;}//21
		f = new Scanner(new File("histonum.dat"));
		while(f.hasNext()){f.nextLine();count++;}//11
		f = new Scanner(new File("hollowfloyd.dat"));
		while(f.hasNext()){f.nextLine();count++;}//7
		//Say Hello - no data file
		f = new Scanner(new File("shuffle.dat"));
		while(f.hasNext()){f.nextLine();count++;}//8
		f = new Scanner(new File("sineup.dat"));
		while(f.hasNext()){f.nextLine();count++;}//7
		f = new Scanner(new File("supercomputer.dat"));
		while(f.hasNext()){f.nextLine();count++;}//10
		out.println("THERE ARE "+count+" LINES OF DATA FOR THIS PACKET");//111 with 10 files
	}
}
/*
Test Output
THERE ARE 111 LINES OF DATA FOR THIS PACKET
*/