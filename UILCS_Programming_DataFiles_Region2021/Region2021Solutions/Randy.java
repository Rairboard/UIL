/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Randy
{

    public static int getRollScore(char c)
    {
        if (c=='/'||c=='X')
            return 10;
        return Integer.parseInt(String.valueOf(c)); 

    }

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("randy.dat"));
        
        int N = s.nextInt();
        s.nextLine();
        for ( int n = 0; n < N; n++ )
        {
            String input=s.nextLine();
            int[] frames={0,0,0,0,0,0,0,0,0,0};
            int score=0;
            int currentFrame=0;
            int ball=1;
            int prevRollScore=0;
            for(int a=0;a<input.length();a++)
            {
                //if currentFrame>=10 we are done and have already
                //accounted for the extra rolls
                if(currentFrame>9)
                    break;

                char roll=input.charAt(a);
                if(roll=='X')
                {
                    //strike get next two rolls
                    int roll1=getRollScore(input.charAt(a+1));
                    int roll2=getRollScore(input.charAt(a+2));
                    if(input.charAt(a+2)=='/')
                    {
                        //dont count roll one, the spare (value of 10) already accounts for it
                        roll1=0;
                    }
                    frames[currentFrame]=10+roll1+roll2;
                    currentFrame++;
                    ball=1;
                    prevRollScore=0;
                    continue;
                }
                if(roll=='/')
                {
                    //spare get next roll only
                    int roll1=getRollScore(input.charAt(a+1));
                    frames[currentFrame]=10+roll1;
                    currentFrame++;
                    ball=1;
                    continue;
                }

                //acount for non strike or non spare
                //the continues above prevent us from getting here
                //if not warranted
                int rollInt=getRollScore(roll);
                if(ball==1)
                {
                    prevRollScore=rollInt;
                    ball++;
                }
                else
                {
                    frames[currentFrame]=prevRollScore+rollInt;
                    ball=1;
                    prevRollScore=0;
                    currentFrame++;
                }
            }

            for(int a=0;a<10;a++)
            {
                score+=frames[a];
            }
            System.out.println(score);
        }
    }
}