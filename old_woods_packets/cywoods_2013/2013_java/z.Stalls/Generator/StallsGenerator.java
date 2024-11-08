import java.util.*;
import java.io.*;

public class StallsGenerator{
	public static void main(String[] args) throws Exception{
		new StallsGenerator().run();
	}
	public void run() throws Exception{
		PrintWriter out = new PrintWriter(new File("stalls.dat"));
		int N = 10;
		int NN = 100000;
		out.println(Math.round(Math.log(NN)/Math.log(N))+1);
		for(int i = N; i<=NN; i*=N){
			int NNN = Math.min(50000, i*3);
			out.println(i + " " + NNN);
			int tot = 10;
			for(int j = 0; j<NNN; j++){
				int A = (int)(Math.random()*(i-1));
				int B = A+(int)(Math.random()*(i-2-A))+1;
				boolean C = Math.random()<0.25;
				if( C)
					tot += B-A+1;
				A++; B++;
				if(C)
					out.println("C " + A + " " + B);
				else
					out.println("I " + A + " " + B + " " + (int)(Math.random()*tot*2));
			}
		}
		out.println(3*NN+ " " + 2*NN);
		int tot = 0;
		for(int i = 0; i<1000; i++){
			int a  = (int)(1+Math.random()*1000),
				b = (int)(3*NN-Math.random()*1000);
			tot += b-a+1;
			out.println("C " + a + " " + b);
		}
		System.out.println(tot);
		for(int i = 0; i<NN*2-1000; i++){
			int a  = (int)(1+Math.random()*1000),
				b = (int)(3*NN-Math.random()*1000);
			out.println("I " + a + " " + b + " "+(int)(Math.random()*2*tot));
		}
		out.close();
	}
}