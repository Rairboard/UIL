import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Delfina
{

	public static class point
	{
		int x,y;

		public point(int x, int y)
		{
			this.x=x;
			this.y=y;
		}

		public boolean equals(point p)
		{
			return this.x==p.x&&this.y==p.y;
		}
	}

	public static class segment
	{
		point p1, p2;

		public segment(point p1, point p2)
		{
			this.p1=p1;
			this.p2=p2;
		}
	}

	public static boolean ccw(point A,point B,point C)
	{
    	return (C.y-A.y) * (B.x-A.x) > (B.y-A.y) * (C.x-A.x);
    }

    public static double distance(point A,point B)
    {
    	return Math.sqrt((A.x-B.x)*(A.x-B.x)+(A.y-B.y)*(A.y-B.y));
    }

    public static boolean pointOnSegment(point A, point B, point C)
    {
    	//determine if point C falls on the segement formed by A and B
 
    	return (distance(A,C)+distance(B,C))==(distance(A,B));
    }

    public static boolean intersect(point A,point B,point C,point D)
    {
    	//This is just a vertex, not an intersection
    	if(A.equals(C)||A.equals(D)||B.equals(C)||B.equals(D))
    		return false;

    	//four cases where overlap could be
    	if(pointOnSegment(A,B,C)||pointOnSegment(A,B,D)||pointOnSegment(C,D,A)||pointOnSegment(C,D,B))
    	{
    		return true;
    	}

    	return ccw(A,C,D) != ccw(B,C,D) && ccw(A,B,C) != ccw(A,B,D);
	}

	public static boolean selfIntersecting(ArrayList<point> polygon)
	{
		ArrayList<segment> edges=new ArrayList<segment>();
		for(int a=1;a<polygon.size();a++)
			edges.add(new segment(polygon.get(a-1),polygon.get(a)));
		
		for(int a=0;a<edges.size();a++)
		{
			segment current=edges.get(a);
			for(int b=0;b<edges.size();b++)
			{
				segment temp=edges.get(b);

				if(intersect(current.p1,current.p2,temp.p1,temp.p2))
					return true;
			}
		}
		return false;
	}

	public static void main (String args[]) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("delfina.dat"));
        
        int N = s.nextInt();
        for ( int n = 0; n < N; n++ )
        {
        	int numVert = s.nextInt();
        	ArrayList<point> polygon=new ArrayList<point>();
       		for(int a=0;a<numVert;a++)
       		{
       			polygon.add(new point(s.nextInt(),s.nextInt()));
       		}
       		polygon.add(polygon.get(0));
       		System.out.println(selfIntersecting(polygon) ? "Self intersecting" : "Simple");
        }
	}
}