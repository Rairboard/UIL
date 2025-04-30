import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Plagiarism {
	public static void main(String[] args) throws IOException {
		new Plagiarism().run();
	}

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Plagiarism/plagiarism.dat"));
		PrintWriter out = new PrintWriter(new File("Plagiarism/plagiarism.out"));

		int n = Integer.parseInt(file.readLine());
		while(n-->0) {
			char[] A = file.readLine().toCharArray();
			char[] B = file.readLine().toCharArray();
			double same = lcs(A, B);
			double score = (same / (double) A.length) * 100;
			String desc = (score < 10) ? "No significant plagiarism detected" :
				(score < 33) ? "Minimal plagiarism detected" :
					(score < 67) ? "Considerable plagiarism detected" : "Texts are nearly identical or identical";
			out.printf("%s: %.5f%%\n", desc, score);
		}
		
		file.close();
		out.close();
	}
	
	public int lcs(char[] text1, char[] text2) {
		int n = text1.length;
		int m = text2.length;
		
		int[] prev = new int[m+1];
		int[] curr = new int[m+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				curr[j] = (text1[i-1] == text2[j-1]) ? (1 + prev[j-1]) : Math.max(curr[j - 1], prev[j]);
			}
			prev = Arrays.copyOf(curr, m + 1);
		}
		
		return curr[m];
	}
}
