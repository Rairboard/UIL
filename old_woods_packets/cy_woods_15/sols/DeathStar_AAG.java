import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DeathStar_AAG {

    public void run() throws FileNotFoundException{
    	Scanner file = new Scanner(new File("planetData.dat"));
    	int n=file.nextInt();
    	file.nextLine();
    	for(int i=0; i<n; i++){
    		if(file.nextLine().equals("Empire"))
    			System.out.println("False");
    		else
    			System.out.println("True");
    	}
    }
    
    public static void main(String[] args) throws FileNotFoundException{
    	new DeathStar_AAG().run();
    }
}