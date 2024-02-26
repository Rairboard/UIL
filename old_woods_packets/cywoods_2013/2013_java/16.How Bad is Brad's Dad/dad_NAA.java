import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class dad
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("dadsj.dat"));
		int times = file.nextInt();file.nextLine();
		for(int n=0;n<times;n++)
		{
			int dads = file.nextInt();file.nextLine();
			Map<String,ArrayList<String>> m = new HashMap<String,ArrayList<String>>();
			for(int i = 0 ; i < dads ; i++)
			{
				String beater = file.nextLine().trim();
				String beaten = file.nextLine().trim();
				//out.println(beater+" "+beaten);
				if(m.containsKey(beater))
				{
					m.get(beater).add(beaten);
					//out.println("adding"+beaten+" to "+beater);
				}
				else
				{
					ArrayList<String> ad = new ArrayList<String>();
					ad.add(beaten);
					m.put(beater,ad);
					//out.println("adding"+beaten+" to "+beater);
				}
				//out.println(beater+ " can beat "+m.get(beater));
				if(m.containsKey(beaten))
				{
					m.get(beater).addAll(m.get(beaten));
				}
				Set<String> s = m.keySet();
				Iterator<String> it = s.iterator();
				while(it.hasNext())
				{
					String here = it.next();
					ArrayList<String> process = m.get(here);
					for(int k=0;k<process.size();k++)
					{
						String str=process.get(k);
						if(str.equals(beater))
						{
							if(m.get(here).contains(beater)!=true)
								m.get(here).add(beater);
							for(int l=0;l<m.get(beater).size();l++)
							{
								if(m.get(here).contains(m.get(beater).get(l))!=true)
								{
									m.get(here).add(m.get(beater).get(l));
								}
							}
						}
					}
				}
				/*
				if(beater.equals("Andy"))
					out.println(beater+" now can beat all these: "+m.get(beater));
				*/
			}
			//out.println(m.get("Andy"));
			int fights = file.nextInt();file.nextLine();
			for(int i=0;i<fights;i++)
			{
				String instigator = file.nextLine().trim();
				String victim = file.nextLine().trim();
				//out.println(instigator+"'s dad can beat up all these dads:: "+m.get(instigator));
				/*
				if(instigator.equals("Brad"))
					new Scanner(System.in).nextLine();
				*/

				//to verify complete depth
				boolean b = false;
				String checked = "";
				ArrayDeque<String> q = new ArrayDeque<String>();
				q.addFirst(instigator);
				loop:while(q.size()!=0)
				{
					String here = q.removeFirst();
					ArrayList<String> children = m.get(here);
					/*
					if(here.equals("Andy"))
						out.println(here+" "+children);
					*/
					if(here.equals(victim)||(children!=null&&children.contains(victim)))
						b=true;
					if(checked.indexOf("<>"+here+"<>")<0)
					{
						checked+="<>"+here+"<>";
					}
					else
					{
						continue loop;
					}
					if(children==null)
						continue loop;
					for(String s: children)
					{
						q.add(s);
					}
				}
				//out.println(checked);
				//out.println(m.get(instigator));

				if(m.get(instigator)!=null&&m.get(instigator).contains(victim))
				{
					out.println(instigator+"'s dad can beat up "+victim+"'s dad.");
				}
				else
				{
					out.println(instigator+"'s dad isn't bad enough.");
				}
			}
			out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		dad a=new dad();
		a.run();
	}
}