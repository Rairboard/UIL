//UIL 2018 - Region - Emily
import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Emily {

	public static void main(String[] args) throws IOException
	{
		Scanner f=new Scanner(new File("emily.dat"));
		int N = f.nextInt();
		char[][]g=new char[N][N];
		for(int r=0;r<N;r++)
		for(int c=0;c<N;c++)
			g[r][c]=f.next().charAt(0);
		while(f.hasNext())
		{
			String s = f.next();
			out.println("<"+s+">");
			char[]a=s.toCharArray();
			boolean flag = false;

//			out.println("search northward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=r, i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[p][c]){
							i++;
							p=(p-1+N)%N;
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") N");
						flag=true;
					}
				}
			}
//			out.println("search northeastward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=r,q=c,i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[p][q]){
							i++;
							p=(p-1+N)%N;//up a row
							q=(q+1)%N;//one col to right
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") NE");
						flag=true;
					}
				}
			}
//			out.println("search eastward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=c, i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[r][p]){
							i++;
							p=(p+1)%N;
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") E");
						flag=true;
					}
				}
			}
//			out.println("search southeastward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=r,q=c,i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[p][q]){
							i++;
							p=(p+1)%N;//down a row
							q=(q+1)%N;//one col to right
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") SE");
						flag=true;
					}

				}
			}
//			out.println("search southward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=r, i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[p][c]){
							i++;
							p=(p+1)%N;
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") S");
						flag=true;
					}

				}
			}
//			out.println("search southwestward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=r,q=c,i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[p][q]){
							i++;
							p=(p+1)%N;//down a row
							q=(q-1+N)%N;//one col to left
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") SW");
						flag=true;
					}
				}
			}
//			out.println("search westward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=c, i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[r][p]){
							i++;
							p=(p-1+N)%N;
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") W");
						flag=true;
					}
				}
			}
//			out.println("search northwestward");
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					int p=r,q=c,i=0;
					boolean found = true;
					while(i<a.length&&found)
						if(a[i]==g[p][q]){
							i++;
							p=(p-1+N)%N;//up a row
							q=(q-1+N)%N;//one col to left
						}
						else found = false;
					if(found){
						out.println("("+(r+1)+","+(c+1)+") NW");
						flag=true;
					}
				}
			}
			if(!flag)
				out.println("NOT FOUND");
		}
	}
}
