import java.io.*;
import java.util.*;

public class bagofmarbles_clt
{
	//instance variables go here
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("bag.txt"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			int red=0,blu=0,gre=0,yel=0;
			for(int i=0; i<4; i++)
			{
				String s=file.next();
				if(s.equals("Red"))
				{
					red=file.nextInt();
				}
				else if(s.equals("Blue"))
				{
					blu=file.nextInt();
				}
				else if(s.equals("Green"))
				{
					gre=file.nextInt();
				}
				else
				{
					yel=file.nextInt();
				}
				file.nextLine();
			}
			int tot=red+blu+gre+yel;
			int dra=file.nextInt();
			file.nextLine();
			for(int i=0; i<dra; i++)
			{
				String mar=file.nextLine();
				if(mar.equals("Red"))
				{
					System.out.println(red + "/" + tot);
					red--;
					tot--;
				}
				else if(mar.equals("Blue"))
				{
					System.out.println(blu + "/" + tot);
					blu--;
					tot--;
				}
				else if(mar.equals("Green"))
				{
					System.out.println(gre + "/" + tot);
					gre--;
					tot--;
				}
				else
				{
					System.out.println(yel + "/" + tot);
					yel--;
					tot--;
				}
				if(red<0){red=0;tot++;}
				if(blu<0){blu=0;tot++;}
				if(gre<0){gre=0;tot++;}
				if(yel<0){yel=0;tot++;}
			}
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		bagofmarbles_clt a=new bagofmarbles_clt();
		a.run();
	}	
}