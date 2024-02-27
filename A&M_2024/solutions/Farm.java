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


public class Farm
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("farm.dat"));
		int reps = file.nextInt();
		int nums = file.nextInt();
		
		String[] banned = new String[nums];
		for(int a = 0 ;a<banned.length;a++) {
			banned[a]=file.next();
		}
		
		for(int q=0; q<reps; q++)
		{
			String str = file.next();
			
			boolean ban = false;
			
			for(String a: banned) {
				if(a.equals(str)) {
					ban=true;
				}
			}
			if(!ban) {
			if(str.length()==1) {
				System.out.println(str);
			}
			else if(str.length()<5 && str.length()>1) {
				
				String[][] mat = new String[2][2];
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						mat[x][y]="*";
					}
				}
				
				int place = 0;
				
				for(int a = mat.length-1; a>=0; a--) {
					for(int b = 0; b<mat.length;b++) {
						if(place<str.length()) {
						mat[a][b]=str.substring(place,place+1);
						place++;
						}
					}
				}
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						System.out.print(mat[x][y]);
					}
					System.out.println();
				}
				
				
			}
			else if(str.length()<10 && str.length()>4) {
				
				String[][] mat = new String[3][3];
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						mat[x][y]="*";
					}
				}
				
				int place = 0;
				
				for(int a = mat.length-1; a>=0; a--) {
					for(int b = 0; b<mat.length;b++) {
						if(place<str.length()) {
						mat[a][b]=str.substring(place,place+1);
						place++;
						}
					}
				}
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						System.out.print(mat[x][y]);
					}
					System.out.println();
				}
				
				
			}
			else if(str.length()<17 && str.length()>9) {
				
				String[][] mat = new String[4][4];
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						mat[x][y]="*";
					}
				}
				
				int place = 0;
				
				for(int a = mat.length-1; a>=0; a--) {
					for(int b = 0; b<mat.length;b++) {
						if(place<str.length()) {
						mat[a][b]=str.substring(place,place+1);
						place++;
						}
					}
				}
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						System.out.print(mat[x][y]);
					}
					System.out.println();
				}
				
				
			}
			else if(str.length()<26 && str.length()>16) {
				
				String[][] mat = new String[5][5];
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						mat[x][y]="*";
					}
				}
				
				int place = 0;
				
				for(int a = mat.length-1; a>=0; a--) {
					for(int b = 0; b<mat.length;b++) {
						if(place<str.length()) {
						mat[a][b]=str.substring(place,place+1);
						place++;
						}
					}
				}
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						System.out.print(mat[x][y]);
					}
					System.out.println();
				}
				
				
			}
			else if(str.length()<37 && str.length()>25) {
				
				String[][] mat = new String[6][6];
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						mat[x][y]="*";
					}
				}
				
				int place = 0;
				
				for(int a = mat.length-1; a>=0; a--) {
					for(int b = 0; b<mat.length;b++) {
						if(place<str.length()) {
						mat[a][b]=str.substring(place,place+1);
						place++;
						}
					}
				}
				
				for(int x=0;x<mat.length;x++) {
					for(int y=0;y<mat.length;y++) {
						System.out.print(mat[x][y]);
					}
					System.out.println();
				}
				
				
			}
			}
			else {
				System.out.println("SHIPMENT DISAPPROVED");
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		Farm a=new Farm();
		a.run();
	}

}