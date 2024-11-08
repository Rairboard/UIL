//UIL District 2019 Solution
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Luciano {

    public static void swap(String items[], int A, int B)
    {
        String temp = items[A];
        items[A] = items[B];
        items[B] = temp;
    }
    public static void BubbleSort(String items[])
    {
        for (int i = 0; i < 10; i++) {
            for (int j = items.length-1; j >0; j--) {
                if(items[j].compareTo(items[j-1])<0)
                {
                    swap(items,j,j-1);
                }
            }
        }
    }
    
      
    
    public static void SelectionSort(String items[])
    {
        for (int i = 0; i < 10; i++) {
            int small = i;
            for (int j = i+1; j < items.length; j++) {
                if(items[small].compareTo(items[j])>0)
                {
                    small = j;
                }
            }
            swap(items,small,i);
        }
    }
    public static void main(String[] args) throws IOException{
            Scanner file = new Scanner(new File("luciano.dat"));
            int n = file.nextInt();
            file.nextLine();
            String items[] = new String[n];
            String items2[] = new String[n];
            for (int i = 0; i < n; i++) {
                items[i] = file.nextLine();
                items2[i] = items[i];
            }
            SelectionSort(items);
            BubbleSort(items2);
            
            
            System.out.printf("%-20s:%-20s\n","Selection Sort","Bubble Sort");
            for (int i = 0; i < items2.length; i++) {
                System.out.printf("%-20s:%-20s\n",items[i],items2[i]);
                
        }
    }
}
