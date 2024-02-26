import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Three {

	ArrayList<Integer> arr;
	
	public static void main(String[] args) throws Exception{
		Three t = new Three();
		t.run();
	}
	
	void run() throws Exception{
		Scanner file = new Scanner(new File("threeJudge.txt"));
		int times = file.nextInt();
		file.nextLine();
		for (int asdf = 0; asdf<times; asdf++){
			arr = new ArrayList<Integer>();
			String line = file.nextLine();
			Scanner nums = new Scanner(line);
			while(nums.hasNext())
				arr.add(nums.nextInt());
			int max = 0;
			for (int x : arr){
				max = Math.max(max, x);
			}
			if (max%2==0)
				System.out.println((max/2));
			else
				System.out.println((max*3+1));
		}
	}

}
