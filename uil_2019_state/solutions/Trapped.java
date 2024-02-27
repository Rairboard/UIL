import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


public class Trapped
{
	
	public static String[][] maze;
	public static boolean escape = false;
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("trapped.dat"));
		
		int reps = file.nextInt();
		int sr = 0;
		int sc = 0;
		
		for(int q = 0; q < reps; q++) {
			
			int size = file.nextInt();
			maze= new String[size][size];
			escape=false;
			
			for(int b = 0; b < size; b++) {
				String chars = file.next();
					for(int c = 0; c< size; c++) {
						maze[b][c]=chars.substring(c,c+1);
					}
			}
			
			for(int b = 0; b < size; b++) {
				for(int c = 0; c < size;c++) {
					if(maze[b][c].equals("@")) {
						sr=b;
						sc=c;
					}
				}
			}
			
			possible(sr,sc);
			
			if(escape) {
				System.out.println("Exit");
			}
			else {
				System.out.println("No Exit");
			}
		}
		
	}

	public static void main(String[] args)throws Exception
	{
		Trapped a=new Trapped();
		a.run();
	}
	
	public static void possible(int r, int c) {
		
		if(r<maze.length && c<maze.length) {
			
			if(r==0||c==0||r==maze.length-1||c==maze.length-1) {
				escape=true;
			}
			else {
				if(maze[r][c-1].equals(".")) {
					maze[r][c]="*";
					possible(r,c-1);
				}
				if(maze[r][c+1].equals(".")) {
					maze[r][c]="*";
					possible(r,c+1);
					}
				if(maze[r+1][c].equals(".")) {
					maze[r][c]="*";
					possible(r+1,c);
					}
				if(maze[r-1][c].equals(".")) {
					maze[r][c]="*";
					possible(r-1,c);
					}
			}
			
		}
		
		
	}

}