import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class liberties {
    private String[][] board;
    private int lives;
    
    public void run() throws FileNotFoundException {
        Scanner file = new Scanner(new File("liberties-judge.dat"));
        
        int n = file.nextInt();
        
        for(int i=0; i <n; i++){
            int r = file.nextInt();
            int c = file.nextInt();
            file.nextLine();
            board = new String[r][c];
            
            for(int j=0; j <r; j++){
                String line = file.nextLine();
                for(int k=0; k <c; k++){
                    board[j][k] = line.substring(k, k+1);
                }
            }
            lives=0;
            for(int g=0; g<r; g++){
            	for(int h=0; h <c; h++){
            		if(board[g][h].equals("W")){
            			if((g==0 || g==r-1) && (h==0 || h==c-1)){
            				if(find(g, h)<2){
            					System.out.println(g+" "+h);
            					lives++;
            				}
            			}
            			else if(g==0 || h==0 || g==r-1 || h==c-1){
            				if(find(g, h)< 3){
            					System.out.println(g+" "+h);
            					lives++;
            				}
            			}
            			else{
            				if(find(g,h)<4){
            					System.out.println(g+" "+h);
            					lives++;
            				}
            			}
            		}
            	}
            }
           
            if(lives==0){
            	System.out.println("NONE");
            }
            System.out.println();
        }
    }

    public int find(int r, int c){
        if(r>=0 && c>=0 && r<board.length && c<board[r].length){
            if(board[r][c].equals("W")){
            	return find(r, c+1)+
            	       find(r, c-1)+
            	       find(r-1, c)+
            	       find(r+1, c);
            }
            else if(board[r][c].equals("B")){
            	return 1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        liberties l = new liberties();
        l.run();
    }
}
