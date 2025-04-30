import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Eszter
{ 
    public static double cut(double price[], int n) 
    { 
        if (n <= 0) 
            return 0.0; 
        double max_val = Double.MIN_VALUE; 
  
         
        for (int i = 0; i < n; i++) 
            max_val = Math.max(max_val, price[i] + cut(price, n - i - 1)); 
  
        return max_val; 
    } 
  
    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("eszter.dat"));
        
        int N = s.nextInt();
        s.nextLine();
        for ( int n = 0; n < N; n++ )
        {
            String line=s.nextLine();
            line=line.substring(1,line.length()-1);
            String[] pricesString = line.split(",");
            double[] pricesDouble=new double[pricesString.length];
            for(int a=0;a<pricesString.length;a++)
                pricesDouble[a]=Double.parseDouble(pricesString[a]);
            
            System.out.printf("Maximum profit is $%.2f\n",cut(pricesDouble, pricesDouble.length)); 
        }
    } 
}