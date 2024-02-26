//UIL District 2019 Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Banu {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("banu.dat"));
		while(f.hasNext())
		{
			String newAppt="";
			int month=f.nextInt();
			switch(month) {
				case 1:newAppt="January";break;
				case 2:newAppt="February";break;
				case 3:newAppt="March";break;
				case 4:newAppt="April";break;
				case 5:newAppt="May";break;
				case 6:newAppt="June";break;
				case 7:newAppt="July";break;
				case 8:newAppt="August";break;
				case 9:newAppt="September";break;
				case 10:newAppt="October";break;
				case 11:newAppt="November";break;
				case 12:newAppt="December";break;
				}
			out.println(newAppt);
		}
	}
}
