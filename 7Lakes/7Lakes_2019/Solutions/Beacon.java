import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Beacon {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("beacon.in"));
		
		while (in.hasNextInt()) {
			int lvl = in.nextInt();
//			long ingots = lvl * (4 * lvl * lvl - 1) * 3 - 9;
//			ingots = (lvl * (4 * lvl * lvl - 1) / 3 - 1) * 9;
//			long faces = (lvl * 2 - 1) * (lvl * 2 - 1) * 2 + (lvl * lvl * 4);
			if (lvl == 0) {
				System.out.println("Ingots Needed: 0\nFaces: 0\n");
				continue;
			}
			BigInteger lvlBig = BigInteger.valueOf(lvl);
			BigInteger ingotsBig = lvlBig.pow(2).multiply(BigInteger.valueOf(4))
					.subtract(BigInteger.ONE).multiply(lvlBig).multiply(BigInteger.valueOf(3))
					.subtract(BigInteger.valueOf(9));
			BigInteger facesBig = lvlBig.multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE)
					.pow(2).multiply(BigInteger.valueOf(2))
					.add(lvlBig.multiply(lvlBig).multiply(BigInteger.valueOf(4)));
			System.out.println("Ingots Needed: " + ingotsBig);
			System.out.println("Faces: " + facesBig);
			System.out.println();
		}
	}
}
