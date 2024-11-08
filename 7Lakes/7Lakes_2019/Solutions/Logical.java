import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Logical {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("logical.in"));
		int runs = in.nextInt();
		in.nextLine();
		String lin = in.nextLine().trim();
		for (int run = 0; run < runs; run++) {
			EXP e = new EXP(lin);
			while (in.hasNext()) {
				lin = in.nextLine().trim();
				if (!lin.contains(","))
					break;
				String[] strVals = lin.split(",");
				HashMap<String, Boolean> vals = new HashMap<>();
				for (int i = 0; i < strVals.length; i++) 
					vals.put(strVals[i].substring(0, 1), strVals[i].charAt(2) == '1');
				System.out.println(e.eval(vals));
			}
			System.out.println();
		}
	}
}

class EXP {
	List<Object> list = new ArrayList<>();
	
	public EXP(String lin) {
		String[] k = lin.split(" +");
		for (int i = 0; i < k.length; i++) {
			if (k[i].startsWith("(")) {
				String exp = "";
				int pCount = 0;
				do {
					for (char c : k[i].toCharArray()) {
						if (c == '(')
							pCount++;
						else if (c == ')')
							pCount--;
						exp += c;
					}
					exp += " ";
					i++;
				} while (pCount > 0);
				i--;
				exp = exp.trim();
				list.add(new EXP(exp.substring(1, exp.length() - 1)));
			} else 
				list.add(k[i]);
		}
	}
	
	public boolean eval(Map<String, Boolean> vals) {
		List<Object> ans = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof EXP) 
				ans.add(((EXP) list.get(i)).eval(vals));
			else if (vals.containsKey(list.get(i)))
				ans.add(vals.get(list.get(i)));
			else
				ans.add(list.get(i));
		}
		
		while (ans.contains("!")) {
			int index = ans.indexOf("!");
			ans.remove(index);
			boolean b = (boolean) ans.get(index);
			ans.set(index, !b);
		}
		
		while (ans.contains("&&")) {
			int index = ans.indexOf("&&") - 1;
			boolean a = (boolean) ans.remove(index);
			ans.remove(index);
			boolean b = (boolean) ans.get(index);
			ans.set(index, a && b);
		}
		
		while (ans.contains("^")) {
			int index = ans.indexOf("^") - 1;
			boolean a = (boolean) ans.remove(index);
			ans.remove(index);
			boolean b = (boolean) ans.get(index);
			ans.set(index, a ^ b);
		}
		
		while (ans.contains("||")) {
			int index = ans.indexOf("||") - 1;
			boolean a = (boolean) ans.remove(index);
			ans.remove(index);
			boolean b = (boolean) ans.get(index);
			ans.set(index, a || b);
		}
		
		return (boolean) ans.get(0);
	}
	
	public String toString() {
		return "E: " + list.toString();
	}
}