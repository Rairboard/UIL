import java.util.*;
import java.io.*;

public class Stalls{
	public static void main(String[] args) throws Exception{
		new Stalls().run();
	}
	int t1[], t2[], n;
	void u(int[] t, int x, int dx){
		for(x=x==0?1:x; x<=n; x+=x&-x) t[x]+=dx;
	}
	int r(int[] t, int x){
		int s = 0;
		for(; x>0; x-=x&-x) s += t[x];
		return s;
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("stalls.dat"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			n = file.nextInt()+1;
			int c = file.nextInt();
			t1 = new int[n+1];
            t2 = new int[n+1];
            int sum = 0;
			for(int i = 0; i<c; i++){
				String cmd = file.next();
                int a = file.nextInt(), b = file.nextInt();
				if(cmd.equals("C")){
					u(t1, a, 1);
					u(t1, b+1, -1);
                    u(t2, a, -a+1);
                    u(t2, b+1, b);
				}else
					sum += r(t1,b)*b+r(t2,b)-r(t1,--a)*a-r(t2,a) <= file.nextInt()?1:0;
			}
            System.out.println(sum);
		}
	}
}