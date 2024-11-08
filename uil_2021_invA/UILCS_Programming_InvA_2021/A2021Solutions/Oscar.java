import java.util.*;
import java.io.*;
import static java.lang.System.out;
public class Oscar {

	public static void main(String[] args) throws IOException
		{
		Scanner file = new Scanner(new File("oscar.dat"));
		int n = file.nextInt();
		file.nextLine();
		for(int i = 1; i <= n; i++) 
			{
			Queue<Ogre> bucketLine = new LinkedList<Ogre>();
			Scanner line = new Scanner(file.nextLine());
			while(line.hasNext())
				bucketLine.add(new Ogre(line.next(),Integer.parseInt(line.next())));
			Ogre current = bucketLine.remove();
			out.print(current.getName() + " ");
			while(!bucketLine.isEmpty())
				{
				Ogre next = bucketLine.remove();
				if(next.getSize() >= current.getSize())
					{
					out.print(next.getName() + " ");
					current = next;
					}
				}
			out.println();
			}
		}
	
	public static class Ogre
	{
		private String name;
		private int size;
		public Ogre(String name, int size) 
		{
			this.name = name;
			this.size = size;
		}
		
		public String getName() {return name;}
		public int getSize() {return size;}		
	}
}
