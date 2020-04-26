import java.util.*;

class Depth
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Total Vertices:-");
        int v=sc.nextInt();
        System.out.println("Enter Adjacency Matrix:-");
        int arr[][]=new int[v][v];
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter Starting Vertex:-");
        int start=sc.nextInt();
        int state[]=new int[v];
        for(int i=0;i<v;i++)
            state[i]=0;
        DDemo d= new DDemo(v);
        int connect=0;
        System.out.print("Traversal Order:- ");
        d.dfs(arr,state,start-1,-1);
        int i=start%v;
        for(;i!=start-1;i=(i+1)%v)
        {
            if(state[i]==0)
            {
                connect=-1;
                d.dfs(arr,state,i,-1);
            }
        }
        if(connect==0)
            System.out.println("\nGraph is connected!!!");
        else
            System.out.println("\nGraph is disconnected!!!");
        if(d.cycle==0)
            System.out.println("Graph is cyclic!!!");
        else
            System.out.println("Graph is acyclic!!!");
    }
}

class DDemo
{
    int n,cycle=-1,top=-1;
    int stk[];
    DDemo(int v)
    {
        n=v;
        stk=new int[n];
    }
    void dfs(int a[][],int state[],int vno,int parent)
    {
        //System.out.print(vno+1+" ");
        push(vno+1);
        state[vno]=1;
        for(int i=0;i<n;i++)
        {
            if(parent!=-1)
            {
                if(a[vno][i]==1 && state[i]==1 && i!=parent)
                    cycle=0;
            }
            if(a[vno][i]==1 && state[i]==0)
                dfs(a,state,i,vno);
        }
        pop();
    }
    void push(int ele)
    {
        stk[++top]=ele;
        disp();
    }
    void pop()
    {
       if(top!=-1)
           top--;
    }
    void disp()
    {
        if(top==-1)
                System.out.println("Stack is Empty!!!");
        else
        {
                System.out.print(stk[top]+" ");
        }
    }
}
