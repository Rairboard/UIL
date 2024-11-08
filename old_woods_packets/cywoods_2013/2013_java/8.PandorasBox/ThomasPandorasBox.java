import java.io.*;
import java.util.*;

class PandorasBox {
	public static void main(String[] args)throws Exception{
		new PandorasBox().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("judges.dat"));
		String line;
		int cur = 1;
		while(!(line=file.nextLine()).equals("0 0 0")){
			String[] temp = line.split(" ");
			int x = Integer.parseInt(temp[0]), y = Integer.parseInt(temp[1]), z = Integer.parseInt(temp[2]);
			int[] buttons = new int[z], dp = new int[10000];
			for(int i = 0; i<z; i++)
				buttons[i] = Integer.parseInt(file.next());
			file.nextLine();
			Arrays.fill(dp,-1);
			dp[x] = 0;
			for(int i = z-1; i>-1; i--){
				boolean changed;
				do{
					changed = false;
					for(int k = x; k<x+10000; k++){
						int j = k%10000;
						if(dp[j]==-1)continue;
						int n = (j+buttons[i])%10000;
						if(dp[n]==-1)dp[n] = dp[j]+1;
						else if(dp[n]>dp[j]+1){
							changed = true;
							dp[n] = dp[j]+1;
						}
					}
				}while(changed);
			}
			System.out.printf("Case %d: %s\n",cur++,(dp[y]==-1?"Cannot be Opened":""+dp[y]));
		}
	}
}