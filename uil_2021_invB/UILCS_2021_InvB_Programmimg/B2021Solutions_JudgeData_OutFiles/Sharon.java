import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Sharon {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("sharon.dat"));
		int g = Integer.parseInt(f.nextLine());
		for(int x = 1; x <= g; x++) {
			ArrayList<String> players = new ArrayList<String>();
			int c = f.nextInt();
			int p = f.nextInt();
			for(int y = 1; y <= p; y++)
				players.add(f.next());
			int index = c - 1;
			while(players.size() > 1) {
				//out.println("player.size = "+players.size()+" index = " + index);
				while(index > players.size() - 1)
					index = index - players.size();
				//out.println("index after if statement = "+index);
				players.remove(index);
				//out.println(players);
				index += (c -1); 
				
					
				
			}
			out.println("The winner is " + players.get(0));
		}
	}

}
