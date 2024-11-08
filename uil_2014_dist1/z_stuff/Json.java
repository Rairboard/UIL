//JSON - Solution
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Json {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("json.dat"));
		int t = sc.nextInt();
		// Map of object name to list of attributes
		Map<String, List<String>> properties = new HashMap<>();
		sc.nextLine();
		while(t-- > 0){
			String line = sc.nextLine();
			// check its a print statement
			if(line.startsWith("print("))
				print(line, properties.get(line.substring(line.indexOf("(")+1, line.length()-1)));
			else{
				// split on " = " or  "."
				// arr[0] = object; arr[1] = key; arr[2] = value
				String[] arr = line.split("( = )|[.]");
				// create a list if this is the first time the object has been referenced
				if(properties.get(arr[0]) == null)
					properties.put(arr[0], new ArrayList<String>());
				// add to list format of "key : value"
				properties.get(arr[0]).add(arr[1] + " : " + arr[2]);
			}
		}
	}

	private static void print(String line, List<String> list) {
		String answer = "{";
		// add all attributes to answer
		for(String i : list){
			answer += i + ", ";
		}
		//eliminate last ", " and put closing curly brace
		answer = answer.substring(0, answer.length()-2) + "}";
		System.out.println(answer);
	}

}
/*
Test data:
17
Cake.ingredient = sugar
print(Cake)
Cake.bake = oven
print(Cake)
dog.treat = bone
print(dog)
boat.type = sailboat
boat.length = 33
boat.color = white
boat.year = 1968
print(boat)
uil.topic = CS
uil.test = 40_MC
uil.packet = 12
uil.topScore = 1440
uil.status = CS_Rocks!!
print(uil)

Output:
{ingredient : sugar}
{ingredient : sugar, bake : oven}
{treat : bone}
{type : sailboat, length : 33, color : white, year : 1968}
{topic : CS, test : 40_MC, packet : 12, topScore : 1440, status : CS_Rocks!!}
*/
