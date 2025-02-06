import java.io.File;
import java.util.Scanner;

public class Dog{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("dog.dat"));
		int reps = file.nextInt();
		file.nextLine();
		for(int x = 0;x < reps;x++) {
			int size = file.nextInt();
			
			String[][] route = new String[size][size];
			
			//fills it with blank space
			for(int a = 0; a<size; a++) {
				for(int b = 0; b<size; b++) {
					route[a][b]=" ";
				}
			}
			
			//adds in a character border
			for(int a = 0; a<size; a++) {
				route[0][a] = "@";
				route[size-1][a] = "@";
				route[a][size-1] = "@";
				route[a][0] = "@";
			}
			
			//prints out the matrix
			for(int a = 0; a<size; a++) {
				for(int b = 0; b<size; b++) {
					System.out.print(route[a][b]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		Dog a=new Dog();
		a.run();
	}
}