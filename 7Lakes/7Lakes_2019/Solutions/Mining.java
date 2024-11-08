import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MiningAway {
    static boolean[][] visited;
    static int[][] val;
    final static int[] dx = {-1,0,1,0};
    final static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("mining.in"));
        int casess = in.nextInt();
        in.nextLine();
        for(int cases = 0; cases < casess; cases++){
            int height = in.nextInt();
            int width = in.nextInt();
            in.nextLine();
            int torches = in.nextInt();
            in.nextLine();
            char[][] mat = new char[height][width];
            visited = new boolean[height][width];
            val = new int[height][width];
            int sx = 0;
            int sy = 0;
            int ex = 0;
            int ey = 0;
            for(int h = 0; h<height; h++){
                String s = in.nextLine();
                if(s.contains("S")){
                    sx = h;
                    sy = s.indexOf("S");
                }
                if(s.contains("E")){
                    ex = h;
                    ey = s.indexOf("E");
                }
                char[] ss = s.toCharArray();
                for(int i = 0; i<width; i++){
                    mat[h][i] = ss[i];
                }
            }
 //           System.out.println(Arrays.deepToString(mat).replaceAll("\\]", "\n"));
            fill(mat, sx, sy, 1);
            if(val[ex][ey]==0)
                System.out.println("Don't Mine At Night!");
            else
                System.out.println(torches*6>=val[ex][ey]?"Take Back The Night!":"Don't Mine At Night!");
//            System.out.println(val[ex][ey]);
        }
    }
    public static void fill(char[][] mat, int x, int y, int value){
        if(visited[x][y] || mat[x][y] == '#'){
            return;
        }
        visited[x][y] = true;
        val[x][y]=value;
//        System.out.println(Arrays.deepToString(val).replaceAll("\\]", "\n"));
        for(int i = 0; i<4; i++){
            try{
                fill(mat, x+dx[i], y+dy[i], value+1);
            }catch(Exception e){}
        }
    }

}
