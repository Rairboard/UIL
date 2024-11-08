/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Willie
{
    public static boolean allRowsGood(char[][] board)
    {
        int queenCount=0;
        for(int x=0;x<board.length;x++)
        {
            queenCount=0;
            for(int y=0;y<board[x].length;y++)
            {
                if(board[x][y]=='Q')
                    queenCount++;
            }
            if(queenCount>1)
                return false;
        }
        return true;
    }

    public static boolean allColsGood(char[][] board)
        {
            int queenCount=0;
            for(int x=0;x<board.length;x++)
            {
                queenCount=0;
                for(int y=0;y<board[x].length;y++)
                {
                    if(board[y][x]=='Q')
                        queenCount++;
                }
                if(queenCount>1)
                    return false;
            }
            return true;
        }
    public static boolean allDiagonalsGood(char[][] board)
    {
        for(int x=0;x<board.length;x++)
        {
            int queenCount=0;
            int tempX=x,tempY=0;
            for(int y=0;y<board.length;y++)
            {
                if(tempX>=0&&tempX<=board.length&&tempY>=0&&tempY<=board.length)
                {
                    if(board[tempX][tempY]=='Q')
                       queenCount++;
                }
                tempX--;
                tempY++;
            }
            if(queenCount>1)
                return false;
        }

        for(int x=0;x<board.length;x++)
        {
            int queenCount=0;
            int tempX=x,tempY=board.length-1;
            for(int y=0;y<board.length;y++)
            {
                if(tempX>=0&&tempX<=board.length&&tempY>=0&&tempY<=board.length)
                {
                    if(board[tempX][tempY]=='Q')
                        queenCount++;
                }
                tempX--;
                tempY--;
            }
            if(queenCount>1)
                return false;
        }
        return true;
    }

    public static boolean isValid(char[][] board)
    {
        return allRowsGood(board)&&allColsGood(board)&&allDiagonalsGood(board);
    }

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("willie.dat"));
        
        int N = s.nextInt();
        s.nextLine();
        for ( int n = 0; n < N; n++ )
        {
           int dimension=s.nextInt();
           s.nextLine();
           s.nextLine();//top border
           char[][] board=new char[dimension][dimension];
           int numQueens=0;
           for(int x=0;x<dimension;x++)
           {
                String line=s.nextLine();
                line=line.replaceAll("   "," ");
                line=line.replaceAll(" Q ","Q");
                for(int a=1,y=0;a<line.length()-1;a+=2,y++)
                {
                    board[x][y]=line.charAt(a);
                    if(line.charAt(a)=='Q')
                        numQueens++;
                }
                s.nextLine();//bottom border
           }
           
           s.nextLine();//asterisks
           if(isValid(board)&&numQueens==dimension)
           {
                System.out.println("valid solution");
           }
           else
                System.out.println("incorrect attempt");
           
        }
    }
}
