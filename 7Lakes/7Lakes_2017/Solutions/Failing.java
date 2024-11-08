import java.util.*;
import java.io.*;

public class Failing {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("failing.in"));
		int sets = sc.nextInt();
		for (int set = 0; set < sets; set++) {
			String name;
			int grade;
			name = sc.next()+" "+sc.next();
			grade = sc.nextInt();
			if(grade<70)
				System.out.println(name);
		}
		sc.close();
	}
}