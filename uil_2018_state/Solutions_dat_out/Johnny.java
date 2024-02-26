//UIL State 2018 - Johnny - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Johnny {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("johnny.dat"));
		Map<String,Character> map = new TreeMap<String,Character>();
		while(f.hasNext()){
			String s = f.nextLine();
//			out.println(s);
			if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(s.charAt(0))>=0)
			{
				args = s.split(" ");
				for(int x=0;x<args.length;x++)
					out.print(map.get(args[x]));
				out.println();
			}
		    else//add word/symbol mapping to map
		    {
		    	args = s.split("[ /]");
		    	char sym = args[0].charAt(0);
		    	for(int x=1;x<args.length;x++)
		    		map.put(args[x],sym);
		    }
//		    out.println(map);
			
		}
	}
}
