//UIL State 2018 - Leonardo - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Leonardo {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("leonardo.dat"));
		while(f.hasNext()){
			String s = f.nextLine();
			args = s.split(" ");
			boolean firstDone = false;
			for(int x=0;x<args.length;x++)
				if(args[x].charAt(0)=='=')
				{
					out.print(" = ");firstDone=true;
				}
				else
					if(!firstDone)
						out.print(args[x].charAt(0));
					else
						out.print(args[x].substring(args[x].length()-1).toUpperCase());
			out.println();
		}
	}
}
