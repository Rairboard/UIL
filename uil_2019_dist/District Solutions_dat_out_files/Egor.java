//UIL District 2019 Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Egor {

	public static void main(String[] args) throws IOException{
		Scanner scr=new Scanner(new File("egor.dat"));
		int n=Integer.parseInt(scr.nextLine());
		ArrayList<String> list=new ArrayList<String>();
		for(int i=1;i<=n;i++) {
			String name=scr.nextLine();
			if(name.length()>=5
			   &&name.length()<=8
			   &&name.matches("[^cmoyCMOY]+")
			   &&!name.matches(".*ph.*")
			   &&name.substring(0,1).matches("[A-M]"))  
					list.add(name);
			}
		Collections.sort(list);
		for(String s:list)
			out.println(s);

	}

}
