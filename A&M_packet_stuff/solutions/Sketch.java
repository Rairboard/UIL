
import java.io.*;
import java.util.*;

class Sketch{
	char[]chars="!@#$%&".toCharArray();
	public void run() throws Exception {
		Scanner file=new Scanner(new File("sketch.dat"));
	    while(file.hasNext()){
	    	int[]keys= {file.nextInt(),file.nextInt(),file.nextInt()};
	    	if(keys[1]==1) {
	    		System.out.println(chars[keys[2]]);
	    		file.nextLine();
	    		continue;
	    	}
	    	switch(keys[0]) {
	    	case 0:print0(keys[1],chars[keys[2]],file.nextBoolean());break;
	    	case 1:print1(keys[1],chars[keys[2]],file.nextBoolean());break;
	    	case 2:print2(keys[1],chars[keys[2]],file.nextBoolean());break;
	    	case 3:print3(keys[1],chars[keys[2]],file.nextBoolean());break;
	    	case 4:print4(keys[1],chars[keys[2]],file.nextBoolean());break;
	    	}
	    	file.nextLine();
	    }
	}
	
	public void print0(int size, char c,boolean fill) { //square
		for(int y=0;y<size;y++) {
			System.out.print(c);
		}
		System.out.println();
		for(int y=2;y<size;y++) {
			System.out.print(c);
			for(int x=2;x<size;x++)
				System.out.print(fill?c:' ');
			System.out.println(c);
		}
		for(int y=0;y<size;y++) {
			System.out.print(c);
		}
		System.out.println();
	}
	public void print1(int size, char c,boolean fill) { //down left
		for(int y=0;y<size;y++) {
			System.out.print(c);
		}
		System.out.println();
		for(int y=1;y<size-1;y++) {
			System.out.print(c);
			for(int x=0;x<size-y-2;x++)
				System.out.print(fill?c:' ');
			System.out.print(c);
			System.out.println();;
		}
		System.out.println(c);
	}
	public void print2(int size, char c,boolean fill) { //down right
		for(int y=0;y<size;y++) {
			System.out.print(c);
		}
		System.out.println();
		for(int y=1;y<size-1;y++) {
			for(int x=0;x<y;x++)
				System.out.print(' ');
			System.out.print(c);
			for(int x=0;x<size-y-2;x++)
				System.out.print(fill?c:' ');
			System.out.print(c);
			System.out.println();
		}
		for(int y=1;y<size;y++)System.out.print(' ');
		System.out.println(c);
	}
	public void print3(int size, char c,boolean fill) { //up left
		System.out.println(c);
		for(int y=1;y<size-1;y++) {
			System.out.print(c);
			for(int x=1;x<y;x++)
				System.out.print(fill?c:' ');
			System.out.print(c);
			System.out.println();
		}
		for(int y=0;y<size;y++) {
			System.out.print(c);
		}
		System.out.println();
	}
	public void print4(int size, char c,boolean fill) { //up right
		for(int y=1;y<size;y++)System.out.print(' ');
		System.out.println(c);
		for(int y=1;y<size-1;y++) {
			for(int x=0;x<size-1-y;x++)
				System.out.print(' ');
			System.out.print(c);
			for(int x=1;x<y;x++)
				System.out.print(fill?c:' ');
			System.out.print(c);
			System.out.println();
		}
		for(int y=0;y<size;y++) {
			System.out.print(c);
		}
		System.out.println();
	}
	  public static void main (String [] args) throws Exception {
	    Sketch a=new Sketch();
	    a.run();
	  }
}