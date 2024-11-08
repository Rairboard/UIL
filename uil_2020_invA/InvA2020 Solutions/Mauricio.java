/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Mauricio
{
    static void printPath(int rows, int cols)
    {
        int [][] field=new int[rows][cols];
        int count=1;
        int numCells=rows*cols;
        int colWidth=0;
        while(numCells>0)
        {
            colWidth++;
            numCells/=10;
        }
        colWidth++;//account for one space between
        //System.out.println(colWidth);
        if(rows<cols)
        {
            for(int x=0;x<rows;x++)
            {
                if(x%2==0)
                {
                    for(int y=0;y<cols;y++)
                    {
                        field[x][y]=count;
                        count++;
                    } 
                }
                else
                {
                     for(int y=cols-1;y>=0;y--)
                    {
                        field[x][y]=count;
                        count++;
                    }
                }
            }
            
        }
        else
        {
            for(int y=0;y<cols;y++)
            {
                if(y%2==0)
                {
                    for(int x=0;x<rows;x++)
                    {
                        field[x][y]=count;
                        count++;
                    } 
                }
                else
                {
                     for(int x=rows-1;x>=0;x--)
                    {
                        field[x][y]=count;
                        count++;
                    }
                }
            }
            
        }
        //print field
            for(int x=0;x<rows;x++)
            {
                for(int y=0;y<cols;y++)
                {
                    System.out.printf("%" + colWidth + "s",field[x][y]);
                }
                System.out.println();
            }
            //System.out.println();
    }

     public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("mauricio.dat"));
        int N = s.nextInt();
        for ( int n = 1; n <= N; n++ )
        {
            int rows = s.nextInt();
            int cols = s.nextInt();
            printPath(rows,cols);
            System.out.println("==========");
        }
        s.close();
    }
}