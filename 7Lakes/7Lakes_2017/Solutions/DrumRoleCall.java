import java.util.*;
import java.io.*;

public class DrumRoleCall{
	
	public static int toInt(String s){
		if(s.equals("guitar"))return 0;
		if(s.equals("singer"))return 1;
		if(s.equals("bass"))return 2;
		if(s.equals("triangle"))return 3;
		return -1;
	}
	
	public static long combos(LinkedList<String>[] nm){
		int count=0;
		
		for(int i=0;i<nm[0].size();i++){
			String c1 = nm[0].get(i);
			for(int j=0;j<nm[1].size();j++){
				String c2 = nm[1].get(j);
				if(c2.equals(c1))continue;
				for(int k=0;k<nm[2].size();k++){
					String c3 = nm[2].get(k);
					if(c3.equals(c2)||c3.equals(c1))continue;
					for(int l=0;l<nm[3].size();l++){
						String c4 = nm[3].get(l);
						if(c4.equals(c3)||c4.equals(c2)||c4.equals(c1))continue;
						else count++;
					}
				}
			}
		}
		
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(new File("drum.in"));
		int sets = sc.nextInt();
		for(int set=0;set<sets;set++){
			int n = sc.nextInt();
			sc.nextLine();
			LinkedList<String>[] names = new LinkedList[4];
			for(int i=0;i<names.length;i++){
				names[i] = new LinkedList<String>();
			}
			for(int i=0;i<n;i++){
				String[] in = sc.nextLine().split(" ");
				for(int j=1;j<in.length;j++){
					names[toInt(in[j])].add(in[0]);
				}
			}
			System.out.println(combos(names));
		}
		sc.close();
	}
}