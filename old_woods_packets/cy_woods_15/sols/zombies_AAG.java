import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class zombies_AAG {
	char[][] map;
	char[] mapAy;
	int[] mapAz;
	private int longh;
	
    public void run() throws FileNotFoundException{
    	Scanner file=new Scanner(new File("zombiesj.dat"));
    	int n=file.nextInt();
    	for(int i=0; i<n; i++){
    		int rows=file.nextInt();
    		int cols=file.nextInt();
    		file.nextLine();
    		map=new char[rows][cols];
    		longh=0;
    		for(int r=0; r<rows; r++){
    			String line=file.nextLine();
    			for(int c=0; c<line.length(); c++){
    				map[r][c]=line.charAt(c);
    				if(map[r][c]!='#'){
    					longh++;
    				}
    			}
    		}
    		mapAy=new char[longh];
    		mapAz=new int[longh];
    		Arrays.fill(mapAz, 0);
    		for(int r=0; r<rows; r++){
    			for(int c=0; c<cols; c++){
    				if(map[r][c]=='@')
    					toArr(r,c,0);
    			}
    		}
    		int aInd=index('@');
    		int block=0;
    		int day=1;
    		while(block < mapAy.length-1){
    			if(mapAz[block]>0){
    				System.out.println("Day "+day+": Block "+block);
    				mapAz[block]=mapAz[block]-1;
    			}
    			else{
    				block++;
    				aInd=index('@');
    				mapAy[aInd+1]='@';
    				mapAy[aInd]='-';
    			}
    					
    			for(int l=1; l<mapAy.length; l++){
    				if(l!=block){
    						mapAz[l-1]+=mapAz[l];
    						mapAz[l]=0;
    				}
    			}
    			day++;
    		}
    		day--;
    		System.out.println("Day "+day+": Exit");
    		System.out.println();
    	}
    }
    
    public int index(char c){
    	int index=0;
    	for(char ct : mapAy){
    		if(ct==c)
    			return index;
    		else
    			index++;
    	}
    	return -1;
    }
    
    public void toArr(int r, int c, int dex){
    	if(r>=0 && c>=0 && r<map.length && c<map[r].length
    		&& map[r][c]!='#'){
    		if(map[r][c]!='E' && map[r][c]!='@' && map[r][c]!='-'){
    			mapAz[dex]=Character.getNumericValue(map[r][c]);
    			mapAy[dex]='-';
    		}else{
    			mapAz[dex]=0;			
    			mapAy[dex]=map[r][c];
    		}
    		map[r][c]='#';
    		toArr(r+1, c, dex+1);
    		toArr(r-1, c, dex+1);
    		toArr(r, c+1, dex+1);
    		toArr(r, c-1, dex+1);
    	}
    }
    
    public static void main(String[] args) throws FileNotFoundException{
    	new zombies_AAG().run();
    }
}