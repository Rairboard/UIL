import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Screenplay {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Screenplay().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{        
		//System.out.println("Liloliplop could be caught by us".matches("(((([a-z]+)|((Mike)|(Quorduto)|(Diombids)|(Weeoeooeo)|(Sheila)|(Zarlak5)|(Quonduto)|(Liloliplop)|(Applebottomjeans))) )+((will)|(should)|(could)|(can)) be ((explains)|(explained)|(catch)|(caught)|(setting)|(changed)|(explaining)|(yells)|(explain)|(yell)|(yelling)|(yelled)|(lifts)|(lift)|(lifted)|(lifting)|(am)|(are)|(is)|(get)|(gets)|(getting)|(got)|(moves)|(moved)|(moving)|(move)|(talk)|(talked)|(talking)|(talks)|(run)|(running)|(runs)|(ran)|(will)|(use)|(uses)|(used)|(using)|(want)|(wanting)|(wanted)|(wants)|(tell)|(tells)|(telling)|(told)|(turns)|(turning)|(turn)|(turned)|(work)|(works)|(working)|(worked)|(try)|(trying)|(tried)|(tries)|(think)|(thinks)|(thinking)|(thought)|(take)|(took)|(taking)|(takes)|(start)|(starts)|(started)|(starting)|(show)|(shows)|(showing)|(showed)|(see)|(sees)|(seeing)|(saw)|(seem)|(seemed)|(seems)|(seeming)|(say)|(saying)|(says)|(said)|(run)|(running)|(ran)|(runs)|(put)|(puts)|(putting)|(play)|(plays)|(playing)|(played)|(need)|(needed)|(needing)|(needs)|(mean)|(means)|(meaning)|(meaned)|(make)|(makes)|(making)|(made)|(look)|(looking)|(looks)|(looked)|(live)|(lives)|(living)|(lived)|(likes)|(like)|(liked)|(liking)|(leave)|(leaves)|(leaving)|(left)|(let)|(lets)|(letting)|(know)|(knows)|(knowing)|(knew)|(keep)|(keeps)|(keeping)|(kept)|(help)|(helps)|(helped)|(helping)|(hear)|(hears)|(hearing)|(heard)|(have)|(having)|(had)|(has)|(go)|(goes)|(going)|(gone)|(get)|(gets)|(getting)|(got)|(ask)|(asks)|(asking)|(asked)|(feel)|(feeling)|(feels)|(felt)|(gives)|(gave)|(give)|(giving)) by ((Mike)|(he)|(she)|(they)|(it)|(reality)|(sky)|(ground)|(boat)|(road)|(Quorduto)|(Diombids)|(Weeoeooeo)|(Sheila)|(we)|(you)|(Zarlak5)|(Quonduto)|(Liloliplop)|(Applebottomjeans)))"));
		Scanner file = new Scanner(new File("screenplay.dat"));                                                                       
		String subject = "", proper = "", verbs = "", object1, object2, con1, con2;
		String[] s = file.nextLine().split(", ");
		for(String t:s)
			verbs += "|("+t+")";
		verbs = "("+verbs.substring(1)+")";
		s = file.nextLine().split(", ");
		for(String t:s) {
			if(Character.isUpperCase(t.charAt(0)))
				proper+="|("+t+")";
			subject+="|("+t+")";
		}
		subject = "("+subject.substring(1)+")";
		proper = "("+proper.substring(1)+")";
		con1 = "((will)|(should)|(could)|(can))";
		con2 = "((was)|(were)|(are)|(is))";
		object1 = "( (([a-z]+)|"+proper+"))+";
		object2 = "((([a-z]+)|"+proper+") )+";
		String sentence = "("+subject+" "+verbs+object1+")|("
							+subject+" ("+con1+"|"+con2+") "+verbs+object1+")|(";
		sentence+= object2+con1+" be "+verbs+" by "+subject+")|("
							+object2+con2+" "+verbs+" by "+subject+")";
		//System.out.println("("+object2+con1+" be "+verbs+" by "+subject+")");
		String valid = "("+sentence+")([,;] ((and)|(or)|(but)) ("+sentence+"))?([\\.\\?!])";
		String dialogue = proper+": \".+\"";
		int times = file.nextInt();   
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			String cur = file.nextLine().trim();
			if(cur.matches(dialogue))
				System.out.println("Dialogue");
			else if(lower0(cur, proper).matches(valid) && Character.isUpperCase(cur.charAt(0)))
				System.out.println("Valid Line");
			else
				System.out.println("Invalid Line");
		}                                                                                                                          
	} 
	
	String lower0(String r, String proper) {//I missed one thing so I made this so I didn't have to rewrite
		String[] s = r.split(" ");
		if(s[0].matches(proper) || s.length <= 1)
			return r;
		else {
			String t = s[0];
			t = Character.toLowerCase(t.charAt(0)) + t.substring(1);
			return r.replaceAll(s[0], t);
		}
	}
}                                                                                                                                  
                                                                                                                                   