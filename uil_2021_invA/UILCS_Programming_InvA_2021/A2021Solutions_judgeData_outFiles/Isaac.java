import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Isaac
{
	public static void main(String args[]) throws FileNotFoundException
	{
        Scanner s;
		if(args.length==0)
            s = new Scanner(new File("isaac.dat"));
        else
            s = new Scanner(new File(args[0]));

        int numCases=s.nextInt();
        for(int caseNum=0;caseNum<numCases;caseNum++)
        {
            ArrayList<String> files=new ArrayList<String>();
            int numFiles=s.nextInt();
            int maxLength=0;

            for(int loopC=0;loopC<numFiles;loopC++)
            {
                String file=s.next();
                if(file.length()>maxLength)
                    maxLength=file.length();
                files.add(file);
            }

            Collections.sort(files);

            final int MAX=60;

            int columns = (MAX - maxLength) / (maxLength + 2) + 1;
            int rows = files.size() / columns; 
            if(files.size() % columns != 0)
                rows++;

            columns = files.size() / rows;
            if(files.size() % rows != 0)
                columns++;
            System.out.println("Case "+(caseNum+1));
            System.out.println("         111111111122222222223333333333444444444455555555556");
            System.out.println("123456789012345678901234567890123456789012345678901234567890");
            System.out.println("------------------------------------------------------------");

            for(int x=0;x<rows;x++)
            {
                int index=x;
                for(int y=0;y<columns;y++)
                {
                    if(y<columns-1)
                        System.out.printf("%-" +(maxLength+2) + "s",files.get(index));
                    else
                        System.out.printf("%-" +(maxLength) + "s",files.get(index));
                    index+=rows;
                    if(index>=files.size())
                        break;
                }
                System.out.println();

            }
            System.out.println();
        }

        

        s.close();
        
    }
}