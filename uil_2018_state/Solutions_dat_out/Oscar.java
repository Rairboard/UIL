import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Oscar {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("oscar.dat"));
		while(f.hasNext()) {
			String line1="";
			String line2="";
			String line3="";
			String text=f.nextLine();
			String[] words=text.split(" ");
			boolean legalWords=true;
			boolean legalSign=true;
			for(int x=0;x<words.length;x++)
				if(words[x].length()>10)
					legalWords=false;
			if(!legalWords||text.length()>32)
				out.println("SIGN CANNOT BE MADE\n");
			else {
				line1="..........";
				line2="..........";
				line3="..........";
				if(words.length==1) {
					int start=(10-words[0].length())/2;
					int stop=start+words[0].length();
					line2=line2.substring(0, start)+words[0]+line2.substring(stop);
				}
				else if(words.length==2) {
					int start=(10-words[0].length())/2;
					int stop=start+words[0].length();
					line1=line1.substring(0, start)+words[0]+line1.substring(stop);
					start=(10-words[1].length())/2;
					stop=start+words[1].length();
					line2=line2.substring(0, start)+words[1]+line2.substring(stop);
				}
				else if(words.length==3) {
					int start=(10-words[0].length())/2;
					int stop=start+words[0].length();
					line1=line1.substring(0, start)+words[0]+line1.substring(stop);
					start=(10-words[1].length())/2;
					stop=start+words[1].length();
					line2=line2.substring(0, start)+words[1]+line2.substring(stop);
					start=(10-words[2].length())/2;
					stop=start+words[2].length();
					line3=line3.substring(0, start)+words[2]+line3.substring(stop);
				}
				else {
					String[] lines= {"","",""};
					int line_num=0;
					for(int x=0;x<words.length;x++) {
						if(words.length-x>2-line_num) {
							if(lines[line_num].length()+words[x].length()<=10) {
								lines[line_num]+=words[x];
								if((x!=words.length-1)&&(lines[line_num].length()+words[x+1].length()<=10))
									lines[line_num]+=".";
								}
							else {
								if(line_num<2) {
									line_num++;
									lines[line_num]=words[x]+".";
									}
								else {
									int length_of_remaining_words=0;
									int spaces=0;
									for(int i=x;i<words.length;i++) {
										length_of_remaining_words+=words[i].length();
										if(i<words.length-1) spaces++;
										}
									int total=length_of_remaining_words+spaces;
									if(lines[2].length()+total<=10) 
										lines[line_num]=words[x]+".";
									else {
										out.println("SIGN CANNOT BE MADE\n");
										legalSign=false;
										break;
										}
									}
								}
						}
						else {
							if(words.length-x==1) {
								lines[2]=words[x];
							}
							else {
								lines[1]=words[x];
								lines[2]=words[x+1];
							}
							break;
							}
						}					
					int start=(10-lines[0].length())/2;
					int stop=start+lines[0].length();
					line1=line1.substring(0, start)+lines[0]+line1.substring(stop);
					start=(10-lines[1].length())/2;
					stop=start+lines[1].length();
					line2=line2.substring(0, start)+lines[1]+line2.substring(stop);
					start=(10-lines[2].length())/2;
					stop=start+lines[2].length();
					line3=line3.substring(0, start)+lines[2]+line3.substring(stop);					
				}
				if(legalSign) {
				out.println("************");
				out.println("*"+line1+"*");
				out.println("*"+line2+"*");
				out.println("*"+line3+"*");
				out.println("************");
				out.println();}
			}			
		}
	}
}


