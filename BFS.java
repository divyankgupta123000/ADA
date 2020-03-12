import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
	static int ar[][];
	static boolean v[];
	static  LinkedList<Integer> l = new LinkedList<Integer>();
	static int f=0;
	public static int[] getAdj(int v)
	{
		return ar[v];
	}
	public static void main(String a[])
	{
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		ar=new int[n][n];
		v=new boolean[n];
		System.out.println("Enter matrix");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				ar[i][j]=x.nextInt();
		}
		for(int i=0;i<n;i++)
			v[i]=false;
		bfs(2);

}
	public static void bfs(int i)
	{
		l.add(i);
		v[i]=true;
		while(l.size()!=0)
		{
			i=l.poll();
			System.out.println(i);
			for(int j=0;j<v.length;j++)
			{
				if(!v[j]&&ar[i][j]==1)
				{
					l.add(j);
					v[j]=true;
				}
			}
		}
		
	}
}