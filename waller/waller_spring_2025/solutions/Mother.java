import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Mother {
	public static void main(String[]args)throws Exception{
		new Mother().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("mother.dat"));
		long s = 0, amm = 0, imm1 = 1, imm2 = 0, imm3 = 0;
		long[] arr = new long[1000001];
		for(int y = 1; y <= 1000000 && s >= 0; y++) {
			long imm0 = 1;
			s += amm;
			amm += imm3;
			imm3 = imm2;
			imm0 += imm2;
			imm2 = imm1;
			imm1 = imm0;
			arr[y] = s;
		}
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			System.out.println(arr[file.nextInt()]);
		}
	}
}
