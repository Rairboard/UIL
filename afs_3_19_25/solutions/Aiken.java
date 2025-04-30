import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Aiken {
	public static void main(String[] args) throws IOException {
		new Aiken().run();
	}
	
	public void run() throws IOException {
		PrintWriter out = new PrintWriter(new File("Aiken/aiken.out"));
		out.print("""
				 //\\         /\\\\
				|| * \\ . . / * ||
				 \\\\____\\X/____//
				  / *  /O\\  * \\
				  \\__/  "  \\__/
				  """);
		out.close();
	}
}
