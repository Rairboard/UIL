import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

public class Old {
    public static void main(String[]args)throws Exception{
        new Old().run();
    }
    
    int[][][]smat;
    char[][]mat;

    public void run()throws Exception{
        Scanner file=new Scanner(new File("old.dat"));
        int times=file.nextInt();
        file.nextLine();
        while(times-->0){
            int r = file.nextInt(), c = file.nextInt(), s = file.nextInt(), o = file.nextInt();
            file.nextLine();
            mat = new char[r][c];
            smat = new int[o+1][r][c];
            int sr = -1, sc = -1, er = 0, ec = 0;
            for(int i = 0; i < r; i++){
                mat[i] = file.nextLine().trim().toCharArray();
                for(int oo = 0; oo < o + 1; oo++)
                    Arrays.fill(smat[oo][i], Integer.MAX_VALUE);
                for(int j = 0; j < c; j++){
                    if(mat[i][j] == '?'){
                        sr = er = i;
                        sc = ec = j;
                    }
                }
            }
            solve(0, sr, sc, 0);
            //System.out.println(smat[o][er][ec]);
            System.out.println(smat[o][er][ec] <= s?"Olds Collected.":"Time Runs Out.");
        }
    }
    public void solve(int level, int r, int c, int s){
        if(r < 0 || c < 0 || r >=mat.length || c >= mat[r].length || level >= smat.length 
        || level < 0|| mat[r][c] == '#' || smat[level][r][c] <= s) return;
        smat[level][r][c] = s++;
        if(mat[r][c] == (char)('A'+level)){
            level++;
            smat[level][r][c] = s-1;
        }
        if(mat[r][c] == '@') s++;
        solve(level, r + 1, c, s);
        solve(level, r - 1, c, s);
        solve(level, r, c + 1, s);
        solve(level, r, c - 1, s);
    }
}
