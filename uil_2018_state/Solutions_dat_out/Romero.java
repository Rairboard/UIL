//UIL State 2018 - Romero - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Romero {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("romero.dat"));
		out.printf("%-19s%-11s%-11s%-6s%-6s%-7s%-9s|\n", "Date","Attendance","Gross","ATP","STP", "Adults", "Stu/Child");
		int numGames=Integer.parseInt(f.nextLine());
		for(int g=1;g<=numGames;g++) {
			String date=f.next();
			double ta=f.nextInt();
			double gr=f.nextDouble();
			double atp=f.nextDouble();
			double stp=f.nextDouble();
			double y=(atp*ta-gr)/(atp-stp);//Multiply the first equation and add the opposite of the second then solve for y.
			double x=ta-y;//Substitute value of y and solve for x.
			out.printf("%-19s%-11.0f$%-,10.2f$%-5.2f$%-5.2f%-7.0f%-9.0f|\n",convertDate(date),ta,gr,atp,stp,x,y);
		}
	}
	
	public static String convertDate(String d) {
		String date="";
		Scanner scr=new Scanner(d);
		scr.useDelimiter("/");
		int month=scr.nextInt();
		switch(month) {
		case 9:date+="September ";break;
		case 10:date+="October ";break;
		case 11:date+="November ";break;
		case 12:date+="December ";break;
		}
		date+=scr.nextInt()+", "+scr.nextInt();		
		return date;
	}

}
