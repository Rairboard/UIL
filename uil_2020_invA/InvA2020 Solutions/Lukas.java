/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lukas
{
    public static boolean isLegalName(String s,String l)
    {
        //must start with a letter or underscore
        if(!(Character.isLetter(s.charAt(0))||s.charAt(0)=='_'||s.charAt(0)=='$'))
            return false;

        //remaining characters must be letters, numbers, $, or underscores
        //this will also account for the symbols and space requirments
        for(int count=1;count<s.length();count++)
        {
            if(!(Character.isLetterOrDigit(s.charAt(count))||s.charAt(count)=='$'||s.charAt(count)=='_'))
                return false;
        }
       

        //cannot use reserved words such as double or class
        String reservedWordsString=l;
        reservedWordsString+=",true,false,null";
        String[] reservedWordsArray = reservedWordsString.split(",");
        for(int count=0;count<reservedWordsArray.length;count++)
        {
            if(s.equals(reservedWordsArray[count]))
                return false;
        }
        return true;
    }
    public static void main(String args[]) throws FileNotFoundException {
        int dollarSign$=1;
        Scanner s = new Scanner(new File("lukas.dat"));
        String line=s.nextLine();
        int N = s.nextInt();
        for ( int n = 1; n <= N; n++ )
        {
            String inputString = s.next();
            boolean isLegal=isLegalName(inputString,line);
            if(isLegal)
            	System.out.println("Valid");
            else
            	System.out.println("Invalid");

        }
        s.close();
    }
}