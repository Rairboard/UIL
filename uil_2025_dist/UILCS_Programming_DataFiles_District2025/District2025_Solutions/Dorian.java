/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dorian {
	public static void main(String[] args) throws IOException {
		new Dorian().run();
	}

	private void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("dorian.dat"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		solve(file, out);

		file.close();
		out.close();
	}

	public void solve(BufferedReader file, PrintWriter out) throws IOException {
		String line;
		while((line = file.readLine()) != null) {
			formatLine(out, line);
		}
	}
	
	private static final int LINE_LENGTH = 89;
	
	private static final Pattern CONTIGUOUS_WHITESPACE = Pattern.compile("\\s+");

	private void formatLine(PrintWriter out, String line) {
		StringTokenizer words = new StringTokenizer(line);
		Matcher whitespace = CONTIGUOUS_WHITESPACE.matcher(line);
		
		StringBuilder sb = new StringBuilder();
		while(whitespace.find()) {
			String nextWord = words.nextToken();
			String nextWhitespace = whitespace.group();
			
			if(sb.length() + nextWord.length() <= LINE_LENGTH) {
				// Word is safe to append
				sb.append(nextWord);
				// Append whitespace as needed
				appendWhitespace(out, sb, nextWhitespace);
			} else {
				// There is trailing whitespace to remove
				out.println(sb.toString().replaceAll("\\s+$", ""));
				sb.setLength(0);
				// All other lines begin with a "tab"
				sb.append("      ");
				sb.append(nextWord);
				
				// Append whitespace as needed
				appendWhitespace(out, sb, nextWhitespace);
			}
		}
		
		// Process the last word
		String nextWord = words.nextToken();
		if(sb.length() + nextWord.length() <= LINE_LENGTH) {
			// Word is safe to append
			sb.append(nextWord);
		} else {
			// There is trailing whitespace to remove
			out.println(sb.toString().replaceAll("\\s+$", ""));
			sb.setLength(0);
			// All other lines begin with a "tab"
			sb.append("      ");
			sb.append(nextWord);
		}
		out.println(sb.toString());
	}
	
	private void appendWhitespace(PrintWriter out, StringBuilder sb, String whitespace) {
		if(sb.length() + whitespace.length() <= LINE_LENGTH) {
			sb.append(whitespace);
		} else {
			// No trailing whitespace to remove
			out.println(sb.toString());
			sb.setLength(0);
			// All other lines begin with a "tab"
			sb.append("      ");
		}
	}
}