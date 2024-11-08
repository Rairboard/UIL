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


class Apple
{
	//instance variables go here

	public void run()throws Exception
	{
		System.out.println("       .--,");
		System.out.println("    _ (_.'_");
		System.out.println(" .'`  `-'  ``.");
		System.out.println(":          .-'");
		System.out.println(":         :");
		System.out.println(" :         `-;");
		System.out.println("  `.__.-.__.'");
	}

	public static void main(String[] args)throws Exception
	{
		Apple a = new Apple();
		a.run();
	}
}