/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;
public class Ram {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("ram.dat"));
		while(f.hasNext()) {
			Scanner line = new Scanner(f.nextLine());
			while(line.hasNext()) {
				String nextWord = line.next();
				String temp = "";
				char firstLetter = nextWord.charAt(0);
				char lastLetter = nextWord.charAt(nextWord.length()-1);
				if(!Character.isLetterOrDigit(firstLetter) && !Character.isLetterOrDigit(lastLetter)) {
					temp=nextWord.substring(1, nextWord.length()-1);
					temp=reverse(temp);
					nextWord=firstLetter+temp+lastLetter;
					}
				else if(!Character.isLetterOrDigit(firstLetter)){
					temp=nextWord.substring(1);
					temp=reverse(temp);
					nextWord=firstLetter+temp;					
					}
				else if(!Character.isLetterOrDigit(lastLetter)) {
					temp=nextWord.substring(0,nextWord.length()-1);
					temp=reverse(temp);
					nextWord=temp+lastLetter;	
					}
				else
					nextWord=reverse(nextWord);
				out.print(nextWord+" ");						
				}
			out.println();
		}

	}
	
	public static String reverse(String s) {
		String t="";
		for(int i=s.length()-1;i>=0;i--)
			t+=s.charAt(i);
		return t;
	}

}
