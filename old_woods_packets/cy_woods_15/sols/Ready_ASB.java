import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.util.Map;

public class Ready {
	
	Map<String, Double> map;

	public static void main(String[] args) throws Exception{
		Ready r = new Ready();
		r.run();
	}
	
	void run() throws Exception{
		Scanner file = new Scanner(new File("ready.dat"));
		int times = file.nextInt();
		file.nextLine();
		for (int asdf = 0; asdf<times; asdf++){
			int anims = file.nextInt();
			String name = "";
			double caughtTime = Double.MAX_VALUE;
			map = new TreeMap<String, Double>();
			for (int i = 0; i<anims; i++){
				map.put(file.next(), file.nextDouble());
			}
			file.nextLine();
			int check = (int)(file.nextDouble()*100);
			for (Map.Entry<String, Double> entry : map.entrySet()){
				String n = entry.getKey();
				int time = (int)(entry.getValue()*100);
				if (!(check<=time && time%check == 0)){
					double a = 12.00;
					double b = 12.00;
					a += time/100.0;
					b += check/100.0;
					while (a==b && a<6.0){
						a += time;
						b += check;
					}
					if ((n.compareTo(name)<0 || name.equals("")) && a<caughtTime){
						name = n;
						caughtTime = a;
					}
				}
			}
			if (name.equals("")){
				System.out.println("6:00 A.M. Yay!");
			}
			else{
				double c = caughtTime;
				if(caughtTime >= 13)
					caughtTime -= 12;
				while(c>=1){
					c -= 1.0;
				}
				int c2 = (int)(Math.round(c*60));
				String c3 = "" + c2;
				if(c2<10)
					c3 = "0" + c2;
				System.out.println(name + " " + (int)caughtTime + ":" + c3 + " A.M.");
			}
		}
	}

}
