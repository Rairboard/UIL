//UIL District 2019 Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;

public class Sarah {

	public static void main(String[] args) throws IOException{
			Scanner scr=new Scanner(new File("sarah.dat"));
			while(scr.hasNext()) {
				String original=scr.next();
				String temp=original;
				for(int i=0;i<temp.length();i++) {
					char c=temp.charAt(i);
					if((i==0)&&(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')) 
						temp=swap(temp,i,i+1);
					else if((i==temp.length()-1)&&(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'))
						temp=swap(temp,0,i);
					else if((c=='a'||c=='e'||c=='i'||c=='o'||c=='u'))
						temp=swap(temp,i-1,i+1);
					}
				out.println(original+" "+temp);
			}
	}
	
	public static String swap(String temp,int front,int back) {
		char[] c=temp.toCharArray();
		char x=c[front];
		c[front]=c[back];
		c[back]=x;
		String str="";
		for(char chr:c)
			str+=chr;
		return str;
	}

}
