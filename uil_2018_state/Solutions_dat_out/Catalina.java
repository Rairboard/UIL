//UIL State 2018 - Catalina - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Catalina {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("catalina.dat"));
		while(f.hasNext()){
			String s = f.nextLine();
			String a = "";
			for(int i=0;i<s.length();i++)
				if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
					a+=s.charAt(i);
			out.println(a);
		}
	}
}
