import java.util.*;
import java.io.*;

public class LeagueGenerator{
	public static void main(String[] args) throws Exception{
		new LeagueGenerator().run();
	}
	public void run() throws Exception{
		PrintWriter out = new PrintWriter(new File("league.dat"));
		int[] N = {3, 5, 10, 50, 100, 10, 20, 100};
		int[] M = {5, 5, 10, 10, 10, 1, 2, 2};
        int tot = 10;
        for(int i : M)
            tot += i;
		out.println(tot);
        out.println("3 1 2 0 0 0\n"+
                    "ABC\n"+
                    "AE\n"+
                    "BDE\n"+
                    "5 1 1 3 1 5\n"+
                    "BCD\n"+
                    "ABD\n"+
                    "D\n"+
                    "BD\n"+
                    "A");
		for(int i = 0; i<N.length; i++){
			for(int j = 0; j<M[i]; j++){
                //N[i] = new Scanner(System.in).nextInt();
                System.out.println(i + "-"+ j);
				out.print(N[i]);
                while(true){
                    int[] quota = new int[5]; 
                    for(int k = 0; k<5; k++)
                        quota[k] = (int)Math.round(Math.random()*N[i]/3+0.3);
                    double PROB = 0.1 + 0.5*Math.random();
                    String[] players = new String[N[i]];
                    for(int k = 0; k<N[i]; k++){
                        String s = "";
                        for(char c : "ABCDE".toCharArray())
                            if( Math.random() < PROB )
                                s += c;
                        if( s.length() == 0)
                            s = ""+"ABCDE".charAt((int)(Math.random()*5));
                        players[k] = s;
                    }
                    int sol =solve(N[i], quota, players);
                    int wrong = i<5?solveWrong(N[i], quota, players):solveWrong2(N[i], quota, players);
                    if( sol != wrong){
                        for(int k : quota)
                            out.print(" " + k);
                        out.println();
                        for(String p : players)
                            out.println(p);
                        out.flush();
                        break;
                    }
                }
			}
		}
        out.println("100 20 19 30 3 1");
        for(int i = 0; i<100; i++)
            out.println("ABCDE");
        for(int i = 0; i<7; i++){
            int NN = 100;
            int[] quota = new int[5];
            for(int k = 0; k<5; k++)
                quota[k] = (int)Math.round(Math.random()*NN/4+0.3);
            double PROB = 0.3 + 0.1*Math.random();
            String[] players = new String[NN];
            for(int k = 0; k<NN; k++){
                String s = "";
                for(char c : "ABCDE".toCharArray())
                    if( Math.random() < PROB )
                        s += c;
                if( s.length() == 0)
                    s = ""+"ABCDE".charAt((int)(Math.random()*5));
                players[k] = s;
            }
            out.print(NN);
            for(int k : quota)
                out.print(" " + k);
            out.println();
            for(String p : players)
                out.println(p);
        }
		out.close();
	}
    
