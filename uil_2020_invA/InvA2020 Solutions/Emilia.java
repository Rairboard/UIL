/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emilia {

	public static void printTime(double h, double m){
		int hour=0,minute=0;

		//calculate the hour
		//if h is in range [0,90] use equation: y=(x-90)/-30
		//else h is in range [91,359] use equation: y=(x-450)/-30
		
		if(h>=0&&h<=90)
			hour=(int)(h-90)/-30;
		else
			hour=(int)(h-450)/-30;


		//calculate the minute
		//if m is in range [0,90] use equation: y=(x-90)/-6
		//else m is in range [91,359] use equation: y=(x-450)/-6
		
		if(m>=0&&m<=90)
			minute=(int)(m-90)/-6;
		else
			minute=(int)(m-450)/-6;

		//if hour is equal to 0, set to 12
		if(hour==0)
			hour=12;

		System.out.printf("%02d:%02d%n",hour,minute);

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("emilia.dat"));
		int N = s.nextInt();
		for ( int n = 1; n <= N; n++ )
		{
			double hourDegree = s.nextDouble();
			double minuteDegree = s.nextDouble();
			printTime(hourDegree,minuteDegree);
		}
		s.close();
	}
}