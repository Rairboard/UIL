import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class LastLevel{

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{

                Scanner sc = new Scanner(new File("lastlevel.dat"));

                int t = sc.nextInt();

                sc.nextLine();

                for(int tt=0;tt<t;tt++)
                {
                                int n = sc.nextInt();

                                int[] deg = new int[n];

                                sc.nextLine();

                                for(int i=0;i<n-1;i++)
                                {
                                        int x = sc.nextInt();
                                        int y = sc.nextInt();
                                        sc.nextLine();
                                        x--;
                                        y--;
                                        deg[x] += 1;
                                }


                                for(int i=0;i<n;i++)
                                        if(deg[i] == 0)
                                {
                                            System.out.print(i + 1);
                                            System.out.print(" ");
                                }

                                System.out.print("\n");
                }

	}
}
