/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Noah
{

	public static class CarmakeComparator implements Comparator<CarObject>
	{
	    @Override
	    public int compare(CarObject c1, CarObject c2) {
	        int makeCompare=c1.make.compareTo(c2.make);
        	int modelCompare=c1.model.compareTo(c2.model);
        	int yearCompare=c1.year-c2.year;
        	if(makeCompare!=0)
        		return makeCompare;
        	if(modelCompare!=0)
        		return modelCompare;
        	return yearCompare;
	    }
	}

	public static class CarModelComparator implements Comparator<CarObject>
	{
	    @Override
	    public int compare(CarObject c1, CarObject c2) {
        	int modelCompare=c1.model.compareTo(c2.model);
        	int yearCompare=c1.year-c2.year;
			if(modelCompare!=0)
        		return modelCompare;
        	return yearCompare;
	    }
	}

	public static class CarYearComparator implements Comparator<CarObject>
	{
	    @Override
	    public int compare(CarObject c1, CarObject c2) {
        	int makeCompare=c1.make.compareTo(c2.make);
        	int modelCompare=c1.model.compareTo(c2.model);
        	int yearCompare=c1.year-c2.year;
        	if(yearCompare!=0)
        		return yearCompare;
        	if(makeCompare!=0)
        		return makeCompare;
        	return modelCompare;
	    }
	}

	public static class CarObject
	{
	    public String make;
	    public String model;
	    public int year;
	 
	    public CarObject(String make, String model, int year)
	    {
	        this.make = make;
	        this.model = model;
	        this.year = year;
	    }

	    public String toString()
	    {
    		return make+" "+model+" "+year;
		}	
	 
	}

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("noah.dat"));
		int numStudents=s.nextInt();
		s.nextLine();
		CarObject[] myCars=new CarObject[numStudents];
		for(int a=0;a<numStudents;a++)
		{
			String line=s.nextLine();
			String splitLine[]=line.split(",");
			myCars[a]=new CarObject(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]));
			
		}
		
		java.util.Arrays.sort(myCars, new CarmakeComparator());
		System.out.println("---Data Sorted---");
		for(int a=0;a<myCars.length;a++)
		{
			System.out.println(myCars[a]);
		}
		System.out.println("\n---Make Breakdown---");

		int count=1;
		for(int a=1;a<myCars.length;a++)
		{
			if(myCars[a].make.equals(myCars[a-1].make))
			{
				count++;
				continue;
			}
			System.out.println(myCars[a-1].make+": "+count);
			count=1;
		}
		//still have one last element
		System.out.println(myCars[myCars.length-1].make+": "+count);
		System.out.println("\n---Model Breakdown---");

		java.util.Arrays.sort(myCars, new CarModelComparator());
		count=1;
		for(int a=1;a<myCars.length;a++)
		{
			if(myCars[a].model.equals(myCars[a-1].model))
			{
				count++;
				continue;
			}
			System.out.println(myCars[a-1].model+": "+count);
			count=1;
		}
		//still have one last element
		System.out.println(myCars[myCars.length-1].model+": "+count);
		System.out.println("\n---Year Breakdown---");

		java.util.Arrays.sort(myCars, new CarYearComparator());
		count=1;
		for(int a=1;a<myCars.length;a++)
		{
			if(myCars[a].year==myCars[a-1].year)
			{
				count++;
				continue;
			}
			System.out.println(myCars[a-1].year+": "+count);
			count=1;
		}
		//still have one last element
		System.out.println(myCars[myCars.length-1].year+": "+count);
		System.out.println();

	}
}