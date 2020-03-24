import java.util.*;

class DFS 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total no. of vertices: ");
        int v=sc.nextInt();
        int a[][]=new int[v][v];
        System.out.println("Enter adjacency matrix: ");
        for(int i=0;i<v;i++)
        {  
            for(int j=0;j<v;j++)
                a[i][j]=sc.nextInt();
        }
        Traversal t=new Traversal(v);
        t.dfs(a,0);
        if(t.connect==1)
            System.out.println("\nGraph is connected !!!");
        else
            System.out.println("\nGraph is disconnected !!!");
        if(t.c==1)
            System.out.println("Graph is cyclic !!!");
        else
            System.out.println("Graph is acyclic !!!");
    }
}

class Traversal
{
    int stk[],state[],top,p=-1,c=0;
    int i,j,v,connect=1,res,val=0;
    
    Traversal(int n)
    {
        v=n;
        stk=new int[50];
        state=new int[n];
        state[0]=1;
        for(i=1;i<n;i++)
            state[i]=0;
        top=-1; 
        if(n!=0)
           push(1);
    }
    
    void push(int ele)
    {
        stk[++top]=ele;
        disp();
    }
    
    void pop()
    {
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
    
    int checkstate()
    {
        for(int k=0;k<v;k++)
        {
            if(state[k]==0)
            {
                state[k]=1;
                return k;
            }
        }
        return -1;
    }
    
    void dfs(int a[][],int x)
    {
        i=x;
        for(j=0;j<v;) 
        {
           if(a[i][j]==1 && state[j]==0)
           {
                state[j]=1;
                p=i;
                i=j;
                push(j+1);
                c=checkcycle(a);
                j=-1;
           }
           j++;
        }
        pop();
        if(top!=-1)
            i=stk[top]-1;
        if(i==val)
        {
            res=val;
            val=checkstate();
            if(val!=-1)
            {
                i=val;
                if(a[res][val]==0)
                {
                    connect=0;
                    if(top!=-1)
                        pop();
                }
                push(val+1);
            }
            else
                return;
        }
        dfs(a,i);
    }
    
    int checkcycle(int a[][])
    {
        for(int k=0;k<i;k++)
        {
            if(a[i][k]==1 && k!=p)
            { 
                c=1;
                return c;
            }
        }
        return c;
    }
}
