import static java.lang.System.out;
public class Regina {

	public static void main(String[] args) {
		for(int r = 1; r <= 15; r++) {
			for(int x = 1; x <= 20; x++)
				out.print("B");
			for(int x = 1; x <= 20; x++)
				out.print("W");
			for(int x = 1; x <= 20; x++)
				out.print("R");
			out.println();
		}
	}
}
