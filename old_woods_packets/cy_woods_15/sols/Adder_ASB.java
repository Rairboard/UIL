import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Adder {
	
	ArrayList<Integer> nums;

	public static void main(String[] args) throws Exception{
		Adder a = new Adder();
		a.run();
	}
	
	void run() throws Exception{
		Scanner file = new Scanner(new File("adder.dat"));
		int times = file.nextInt();
		file.nextLine();
		for (int asdf = 0; asdf<times; asdf++){
			nums = new ArrayList<Integer>();
			int blocks = file.nextInt();
			file.nextLine();
			for (int i = 0; i<blocks; i++){
				nums.add(file.nextInt());
			}
			int fav = file.nextInt();
			boolean canAdd = recur(0, fav);
			if (canAdd)
				System.out.println("Yes.");
			else
				System.out.println("Not possible.");
			if (file.hasNextLine())
				file.nextLine();
		}
	}
	
	boolean recur(int ind, int f){
		if (ind>=nums.size())
			return false;
		if (recur(ind+1, f-nums.get(ind)))
			return true;
		if (recur(ind+1, f))
			return true;
		if (f==0)
			return true;
		return false;
	}

}
