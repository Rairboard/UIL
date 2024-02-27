/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
public class Seema {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("seema.dat"));
		Map<String,State> list = new HashMap<String,State>();
		f.useDelimiter(",");
		while(f.hasNext())
		{
			String name = f.next();
			if(list.containsKey(name))
				{
				int num = list.get(name).count;
				list.put(name, new State(name,num + 1));
				}
			else
				list.put(name, new State(name,1));
		}
		ArrayList<State> newList = new ArrayList<State>();
		for(String s:list.keySet()) 
			newList.add(new State(list.get(s).name,list.get(s).count));
		Collections.sort(newList);
		for(State st:newList)
			System.out.println(st);
		f.close();

	}
	
	public static class State implements Comparable<State>{
		String name;
		int count;
		public State(String n,int c) {
			name = n;count =c;
		}
		public int compareTo(State state) {
			if(count<state.count)
				return 1;
			else if(count>state.count)
				return -1;
			return name.compareTo(state.name);
		}
		
		public String toString() {
			return name + " " + count;
		}
	}

}
