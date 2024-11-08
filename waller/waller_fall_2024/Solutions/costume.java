import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class costume {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("judges\\costume.dat"));
        int runs = sc.nextInt();
        for (int i = 0; i < runs; i++) {
            int count = sc.nextInt(); sc.nextLine();
            ArrayList<Contestant> contestants = new ArrayList<>();
            for(int j = 0; j < count; j++){
                contestants.add(new Contestant(sc.nextLine()));
                for(String s: sc.nextLine().split(" ")){
                    contestants.getLast().score += Integer.parseInt(s);
                }
            }
            contestants.sort(null);
            int cont = 1;
            for (Contestant contestant : contestants.reversed()) {
                System.out.println(cont +". "+contestant);
                cont += 1;
            }
            System.out.println("----------------");
        }
    }
}
class Contestant implements Comparable<Contestant>{
    String outfit;
    int score;
    Contestant(String o){
        outfit = o;
    }
    public int compareTo(Contestant obj){
        return this.score - obj.score;
    }
    public String toString(){
        return String.format("(%2d) - %s",score, outfit);
    }
}