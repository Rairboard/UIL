import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Arthur
{
	public static void main(String args[]) throws FileNotFoundException
	{
        Scanner s;
		if(args.length==0)
            s = new Scanner(new File("arthur.dat"));
        else
            s = new Scanner(new File(args[0]));

        int numCases=s.nextInt();
        for(int caseNum=0;caseNum<numCases;caseNum++)
        {
            int[] nums=new int[3];
            nums[0]=s.nextInt();
            nums[1]=s.nextInt();
            nums[2]=s.nextInt();
            Arrays.sort(nums);

            System.out.print(nums[0] + ", " + nums[1] + ", " + nums[2]);
            if((nums[0]*nums[0]+nums[1]*nums[1])==(nums[2]*nums[2]))
                System.out.println(" is a Pythagorean triple.");
            else
                System.out.println(" is not a Pythagorean triple.");
        }

        s.close();
    }
}