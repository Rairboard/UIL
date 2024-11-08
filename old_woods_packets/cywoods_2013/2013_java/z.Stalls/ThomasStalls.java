import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class Stalls
{
	int[] tree, lazy;
	/*
	 *int[] tree is a segment tree
	 *int[] lazy keeps track of how many times tree has been added to at a certain node so that you don't have to add to tree until needed
	 *method to add the cows to the nodes not visited yet in tree
	 */
	public void propogate(int curleft, int curright, int node){
		int leftNode = node*2, rightNode = node*2+1, mid = (curleft+curright)/2;
		if(lazy[node]!=0){
			int mult = lazy[node];
			tree[leftNode]+=((mid-curleft)+1)*mult;
			lazy[leftNode]+=lazy[node];
			tree[rightNode]+=((curright-(mid+1))+1)*mult;
			lazy[rightNode]+=lazy[node];
			lazy[node] = 0;
		}
	}	
	/*
	 *adds cows to tree by adding the unadded cows from previous commands and checking to see if the bounds are within the query's requirements
	 */
	public void C(int curleft, int curright, int left, int right, int node)throws Exception{
		if(curright<left||curleft>right)return;
		int leftNode = node*2, rightNode = node*2+1, mid = (curleft+curright)/2;
		propogate(curleft,curright,node);
		if(curleft>=left&&curright<=right){
			tree[node]+=(curright-curleft)+1;
			lazy[node]++;
			return;
		}
		C(curleft,mid,left,right,leftNode);
		C(mid+1,curright,left,right,rightNode);
		tree[node]=tree[leftNode]+tree[rightNode];
	}
	/*
	 *returns how many cows between certain bounds also adding the unadded cows as you visit nodes not yet updated
	 */
	public int I(int curleft, int curright, int left, int right, int node)throws Exception{
		if(curright<left||curleft>right)return 0;
		int leftNode = node*2, rightNode = node*2+1, mid = (curleft+curright)/2;
		propogate(curleft,curright,node);
		if(curleft>=left&&curright<=right){
			return tree[node];
		}
		return I(curleft,mid,left,right,leftNode)+I(mid+1,curright,left,right,rightNode);
	}
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Stalls.dat"));
		int cases = file.nextInt();file.nextLine();
		for(int xx = 0; xx<cases; xx++){
			int N = file.nextInt(), E = file.nextInt();file.nextLine();
			int right = (int)Math.pow(2,Math.floor(Math.log10(N)/Math.log10(2))+1);
			int success = 0;
			tree = new int[right*8+1];
			lazy = new int[right*8+1];
			for(int x = 0 ; x<E; x++){
				String[] command = file.nextLine().split(" ");
				if(command[0].equals("C")){
					C(0,right,Integer.parseInt(command[1]),Integer.parseInt(command[2]),1);
				}
				else{
					success+=(I(0,right,Integer.parseInt(command[1]),Integer.parseInt(command[2]),1)<=Integer.parseInt(command[3])?1:0);
				}
			}
			System.out.println(success);
		}
	}
	public static void main(String[] args)throws Exception
	{
		Stalls a=new Stalls();
		a.run();
	}
}