import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Ladder {
	private class Word {
		private char[] letters;
		private int hashCode;
		private boolean computedHash;
		
		public Word(String w) {
			letters = w.toCharArray();
		}
		
		public HashSet<Word> connections() {
			HashSet<Word> connections = new HashSet<Word>();
			for(int i = 0; i < letters.length; i++) {
				char original = letters[i];
				for(char c = 'A'; c <= 'Z'; c++) {
					if(c == original) {
						continue;
					}
					letters[i] = c;
					connections.add(new Word(new String(letters)));
				}
				letters[i] = original;
			}
			return connections;
		}
		
		@Override
		public int hashCode() {
			if(computedHash) {
				return hashCode;
			}
			
			hashCode = Arrays.hashCode(letters);
			computedHash = true;
			return hashCode;
		}
		
		@Override
		public boolean equals(Object other) {
			Word o = (Word) other;
			for(int i = 0; i < letters.length; i++) {
				if(letters[i] != o.letters[i]) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public String toString() {
			return String.valueOf(letters);
		}
	}
	
	private class Query {
		public Word w;
		public int d;
		
		public Query(Word w, int d) {
			this.w = w;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Ladder().run();
	}
	
	private HashMap<Word, HashSet<Word>> graph;
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Ladder/ladder.dat"));
		PrintWriter out = new PrintWriter(new File("Ladder/ladder.out"));
		
		StringTokenizer st = new StringTokenizer(file.readLine());
		st.nextToken();
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<Word> words = Arrays.asList(file.readLine().split(" ")).stream().map(str -> new Word(str)).collect(Collectors.toCollection(HashSet<Word>::new));
		graph = new HashMap<Word, HashSet<Word>>();
		for(Word w : words) {
			HashSet<Word> neighbors = w.connections();
			neighbors.retainAll(words);
			graph.put(w, neighbors);
 		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(file.readLine());
			Word w1 = new Word(st.nextToken());
			Word w2 = new Word(st.nextToken());
			int[] ans = solve(new HashSet<Word>(words), w1, w2);
			if(ans[0] == -1) {
				out.println("Not Connected.");
			} else {
				out.printf("%d %d\n", ans[0], ans[1]);
			}
		}
		file.close();
		out.close();
	}
	
	public int[] solve(HashSet<Word> validWords, Word start, Word end) {
		Queue<Query> toSearch = new LinkedList<Query>();
		toSearch.offer(new Query(start, 1));
		int[] ans = new int[2];
		ans[0] = -1;
		
		boolean found = false;
		HashSet<Word> visited = new HashSet<Word>();
		validWords.remove(start);
		while(!toSearch.isEmpty()) {
			int numAtCurrDepth = toSearch.size();
			int currDepth = toSearch.peek().d;
			for(int i = 0; i < numAtCurrDepth; i++) {
				Query curr = toSearch.poll();
				Word w = curr.w;
				for(Word neighbor : graph.get(w)) {
					if(!validWords.contains(neighbor)) {
						continue;
					}
					
					if(neighbor.equals(end)) {
						if(!found) {
							found = true;
							ans[0] = currDepth+1;
						} 
						ans[1]++;
						continue;
					}
					
					if(!found) {
						visited.add(neighbor);
						toSearch.offer(new Query(neighbor, currDepth+1));
					}
				}
			}
			
			if(found) {
				break;
			}
			
			validWords.removeAll(visited);
			visited.clear();
		}
		
		return ans;
	}
}
