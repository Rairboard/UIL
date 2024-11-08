/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Mahesh
{

	public static int GetBit(int word,int position)
	{
		return (word>>position)&1;
	}

	public static void main (String args[]) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("mahesh.dat"));
        
        int N = s.nextInt();

        for ( int n = 0; n < N; n++ )
        {
        	int word=s.nextInt();
			int bit[]=new int[12];
			int bitCorrect=0;
			int parity1,parity2,parity4,parity8;

			for(int i=1;i<12;i++)
			{
				bit[i]=GetBit(word,Math.abs(i-11));
			}
			parity1=(bit[3]+bit[5]+bit[7]+bit[9]+bit[11])%2;
			parity2=(bit[3]+bit[6]+bit[7]+bit[10]+bit[11])%2;
			parity4=(bit[5]+bit[6]+bit[7])%2;
			parity8=(bit[9]+bit[10]+bit[11])%2;
			
			if(bit[1]!=parity1)
				bitCorrect+=1;
			if(bit[2]!=parity2)
				bitCorrect+=2;
			if(bit[4]!=parity4)
				bitCorrect+=4;
			if(bit[8]!=parity8)
				bitCorrect+=8;

			if(bitCorrect!=0)
				bit[bitCorrect]=bit[bitCorrect]^1;

			System.out.print((char)(bit[3]*Math.pow(2,6)+bit[5]*Math.pow(2,5)+bit[6]*Math.pow(2,4)+bit[7]*Math.pow(2,3)+bit[9]*Math.pow(2,2)+bit[10]*Math.pow(2,1)+bit[11]*Math.pow(2,0)));
		}
		System.out.println();
	}
}