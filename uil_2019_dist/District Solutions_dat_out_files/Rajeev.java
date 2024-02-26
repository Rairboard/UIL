//UIL Cistrict 2019 Solution
import java.io.File;
import java.util.Scanner;


public class Rajeev
{
    public static void display(String toDisp)
    {
        String info[] = toDisp.split(",");
        System.out.print(info[0]+":");
        System.out.print(info[1]);
        for (int i = 2; i < info.length; i++) {
            
            if(info[i].replaceAll("@uil.net", "").replaceAll("@uiltexas.org", "").contains("@"))
            {
                System.out.print(":" + info[i]);
            }
        }
        System.out.println("");
    }
    public static void main(String args[])throws Exception
    {
        Scanner file = new Scanner(new File("rajeev.dat"));
        while(file.hasNextLine())
        {
            String testLine = file.nextLine();
            if(testLine.replaceAll("@uil.net", "").replaceAll("@uiltexas.org", "").contains("@"))
                display(testLine);
        }
    }
}
