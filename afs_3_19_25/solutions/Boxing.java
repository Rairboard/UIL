import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Boxing {
	public static void main(String[] args) throws IOException {
		new Boxing().run();
	}

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Boxing/boxing.dat"));
		PrintWriter out = new PrintWriter(new File("Boxing/boxing.out"));
		
		int n = Integer.parseInt(file.readLine());
		while (n-->0) {
            String line = file.readLine();
            
            StringBuilder triangle = new StringBuilder();
            String[] duplicateRows = new String[line.length() - 1];
			for (int i = 0; i < line.length()-1; i++) {
				triangle.append(line.charAt(i));
				String row = String.format("%s%s%s", triangle.toString(), String.format("%c", line.charAt(i)).repeat((line.length() * 2) - 1 - (2 * triangle.length())), new StringBuilder(triangle).reverse().toString());
				duplicateRows[i] = row;
				out.println(row);
			}
			out.printf("%s%s\n", line, new StringBuilder(line.substring(0, line.length()-1)).reverse().toString());
			for (int i = duplicateRows.length - 1; i >= 0; i--) {
				out.println(duplicateRows[i]);
			}
			out.println("^^^^^");
        }
		
		file.close();
		out.close();
	}
}
