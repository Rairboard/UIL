import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Cyphers_BJR
{
	String[][] master;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("cypherjudges.dat"));
		master = new String[27][27];
		for(int row=0;row<master.length;row++)
		{
			for(int col = 0; col<master[row].length;col++)
			{
				master[row][col] = file.next();
			}
		}
		int tests = file.nextInt();
		file.nextLine();
		for(int i=0;i<tests;i++)
		{
			String crypt = file.nextLine();
			String key = file.nextLine();
			String uncrypt = "";
			String ogcrypt =crypt;
			int pos = 0;
			int keyR = 0;
			int keyC = 0;
			while(crypt.length()>0)
			{
				String cryplet = crypt.substring(0,1);
				for(int r = 0; r<master[0].length;r++)
				{
					if(master[r][0].equals(key.substring(pos,pos+1)))
						keyR = r;
				}
				for(int c = 0; c<master[0].length;c++)
				{
					if(master[keyR][c].equals(cryplet))
						keyC = c;
				}
				uncrypt += master[0][keyC];
				if(pos<key.length()-1)
					pos++;
				else
					pos=0;
				crypt = crypt.substring(1);
			}
			out.println(ogcrypt + " decrypted with " + key + " : " + uncrypt);
			out.println(file.nextLine());
		}
	}

	public static void main(String[] args) throws Exception
	{
		new Cyphers_BJR().run();
	}	
	
}