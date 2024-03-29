
import java.io.*;
import java.util.*;

class lab {
	int[][]smat;
	char[][]mat;
	boolean found;
	public void run() throws Exception {
		Scanner file=new Scanner(new File("lab.dat"));
	    int num=file.nextInt();
	    file.nextLine();
	    while(num-->0) {
	    	int rr=file.nextInt(),cc=file.nextInt();
	    	file.nextLine();
	    	mat=new char[rr][cc];
	    	smat=new int[rr][cc];
	    	int sr=-1,sc=-1,er=0,ec=0;
	    	for(int r=0;r<rr;r++) {
	    		mat[r]=file.nextLine().trim().toCharArray();
	    		Arrays.fill(smat[r], Integer.MAX_VALUE);
	    		for(int c=0;c<cc;c++) {
	    			if(mat[r][c]=='S') {
	    				sr=r;sc=c;
	    			}
	    			if(mat[r][c]=='E') {
	    				er=r;ec=c;
	    			}
	    		}
	    	}	
	    	solve(sr,sc,0);
	    	System.out.println(smat[er][ec]==Integer.MAX_VALUE?"WELCOME TO THE BORG":"ESCAPED IN "+(smat[er][ec])+" STEPS");
	    }
	}
	public void solve(int r,int c,int s) {
		if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || smat[r][c]<=s || mat[r][c]=='#')return;
		smat[r][c]=s++;
		solve2(r+1,c,s);
		solve2(r-1,c,s);
		solve2(r,c+1,s);
		solve2(r,c-1,s);
	}
	public void solve2(int r,int c,int s) {
		if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || smat[r][c]<=s || mat[r][c]=='.')return;
		smat[r][c]=s++;
		solve3(r+1,c,s);
		solve3(r-1,c,s);
		solve3(r,c+1,s);
		solve3(r,c-1,s);
	}
	public void solve3(int r,int c,int s) {
		if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || smat[r][c]<=s)return;
		smat[r][c]=s++;
		solve(r+1,c,s);
		solve(r-1,c,s);
		solve(r,c+1,s);
		solve(r,c-1,s);
	}
	  public static void main (String [] args) throws Exception {
	    lab a=new lab();
	    a.run();
	  }
}