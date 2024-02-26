import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class SudokuSolver {

    public void run()throws Exception{
    	Scanner file = new Scanner(new File("JudgeSudokuGrids.dat"));
    	int times = file.nextInt();
    	file.nextLine();
    	for(int donotuse = 0;donotuse<times;donotuse++){
    		int cnt=file.nextInt();
    		file.nextLine();
    		int[][] jamesbond=new int [9][9];
    		for(int i=0;i<9;i++)
    		{
    			
    			String[] bob=file.nextLine().split("");
    			for(int j=0;j<9;j++)
    			{
    				jamesbond[i][j]=Integer.parseInt(bob[j+1]);
    			}
    		}
    	/*	for(int i=0;i<9;i++)
    		{
    			for(int j=0;j<9;j++)
    			{
    				System.out.print(jamesbond[i][j]);
    			}
    			System.out.println();
    		}*/
    		//This part of the code works 
    		//System.out.println();
    		for(int r=0;r<cnt;r++)
    		{
    		
    		int x=file.nextInt()-1;
    		int y=file.nextInt()-1;
    		int n=0;
    		int [] vars={1,2,3,4,5,6,7,8,9};
    		boolean z=true;
    		
    		for(int i=0;i<vars.length;i++)
    		{
    			for(int j=0;j<9;j++)
    			{
    				//System.out.print(jamesbond[j][y]);
    				
    				if(vars[i]==jamesbond[x][j])
    				{
    					
    					z=false;
    				//	System.out.println("a");
    				}
    				if(vars[i]==jamesbond[j][y])
    				{
    					z=false;
    				//	System.out.println("a");
    				}
    			}
    		//	System.out.println();
    			//if(vars[i]==jamesbond[x+1][y]||vars[i]==jamesbond[x+1][y+1]||vars[i]==jamesbond[x+1][y-1]||vars[i]==jamesbond[x+1][y])
    			if(x>=0&&x<=2&&y>=0&&y<=2)
    			{
    				for(int q=0;q<3;q++)
    				{
    					for(int w=0;w<3;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    						//	System.out.println("a");
    						}
    					}
    				}
    			}
    			if(x>=0&&x<=2&&y>=3&&y<=5)
    			{
    				for(int q=0;q<3;q++)
    				{
    					for(int w=3;w<6;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    						//	System.out.println("a");
    						}
    					}
    				}
    			}
    			if(x>=0&&x<=2&&y>=6&&y<=8)
    			{
    				for(int q=0;q<3;q++)
    				{
    					for(int w=6;w<9;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    						//	System.out.println("a");
    						}
    					}
    				}
    				
    			}
    			if(x>=3&&x<=5&&y>=0&&y<=2)
    			{
    				for(int q=3;q<6;q++)
    				{
    					for(int w=0;w<3;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    						//	System.out.println("a");
    						}
    					}
    				}
    				
    			}
    			if(x>=3&&x<=5&&y>=3&&y<=5)
    			{
    				for(int q=3;q<6;q++)
    				{
    					for(int w=3;w<6;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    							//System.out.println("a");
    						}
    					}
    				}
    				
    			}
    			if(x>=3&&x<=5&&y>=6&&y<=8)
    			{
    				for(int q=3;q<6;q++)
    				{
    					for(int w=6;w<9;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    							//System.out.println("a");
    						}
    					}
    				}
    			}
    			if(x>=6&&x<=8&&y>=0&&y<=2)
    			{
    				for(int q=6;q<9;q++)
    				{
    					for(int w=0;w<3;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    							//System.out.println("a");
    						}
    					}
    				}
    				
    			}
    			if(x>=6&&x<=8&&y>=3&&y<=5)
    			{
    				for(int q=6;q<9;q++)
    				{
    					for(int w=3;w<6;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    							//System.out.println("a");
    						}
    					}
    				}
    				
    			}
    			if(x>=6&&x<=8&&y>=6&&y<=8)
    			{
    				for(int q=6;q<9;q++)
    				{
    					for(int w=6;w<9;w++)
    					{
    						if(vars[i]==jamesbond[q][w])
    						{
    							z=false;
    							//.out.println("a");
    						}
    					}
    				}
    			}
    			
    			if(z==true)
    			{
    				n=vars[i];
    				break;
    				
    			}
    			z=true;
    			
    			
    			
    		}
    		if(jamesbond[x][y]!=0)
    		{
    			n=jamesbond[x][y];
    		}
    		//jamesbond[x][y]=n;
    		System.out.println(n);
    		}
    		

    	}


    }

    public static void main(String[] args)throws Exception {
    	new SudokuSolver().run();
    }
}
