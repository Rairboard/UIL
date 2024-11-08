import java.io.*;
import java.util.*;

public class Cows {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("cows.dat"));
		int K = Integer.parseInt(in.nextLine().trim());
		Cow[] cows = new Cow[K];
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.nextLine().trim());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int N = Integer.parseInt(in.nextLine().trim());
		while(N-- > 0) {
			st = new StringTokenizer(in.nextLine().trim());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int q2 = query(cows, A, B);
			int q = queryBetter(cows, A, B);
			if (q != q2) System.out.println("KJLHDSFKHFDSKLHDS");
			System.out.println(q);
		}
	}
	static class Cow {
		int start;
		int interval;
		Cow (int s, int i) {
			this.start = s;
			this.interval = i;
		}
	}

	// naive version: each iteration O(k) time
	static int query(Cow[] cows, int start, int end) {
		ArrayList<Cow> list = new ArrayList<Cow>();
		for (int i = 0; i < cows.length; i++) {
			Cow c = new Cow(cows[i].start, cows[i].interval);
			while (c.start < start) c.start += c.interval;
			list.add(c);
		}
		int count = 0;
		while (true) {
			int min = Integer.MAX_VALUE;
			int minindex = -1;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).start < min) {
					min = list.get(i).start;
					minindex = i;
				}
			}
			if (min > end || minindex == -1) break;
			// make this cow moo
			count++;
			list.get(minindex).start += list.get(minindex).interval;
		}
		return count;
	}

	// faster version using min-heap, each iteration O(log(k)) time
	static int queryBetter(Cow[] cows, int start, int end) {
		PriorityQueue<Cow> pq = new PriorityQueue<Cow>(cows.length, new Comparator<Cow>() {
			@Override
			public int compare(Cow a, Cow b) {
				return a.start - b.start;
			}
		});
		for (int i = 0; i < cows.length; i++) {
			Cow c = new Cow(cows[i].start, cows[i].interval);
			while (c.start < start) c.start += c.interval;
			pq.offer(c);
		}
		int count = 0;
		while (true) {
			Cow c = pq.poll();
			if (c.start > end) break;
			// make this cow moo
			count++;
			c.start += c.interval;
			pq.offer(c);
		}
		return count;
	}
}
