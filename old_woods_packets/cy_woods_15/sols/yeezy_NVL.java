import java.io.*;
import java.util.*;

public class yeezy_NVL {

    public yeezy_NVL() {
    }

    public static void main(String[] args) throws Exception{
         Scanner file = new Scanner(new File("yeezy.dat"));
         int times = file.nextInt();
         file.nextLine();
         for(int i = 0; i < times; i++)
         {
         	double sal = file.nextDouble();
         	if((sal * 860) * .25 < 2000)
         	{
         		System.out.println("False");
         	}
         	else
         	{
         		System.out.println("True");
         	}
         }
    }
}
