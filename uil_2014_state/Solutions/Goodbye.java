import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Goodbye {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{

                Scanner sc = new Scanner(new File("goodbye.dat"));

                int t = sc.nextInt();

                sc.nextLine();

                for(int tt=0;tt<t;tt++)
                {
                            String s = sc.nextLine();

                            int n = s.length();

                            int ans = 0;
                            for(int i=0;(i+6)<n;i++)
                            {
                                        if(s.charAt(i) == 'g' || s.charAt(i) == 'G')
                                        {
                                                if(s.charAt(i+1) == 'o' || s.charAt(i+1) == 'O')
                                                {
                                                        if(s.charAt(i+2) == 'o' || s.charAt(i+2) == 'O')
                                                        {
                                                                if(s.charAt(i+3) == 'd' || s.charAt(i+3) == 'D')
                                                                {
                                                                        if(s.charAt(i+4) == 'b' || s.charAt(i+4) == 'B')
                                                                        {
                                                                                if(s.charAt(i+5) == 'y' || s.charAt(i+5) == 'Y')
                                                                                {
                                                                                        if(s.charAt(i+6) == 'e' || s.charAt(i+6) == 'E')
                                                                                        {
                                                                                                ans++;
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                            }

                            System.out.println(ans);
                }
    }

}
