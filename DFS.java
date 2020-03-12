import java.util.*;
public class DFS {
	static int ar[][];
	static boolean v[];
	//static ArrayList<Integer> l=new ArrayList<>();
	static int f=0;
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
		dfs(0);
 
		int c=0,p=0;
		for(int i=0;i<n;i++) {
			c=0;
			for(int j=0;j<n;j++) {
				if(ar[i][j]==0) c++;
			}
			if(c==n) {
				p=1;
				break;
			}
		}
		if(p==1) {
			System.out.println("disconnected");
		}
		else System.out.println("connected");
		
	}
	
	public static void dfs(int i)
	{
		int j;
		System.out.println(i);
		v[i]=true;
		for(j=0;j<v.length;j++)
		{
	                   if(!v[j]&&ar[i][j]==1)
		            dfs(j);
		      
		}
		
		
	}

}