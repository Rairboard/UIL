import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Ordering {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Ordering().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("ordering.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
			String[] arr = file.nextLine().trim().toUpperCase().split("\\s+");
			String[] sort = new String[arr.length];
			int minSwaps = 0;
			System.arraycopy(arr, 0, sort, 0, arr.length);
			Arrays.sort(sort);
			for(int i = 0; i < arr.length; i++)
				hm.put(arr[i], i);
			for(int i = 0; i < arr.length; i++) {
				if(!arr[i].equals(sort[i])) {
					minSwaps++;
					String tmp = arr[i];
					swap(arr, i, hm.get(sort[i]));
					hm.put(tmp, hm.get(sort[i]));
					hm.put(sort[i], i);
				}
			}
			System.out.println(minSwaps);
		}
	}
	
	public void swap(String[] arr, int i, int j) {
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}                                                                                                                                  
