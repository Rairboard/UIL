//Solution - UIL Region 2019
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.BigDecimal;
public class Nishi {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("nishi.dat"));
		int n=Integer.parseInt(f.nextLine());
		for(int p=1;p<=n;p++) {
			String a=f.next();
			String operator=f.next();
			String b=f.next();
			int sigdigs=Math.min(numsigdigs(a), numsigdigs(b));//Find the least number of significant digits.
			double answer;
			if(operator.equals("X"))//Determine whether to multiply or divide
				answer=Double.parseDouble(a)*Double.parseDouble(b);
			else
				answer=Double.parseDouble(a)/Double.parseDouble(b);
			//Round the answer to the correct number of significant digits.
			//Use BigDecimal to avoid scientific notation.
			out.println(rounded(answer,sigdigs));
			//new BigDecimal(answer).toPlainString()
		}
	}
	
	public static int numsigdigs(String s) {
		int sigdigs=0;
		int sigzeroes=0;
		boolean pastdecimal=false;
		if(s.charAt(0)=='-')s=s.substring(1);//Ignore a negative sign.
		for(int i=0;i<s.length();i++)//For each digit.  
			if(s.charAt(i)=='.')//Determine if we are past the decimal place and don't count anything.
				pastdecimal=true;
			else if(s.charAt(i)!='0')//If this digit is not zero.
				{
				sigdigs++;
				sigdigs+=sigzeroes;//Add any zeroes that are significant digits.
				sigzeroes=0;//Reset the number of zeroes.
				}
			else if(sigdigs>=1)//Count the zeroes we have encountered so far IF they are significant.
				sigzeroes++;
		if(pastdecimal)//Any zero to the right of the decimal is a significant digit.
			sigdigs+=sigzeroes;
		return sigdigs;
	}
	
	public static String rounded(double d,int sigdigs) {
			boolean negative=false;
			if(d<0) {
				d=-d;
				negative=true;
			}
			int digitsleftofdecimal;
			double tempd=d;
			for(digitsleftofdecimal=0;tempd>=1;digitsleftofdecimal++) 
				tempd/=10;
			int zeroesrightofdecimal=0;
			if(d<1)
				for(zeroesrightofdecimal=0;tempd<1;zeroesrightofdecimal++)
					tempd*=10;
			tempd=d;
			int shift=tempd>1?sigdigs-digitsleftofdecimal:sigdigs+zeroesrightofdecimal-1;
			tempd=tempd*Math.pow(10, shift);
			tempd=Math.round(tempd);
			tempd=tempd/Math.pow(10, shift);
			String s=BigDecimal.valueOf(tempd).toPlainString();
			String scinot="";
			int count=0;
			if(negative) scinot+='-';
			if(tempd<1) {
				int firstnonzerodig=0;
				for(int m=0;m<s.length();m++)
					if(s.charAt(m)>'0'&&s.charAt(m)<='9') {
						firstnonzerodig=m;
						break;
					}
				s=s.substring(firstnonzerodig);
			}
			else
				if(s.indexOf(".")>0)
					s=s.substring(0, s.indexOf("."))+s.substring(s.indexOf(".")+1);
			if(sigdigs==1)
				scinot+=s.charAt(count++);
			else
				scinot+=s.charAt(count++)+".";
			for(int x=count;x<sigdigs;x++)
				scinot+=s.substring(x, x+1);
			if(tempd>=1)
				scinot+="E"+(digitsleftofdecimal-1);
			else
				scinot+="E"+(-zeroesrightofdecimal);
			return scinot;
	}
	
	
}
