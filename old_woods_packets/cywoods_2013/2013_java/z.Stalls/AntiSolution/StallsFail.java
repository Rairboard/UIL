import java.util.*;
import java.io.*;

public class StallsFail{
	public static void main(String[] args) throws Exception{
		new StallsFail().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("stalls.dat"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			int n = file.nextInt(), c = file.nextInt();
			int[] ar = new int[n];
			int sum = 0;
			for(int i = 0; i<c; i++){
				boolean C = file.next().equals("C");
                int a = file.nextInt()-1, b = file.nextInt()-1;
				if(C){
					for(int j = a; j<=b; j++)
						ar[j]++;
				}else{
                    int tot = 0;
                    for(int j = a; j<=b; j++)
                        tot += ar[j];
                    sum+=tot <= file.nextInt()?1:0;
                }
			}
			System.out.println(sum);
		}
	}
}