import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class trick {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("trick.dat"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] conditions = line.split("AND|OR");
            for(int i = 0; i < conditions.length;i ++){
                conditions[i] = conditions[i].strip();
                if(conditions[i].contains("not")){
                    conditions[i] = conditions[i].replace("not ", "");
                }
                else{
                    conditions[i] = "not "+conditions[i];
                }
            }
            String conj = line.contains("AND")?"OR":"AND";
            System.out.printf("not (%s %s %s)%n",conditions[0],conj,conditions[1]);
        }
    }
}
