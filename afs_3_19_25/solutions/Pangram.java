import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class Pangram {
	public static void main(String[] args) throws IOException {
		new Pangram().run();
	}

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Pangram/pangram.dat"));
		PrintWriter out = new PrintWriter(new File("Pangram/pangram.out"));
		
		int n = Integer.parseInt(file.readLine());
		while (n-->0) {
			String alphabet = file.readLine();
			String sentence = file.readLine();
			HashSet<Character> sentenceSet = new HashSet<Character>();
			HashSet<Character> remaining = new HashSet<Character>();
			HashSet<Character> alphabetSet = new HashSet<Character>();
			for(char c : alphabet.toCharArray()) {
				remaining.add(c);
				alphabetSet.add(c);
			}
			
			boolean isPerfectPangram = true;
			for (char c : sentence.toCharArray()) {
				if (!sentenceSet.contains(c)) {
					sentenceSet.add(c);
					remaining.remove(c);
				} else if(alphabetSet.contains(c)){
					isPerfectPangram = false;
				}
			}
			
			out.println(isPerfectPangram ? "perfect pangram" : remaining.isEmpty() ? "pangram" : "neither");
		}
		
		file.close();
		out.close();
	}
}
