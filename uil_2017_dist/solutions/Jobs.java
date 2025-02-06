import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Jobs {
	public static void main(String[]args)throws Exception{
		new Jobs().run();
	}
	
	public void run()throws Exception{
		Scanner file=new Scanner(new File("jobs.dat"));
		int times=file.nextInt();
		file.nextLine();
		while(times-->0) {
			ArrayList<Job> jobs = new ArrayList<Job>();
			int m = file.nextInt();
			file.nextLine();
			while(m-- > 0) 
				jobs.add(new Job(file.next(), file.nextInt(), file.nextInt(), file.nextInt(), file.nextLine()));
			Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));
		    int n = jobs.size();
		    if (n == 0) 
		        return;
		    int[] maxProfit = new int[n];
		    List<List<Integer>> tasks = new ArrayList<>();
		    for (int i = 0; i < n; i++) 
		        tasks.add(new ArrayList<>());
		    maxProfit[0] = jobs.get(0).profit;
		    tasks.get(0).add(0);
		    for (int i = 1; i < n; i++){
		        int index = ind(jobs, i);
		        int currentProfit = jobs.get(i).profit;
		        if (index != -1) 
		            currentProfit += maxProfit[index];
		        if (maxProfit[i-1] < currentProfit){
		            maxProfit[i] = currentProfit;
		            if (index != -1) 
		                tasks.set(i, new ArrayList<>(tasks.get(index)));
		            tasks.get(i).add(i);
		        }
		        else {
		            tasks.set(i, new ArrayList<>(tasks.get(i-1)));
		            maxProfit[i] = maxProfit[i-1];
		        }
		    }
		    System.out.print("Jobs: ");
		    String f = "";
		    for (int i: tasks.get(n-1)) 
		        f += jobs.get(i) + " ";
		    System.out.println(f.trim());
		    System.out.println("Total Pay: " + maxProfit[n-1]);
		}
	}
	
	public static int ind(List<Job> jobs, int n)
	{
	    int low = 0;
	    int high = n;
	    while (low <= high){
	        int mid = (low + high) / 2;
	        if (jobs.get(mid).finish <= jobs.get(n).start){
	            if (jobs.get(mid + 1).finish <= jobs.get(n).start) 
	                low = mid + 1;
	            else 
	                return mid;
	        }
	        else 
	            high = mid - 1;
	    }
	    return -1;
	}
}
class Job{
	String name;
    int start, finish, profit;
 
    Job(String n, int start, int finish, int profit, String l){
        this.start = start;
        this.finish = finish;
        this.profit = profit;
        name = n;
    }
 
    public String toString() {
        return name;
    }
}
