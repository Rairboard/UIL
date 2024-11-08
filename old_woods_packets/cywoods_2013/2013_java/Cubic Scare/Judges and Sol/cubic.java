//Bryan Veit
import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class cubic
{
	

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("cubic.dat"));
		int sets = file.nextInt(); file.nextLine();
		
		for(int i=0;i<sets;i++){
			int a = file.nextInt();
			int b = file.nextInt();
			int c = file.nextInt();
			int d = file.nextInt(); file.nextLine();
			
			String ans = "";
			
			for(int x=-100;x<=100;x++){
				if((a*(x*x*x) + b*(x*x) + c*(x) + d) == 0){
					ans += "" + x + " ";
				}
			}
			
			System.out.println(ans);	
				
			}
		}
		

	public static void main(String[] args)throws Exception
	{
		cubic a=new cubic();
		a.run();
	}
}