
import java.io.File;
import java.util.Scanner;


public class Jordan {
    public static void findTarget(long num1, long num2, long target)
    {

        int index = 2;
        while (num2 < target) {
            index++;
            long next = num1 + num2;
            num1 = num2;
            num2 = next;
           
        }
//        System.out.println("|"+num2+"|"+target);
        if(num2 == target)
            System.out.println(index);
        else
            System.out.println(Long.toString(num1, 17).toUpperCase() + " " + Long.toString(num2, 17).toUpperCase() );
    }

    public static void main(String[] args) throws Exception
    {

            Scanner input = new Scanner(new File("jordan.dat"));
            int datasets = Integer.parseInt(input.nextLine().trim());
            for (int i = 0; i < datasets; i++) {
                long num1 = Long.parseLong(input.next(), 17);
                long num2 = Long.parseLong(input.next(), 17);
                long target = Long.parseLong(input.next(), 17);
                findTarget(num1,num2,target);
        }
    }
}
