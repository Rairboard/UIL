import java.util.*;
import java.io.*;

public class Carmoji{
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(new File("carmoji.in"));
		int sets = sc.nextInt();
		sc.nextLine();
		for(int set=0;set<sets;set++){
			String s = sc.nextLine();
			System.out.println(replace(s));
		}
		sc.close();
	}
	
	public static String replace(String str){
		str = str.replaceAll(":D", "lau.gh");
		str = str.replaceAll(":\\)", "smi.le");
		str = str.replaceAll(":\\{\\)", "disgui.se");
		str = str.replaceAll(":\\]", "awkwa.rd");
		str = str.replaceAll("O\\.o", "sho.ck");
		
		str = str.replaceAll("laugh", ":D");
		str = str.replaceAll("smile", ":)");
		str = str.replaceAll("disguise", ":{)");
		str = str.replaceAll("awkward", ":]");
		str = str.replaceAll("shock", "O.o");
		
		str = str.replaceAll("lau\\.gh", "laugh");
		str = str.replaceAll("smi\\.le", "smile");
		str = str.replaceAll("disgui\\.se", "disguise");
		str = str.replaceAll("awkwa\\.rd", "awkward");
		str = str.replaceAll("sho\\.ck", "shock");
		
		return str;
	}
}