    public int solveWrong(int num, int[] quota, String[] players){
        String[] p = Arrays.copyOf(players, players.length);
        int[] q = Arrays.copyOf(quota, quota.length);
        
        Arrays.sort(p, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        });
        int ct = 0;
        ArrayList<ArrayList<String> > list = new ArrayList<ArrayList<String> >();
        for(int i = 0; i<5; i++)
            list.add(new ArrayList<String>());
    outer: for(String s : p)
        for(char c : s.toCharArray()){
            int v = c-'A';
            if( q[v] > 0){
                q[v]--;
                list.get(v).add(s);
                ct++;
                break;
            }else{
                for(int i = 0; i<list.get(v).size(); i++){
                    String s2 = list.get(v).get(i);
                    for(char c2: s2.toCharArray()){
                        int v2 = c2-'A';
                        if( q[v2] > 0){
                            q[v2]--;
                            list.get(v2).add(list.get(v).remove(i));
                            list.get(v).add(s);
                            ct++;
                            continue outer;
                        }
                    }
                }
            }
        }
        return ct;
    }
    
    public int solve(int num, int[] quota, String[] players){
        int n = num;
        int M = 5, N = 2+M+n, S = 0, E = N-1, P = 1, R = n+1;
        int[][] m = new int[N][N];
        for(int i = 0; i<M; i++)
            m[R+i][E] = quota[i];
        for(int i = 0; i<n; i++){
            m[S][P+i]++;
            for(char c : players[i].toCharArray())
                m[P+i][R+c-'A']++;
        }
        int f = 0;
        L: while(true){
            boolean[] v = new boolean[N];
            Queue<Object[]> que = new LinkedList<Object[]>();
            que.add(new Object[]{S, null});
            while(!que.isEmpty()){
                Object[] ar = que.remove();
                int c = (Integer)ar[0];
                if( c == E){
                    f++;
                    while(ar[1] != null){
                        ar = (Object[])ar[1];
                        int p = (Integer)ar[0];
                        m[p][c]--;
                        m[c][p]++;
                        c = p;
                    }
                    continue L;
                }
                for(int i = 0; i<N; i++)
                    if( !v[i] && m[c][i] > 0){
                        v[i] = true;
                        que.add(new Object[]{i, ar});
                    }
            }
            break;
        }
        return f;
    }
    
    static ArrayList<String> prec;
    static Comparator<String> comp = new Comparator<String>(){
        public int compare(String a, String b){
            return a.length()-b.length()==0?a.compareTo(b):a.length()-b.length();
        }
    };
    static{

        prec = new ArrayList<String>();
        String alph = "ABCDE";
        permu(new ArrayList<Character>(Arrays.asList('A','B','C','D','E')),"",prec);
    }
    
    public int solveWrong2(int num, int[] quota, String[] players)
	{

        int n = num;
        int[] quotas = Arrays.copyOf(quota, quota.length);
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(players));
        Collections.sort(list,comp);
        int max = 0;
        for(String s:prec)
        {
            max = Math.max(solve(new ArrayList<String>((List)list.clone()),s,quotas,comp),max);
        }
        return max;
	}
	static void permu(ArrayList<Character> l, String curr, ArrayList<String> fin)
	{
		if(l.isEmpty())
			fin.add(curr);
		else
			for(int i = l.size()-1;i>-1;i--)
			{
				char ch = l.remove(i);
				permu(l,curr+ch,fin);
				l.add(i,ch);
			}
	}
	
	public int solve(ArrayList<String> list,final String prec,int[] quotas,Comparator comp)
	{
		Comparator<Character> ca = new Comparator<Character>(){
			public int compare(Character a, Character b)
			{
				return prec.indexOf(a)-prec.indexOf(b);
			}
		};
		for(int i = 0;i<list.size();i++)
		{
			char[] cha = list.get(i).toCharArray();
			ArrayList<Character> chars = new ArrayList<Character>();
			for(char j:cha)
				chars.add(j);
			Collections.sort(chars,ca);
			String s = "";
			for(char ch:chars)
				s+=ch;
			list.set(i,s);
		}
		int[] quo = quotas.clone();
		for(int i = 0;i<5;i++)
		{
			if(quo[i]==0)
			{
				for(int g = 0;g<list.size();g++)
				{
					list.set(g,list.get(g).replaceAll((char)(65+i)+"",""));
				}
			}
		}
		Collections.sort(list,comp);
		int c = 0;
		while(!list.isEmpty())
		{
			String str = list.remove(0);
			if(str.isEmpty())
				continue;
			int f = str.charAt(0)-65;
			quo[f]--;
			c++;
			if(quo[f]==0)
			{
				for(int i = 0;i<list.size();i++)
				{
					list.set(i,list.get(i).replaceAll((char)(65+f)+"",""));
				}
				Collections.sort(list,comp);
			}
		}
		return c;
	}
    
}