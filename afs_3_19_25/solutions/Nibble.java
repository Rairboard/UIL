import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Nibble {
	public static void main(String[] args) throws IOException {
		new Nibble().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Nibble/nibble.dat"));
		PrintWriter out = new PrintWriter(new File("Nibble/nibble.out"));
		
		int n = Integer.parseInt(file.readLine());
		while (n-->0) {
			String line = file.readLine();
			if(!line.matches("[01]*")) {
				out.println("Wrong Base...");
				continue;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < line.length()/4; i++) {
				String nibble = line.substring(i*4, (i + 1)*4);
				sb.append(String.format("%s ", nibble));
			}
			if (line.length() % 4 != 0) {
				sb.append(String.format("%s%s", line.substring(line.length() - line.length() % 4), "0".repeat(4 - line.length() % 4))); 
			}
			out.println(sb.toString().trim());
		}
		
		file.close();
		out.close();
	}
}
