import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class candystore {
    static ArrayList<Candy> candies;
    static int[][] values;
    public static void maxValue(int n, int budget){
        if(n == 0 || budget <= 0){
            values[n][budget] = 0;
            return;
        }
        if(values[n-1][budget] == -1){
            maxValue(n-1, budget);
        }
        if(candies.get(n).price > budget){
            values[n][budget] = values[n-1][budget];
        }
        else{
            if(values[n-1][budget-candies.get(n).price] == -1){
                maxValue(n-1, budget - candies.get(n).price);
            }
            values[n][budget] = Math.max(values[n-1][budget], values[n-1][budget - candies.get(n).price] + 1);
        }
    }
    public static HashSet<Candy> getCandy(int n, int budget){
        HashSet<Candy> set = new HashSet<>();
        if(n == 0){
            return set;
        }
        if(values[n][budget]>values[n-1][budget]){
            set.add(candies.get(n));
            set.addAll(getCandy(n-1, budget-candies.get(n).price));
            return set;
        }
        else{
            return getCandy(n-1, budget);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("candy.dat"));
        int runs = sc.nextInt();
        for (int i = 0; i < runs; i++) {
            int budget = sc.nextInt(); sc.nextLine(); 
            sc.nextLine();
            String[] names = sc.nextLine().split(" ");
            Scanner q = new Scanner(sc.nextLine());
            Scanner p = new Scanner(sc.nextLine());
            candies = new ArrayList<>();
            for(String n: names){
                int price = p.nextInt();
                for (int j2 = q.nextInt(); j2 > 0 ; j2--) {
                    candies.add(new Candy(n,price));
                }
            }
            values = new int[candies.size()+1][budget+1];
            candies.add(0,null);
            for (int[] row : values) {
                Arrays.fill(row, -1);
            }
            maxValue(candies.size()-1, budget);
            System.out.println(values[candies.size()-1][budget]);
            // HashSet<Candy> candyList = getCandy(candies.size()-1, budget);
            // int total = 0;
            // for (Candy candy : candyList) {
            //     System.out.println(candy);
            //     total+= candy.price;
            // }
            // System.out.println(total);
        }
    }
}
class Candy{
    String name;
    int price;
    public Candy(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return name + " "+ price;   
    }
}