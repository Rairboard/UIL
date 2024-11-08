//UIL 2018 - Region - Opus
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Opus
 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("opus.dat"));
		String s = f.nextLine();
		char[]key = new char[40];
		Scanner k = new Scanner(s);
		k.next();//jump over "KEY"
		int i = 0;
		while(k.hasNext())
			key[i++]=k.next().charAt(0);
			
//		int N = f.nextInt();
//		f.nextLine();
		ArrayList<Student>list = new ArrayList<Student>();
		while(f.hasNext()){
			s = f.nextLine();
			Student st = new Student(s,key);
			list.add(st);
		}
		Collections.sort(list);
		int place = 1;
		String conf = list.get(0).conf;
		out.println(conf);
		
		for(i=0;i<list.size();i++){
			if(i>0&&list.get(i).unbreakable(list.get(i-1)))
				out.print((place-1)+" ");
			else	
				out.print(place+" ");
			out.println(list.get(i));
			if(i<list.size()-1&&!list.get(i+1).conf.equals(conf))
			{
				conf=list.get(i+1).conf;
				out.println(conf);
				place = 1;
			}else place++;
		}
	}
	
}
class Student implements Comparable<Student>{
	String first,last,school,conf;
	char[]ans;
	int score;
	double per;
	public boolean unbreakable(Student s)
	{
		if(this.per==s.per) return true;
		return false;
	}
	public int compareTo(Student s)
	{
		if(this.conf.compareTo(s.conf)<0) return -1;
		if(this.conf.compareTo(s.conf)>0) return 1;
		if(this.score>s.score) return -1;
		if(this.score<s.score) return 1;
		if((this.per-s.per)<0) return 1;
		if((this.per-s.per)>0) return -1;
		if(this.last.compareTo(s.last)>0) return 1;
		if(this.last.compareTo(s.last)<0) return -1;
		if(this.first.compareTo(s.first)>0) return 1;
		if(this.first.compareTo(s.first)<0) return -1;
		return 0;
	}
	public String toString()
	{
		return last+", "+first+" - "+school+": "+score; 
	}
	Student(String s, char[]key){
		Scanner k = new Scanner(s);
		ans=new char[40];
		first = k.next();
		last = k.next();
		school = k.next();
		conf = k.next();
		int corr=0, incor=0;
		int i = 0;
		int scr = 0;
		while(k.hasNext())
		{
			char a = k.next().charAt(0);
//			out.print(a+":");
			ans[i]=a;
//			out.print(ans[i]+".");
// 			out.println(key[i]==ans[i]);
 			if(key[i]==ans[i])
				corr++;
		    else if(ans[i]!='S'&&ans[i]!=key[i])
		    	incor++;
			i++;
		}
//		out.println();
		per = (double)corr/(corr+incor);
		score=corr*6-incor*2;
	}
}
