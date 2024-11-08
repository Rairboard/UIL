import java.io.*;
import java.util.*;

import javafx.util.Pair;

public class SaveSassdom
{
	public static class event implements Comparable<event>
	{
		int id; //1==open, 0==close
		int x;
		Pair<Integer, Integer> y;
		event(int i, int xx, Pair<Integer, Integer> yy)
		{
			id = i;
			x = xx;
			y = yy;
		}
		public int compareTo(event o)
		{
			if (x == o.x&&id==o.id&&y.getKey()==o.y.getKey())
				return y.getValue() - o.y.getValue();
			if (x == o.x&&id==o.id)
				return y.getKey() - o.y.getValue();
			if (x == o.x)
				return o.id-id;
			return x - o.x;
		}
	}

	static int n, t;
	static ArrayList<event> events=new ArrayList<>();

	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("sassdom.in"))));
		StringTokenizer st=new StringTokenizer(br.readLine());
		t=Integer.parseInt((st.nextToken()));
		for(int g=0; g<t; g++)
		{
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt((st.nextToken()));
			for(int i=0; i<n; i++)
			{
				int x1, y1, x2, y2;
				st=new StringTokenizer(br.readLine());
				x1=Integer.parseInt((st.nextToken()));
				y1=Integer.parseInt((st.nextToken()));
				x2=Integer.parseInt((st.nextToken()));
				y2=Integer.parseInt((st.nextToken()));
				events.add(new event(1, x1, new Pair<Integer, Integer>(y2, y1)));
				events.add(new event(0, x2, new Pair<Integer, Integer>(y2, y1)));
			}
			Collections.sort(events);
			TreeMap<Pair<Integer, Integer>, Integer> curev=new TreeMap<>(new Comparator<Pair<Integer, Integer>>(){
				public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2)
				{
					if(o1.getKey().equals(o2.getKey()))
						return o1.getValue().compareTo(o2.getValue());
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			ArrayList<Pair<Integer, Integer>> interv=new ArrayList<>();
			int ans = 0, currange = 0, prevrange = 0, lastx = events.get(0).x, curx = events.get(0).x;
			for (event e : events)
			{
				curx = e.x;
				ans += 2 * interv.size()*(curx - lastx);
				if (e.id == 0)
				{
					curev.put(e.y, curev.get(e.y)-1);
				}
				else
				{
					if(!curev.containsKey(e.y))
						curev.put(e.y, 0);
					curev.put(e.y, curev.get(e.y)+1);
				}
				lastx = curx;
				interv.clear();
				currange = 0;
				for (Pair<Integer, Integer> p : curev.keySet())
				{
					if(curev.get(p)<=0)
						continue;
					if (interv.size() == 0)
					{
						interv.add(p);
					}
					else
					{
						if (interv.get(interv.size()-1).getValue() >= p.getKey())
						{
							interv.set(interv.size()-1,new Pair<Integer, Integer>(interv.get(interv.size()-1).getKey(), (Math.max(interv.get(interv.size()-1).getValue(), p.getValue()))));
						}
						else
						{
							interv.add(p);
						}
					}
				}
				for (Pair<Integer, Integer> p : interv)
				{
					currange += p.getValue() - p.getKey();
				}
				ans += Math.abs(prevrange - currange);
				prevrange = currange;
			}
			System.out.println(ans);
			events.clear();
		}
		br.close();
	}
}
