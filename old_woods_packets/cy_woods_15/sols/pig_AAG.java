import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class pig_AAG {

	private char[][]mat;
	int[][]shadow;
	char[][]copy;
	int bmoves;
	
    public void run() throws FileNotFoundException{
    	Scanner file=new Scanner(new File("pig.dat"));
    	int n=file.nextInt();
    	for(int i=0; i<n; i++){
    		int rows=file.nextInt();
    		int cols=file.nextInt();
    		file.nextLine();
    		
    		mat=new char[rows][cols];
    		shadow=new int[rows][cols];
    		copy=new char[rows][cols];
    		bmoves=Integer.MAX_VALUE;
    		
    		int startR=0;
    		int startC=0;
    		
    		for(int r=0; r<rows; r++){
    			String line=file.nextLine();
    			for(int c=0; c<line.length(); c++){
    				mat[r][c]=line.charAt(c);
    				if(mat[r][c]=='D'){
    					startR=r;
    					startC=c;
    				}	
    				shadow[r][c]=Integer.MAX_VALUE;
    			}
    		}
    		
    		recur(startR, startC, 0);
    		
    		if(bmoves<7)
    			System.out.println("BACON");
    		else
    			System.out.println("PIG ON THE RUN");
    	}
    }
    
    public void recur(int r, int c, int steps){
    	if(steps<bmoves && r>=0 && r<mat.length && c>=0 && c<mat[r].length && mat[r][c]!='H'&& mat[r][c]!='*' && steps<shadow[r][c]){
    		if(mat[r][c]=='O'){
    			bmoves = steps;
    			
    			for(int ro=0; ro<mat.length; ro++)
    				for(int co=0; co<mat[ro].length; co++)
    					copy[ro][co]=mat[ro][co];
    			copy[r][c]='*';
    			return;
    		}
    		
    		shadow[r][c]=steps;
    		
    		char save=mat[r][c];
    		
    		mat[r][c]='*';
    		
    		recur(r+1, c, steps+1);
    		recur(r-1, c, steps+1);
    		recur(r, c+1, steps+1);
    		recur(r, c-1, steps+1);
    		
    		mat[r][c]=save;
    	}
    }
    
    public static void main(String[] args) throws FileNotFoundException{
    	new pig_AAG().run();
    }
}