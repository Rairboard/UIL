import java.util.*;
import java.io.*;
 
public class SevenStroudArmy {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
 
        int sets = sc.nextInt();
        for(int x = 0; x < sets; x++) {
            int num = sc.nextInt();
            sc.nextLine();
 
            String[][] people = new String[num][4];
            for(int y = 0; y < num; y++) {
                people[y] = sc.nextLine().split(" ");
            }
 
            //System.out.println("Initial " + Arrays.deepToString(people));
           
            people = removeSpies(people);
            //System.out.println("Without Spies " + Arrays.deepToString(people));
            people = keepPeasants(people);
            //System.out.println("Only Peasants " + Arrays.deepToString(people));
            people = age(people);
            //System.out.println("Fit Age " + Arrays.deepToString(people));
            alphabetical(people);
        }
    }
 
    public static String[][] removeSpies(String[][] people) {
        ArrayList<Integer> toRemove = new ArrayList<>();
 
        for(int x = 0; x < people.length; x++) {
            String first = people[x][0].toUpperCase();
            String last = people[x][1].toUpperCase();
 
            if(hasStroud(first, 0) || hasStroud(last, 0)) {
                toRemove.add(x);
            }
        }
 
        return getNewList(people, toRemove);
    }
    public static boolean hasStroud(String name, int point) {
        String[] key = "STROUD".split("");
       
        if(point > key.length - 2) { return true; }
        if(name.indexOf(key[point]) < name.indexOf(key[point + 1], name.indexOf(key[point]))) {
            return hasStroud(name, point + 1);
        }
 
        return false;
    }
    public static String[][] keepPeasants(String[][] people) {
        ArrayList<Integer> toRemove = new ArrayList<>();
        String peasant = "Peasant";
 
        for(int x = 0; x < people.length; x++) {
            if(!people[x][2].equals(peasant)) {
                toRemove.add(x);
            }
        }
 
        return getNewList(people, toRemove);
    }
    public static String[][] age(String[][] people) {
 
        ArrayList<Integer> toRemove = new ArrayList<>();
        int bestDifference = Integer.MAX_VALUE, bestAge = 25;
 
        for(int x = 0; x < people.length; x++) { //find best age gap
            int age = Integer.parseInt(people[x][3]);
            if(age > 60 || age < 21) {
                toRemove.add(x);
            }
            else if(Math.abs(bestAge - age) < Math.abs(bestDifference)) {
                bestDifference = Math.abs(bestAge - age);
            }
        }
 
        String[][] legalAge = getNewList(people, toRemove);
        toRemove = new ArrayList<>();

        boolean younger = false;
        for(int x = 0; x < legalAge.length; x++) { //determine if the gap is from younger or older
            int age = Integer.parseInt(legalAge[x][3]);
            if(bestAge - age > bestDifference) {
                younger = true;
            }
        }

        //System.out.println(bestDifference);
        for(int x = 0; x < legalAge.length; x++) { //remove all but best age
            int age = Integer.parseInt(legalAge[x][3]);
            if(younger) {
                if(bestAge - age != bestDifference) {
                    toRemove.add(x);
                }
            }
            else {
                if(Math.abs(bestAge - age) != bestDifference) {
                    toRemove.add(x);
                }
            }
        }
 
        return getNewList(legalAge, toRemove);
    }
    public static String[][] getNewList(String[][] people, ArrayList<Integer> toRemove) {
        if(toRemove.size() == 0) { return people; }
        String[][] newList = new String[people.length - toRemove.size()][4];
 
        int lastPos = 0;
        for(int x = 0; x < people.length; x++) {
            if(toRemove.size() > 0 && x == toRemove.get(0)) {
                toRemove.remove(0);
            }
            else {
                newList[lastPos++] = people[x];
            }
        }
 
        return newList;
    }
    public static void alphabetical(String[][] people) {
        if(people.length < 1) {
            //System.out.println("There are no fit candidates.");
            return;
        }
 
        ArrayList<String> allFit = new ArrayList<>();
        for(String[] person: people) {
            allFit.add(person[1] + " " + person[0]);
        }
 
        Collections.sort(allFit);
        String[] finalist = allFit.get(0).split(" ");
        System.out.println(finalist[1] + " " + finalist[0]);
    }
 
}