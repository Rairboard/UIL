//UIL 2018 - Region - Ariana
import static java.lang.System.*;
public class Ariana{
	public static void main(String [] args) 
	{ 
		String s = "i must not tell lies.";
		args = s.split(" ");
		int N=5;
		int n=1;
		while(N-->0)
		{
			for(int x=0;x<args.length;x++)
			{
				args[x]=args[x].toUpperCase();
				out.printf("%-2d ",n++);
				for(int i=0;i<args.length;i++)
					out.print(args[i]+" ");
				args[x]=args[x].toLowerCase();
				out.println();
			}
			for(int x=args.length-2;x>0;x--)
			{
				args[x]=args[x].toUpperCase();
				out.printf("%-2d ",n++);
				for(int i=0;i<args.length;i++)
					out.print(args[i]+" ");
				args[x]=args[x].toLowerCase();
				out.println();
			}
		}
	}
}