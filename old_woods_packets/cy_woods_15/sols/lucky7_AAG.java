import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class lucky7_AAG {

    public void run() throws FileNotFoundException{
    	Scanner file = new Scanner(new File("lucky7.dat"));
    	int n=file.nextInt();
    	for(int i=0; i<n; i++){
    		int lines=file.nextInt();
    		file.nextLine();
    	 	String win="LOSER";
    		for(int j=0; j<lines; j++){
    			String lin = file.next()+file.next()+file.next();
    			file.nextLine();
    			if(lin.equals("777")){
    				win="WINNER";
    				break;
    			}
    		}
    		System.out.println(win);
    	}
    }
    
    public static void main(String[] args) throws FileNotFoundException{
    	new lucky7_AAG().run();
    }
}