//UIL State 2018 - Dennis - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Dennis {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("dennis.dat"));
		int numSets=Integer.parseInt(f.nextLine());
		for(int x=1;x<=numSets;x++) {
			int numWords=Integer.parseInt(f.nextLine());
			//Use a queue to store all of the words in each set.
			Queue<String> words=new LinkedList<String>();
			int maxLength=-1;//Used to store the length of the longest word in each set.
			
			/*
			 * Read the words in each set, determine which one
			 * is the longest, and put each into the queue.
			 */
			
			for(int y=1;y<=numWords;y++) {
				String w=f.nextLine();
				if(w.length()>maxLength)
					maxLength=w.length();
				words.add(w);
				}
			
			/*
			 * Once the length of the longest word is known, create
			 * a 2D array with as many rows as the length of the
			 * longest word and a column for each word.
			 */
			
			char ca[][]=new char[maxLength][numWords];
			
			//Fill the array with blanks.
			
			for(int j=0;j<ca.length;j++)
				for(int k=0;k<numWords;k++)
					ca[j][k]=' ';
			
			for(int col=0;col<numWords;col++) {
				//Get each word in the order they were placed into the queue.
				String curWord=words.remove();
				//Place each character in that word into the appropriate column.
				for(int row=0;row<curWord.length();row++)
					ca[row][col]=curWord.charAt(row);
			}
			//Print the 2D array.
			for(int row=0;row<ca.length;row++) {
				for(int col=0;col<ca[row].length;col++)
					out.print(ca[row][col]);
				out.println();
			}
			//Print the line of astricks.
			for(int line=1;line<=numWords;line++)
				out.print("*");
			out.println();
		}
	}
}
