import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;

public class Accounting {
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("accounting.dat"));
		double balance = 0;
		out.println("****.****.****.****.****.****.****.****.");
		out.printf("%7s%s\n","","Transaction : Balance");
		while(f.hasNext()) 
		{
			double num=0;
			String S = f.nextLine();
			args = S.split("[($)]");
			String s="";
			if(args.length==3)
				s = "-"+args[2];
			else
				s=args[1];
			int i = s.indexOf((","));
			//strip out commas
			if(i>=0)
			{
				String ss = "";
				for(int x=0;x<s.length();x++)
					if(s.charAt(x)!=',')
						ss+=s.charAt(x);
				s=ss;
			}	
			num = Double.parseDouble(s);
			balance+=num;
			String bal = String.format("$%(,.2f",balance);
			out.printf("%18s : %s\n",S,bal);
			
			
		}
		out.println("****.****.****.****.****.****.****.****.");
	}
}

/*
Student Input
$250.34
$(500.19)
$2,343,555.55
$(59,216.99)

Student Output
****.****.****.****.****.****.****.****.
       Transaction : Balance
           $250.34 : $250.34
         $(500.19) : $(249.85)
     $2,343,555.55 : $2,343,305.70
      $(59,216.99) : $2,284,088.71
****.****.****.****.****.****.****.****.

Test Input
$250.34
$(500.19)
$2,343,555.55
$(59,216.99)
$1,531.42
$(489,123,738.33)
$999,999,999.99

Test Output
****.****.****.****.****.****.****.****.
       Transaction : Balance
           $250.34 : $250.34
         $(500.19) : $(249.85)
     $2,343,555.55 : $2,343,305.70
      $(59,216.99) : $2,284,088.71
         $1,531.42 : $2,285,620.13
 $(489,123,738.33) : $(486,838,118.20)
   $999,999,999.99 : $513,161,881.79
****.****.****.****.****.****.****.****.

*/