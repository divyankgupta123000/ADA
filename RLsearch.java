import java.util.*;

class RLsearch 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter array values: \n");
        for(int i=0;i<n;i++)
          a[i]=sc.nextInt();
        System.out.println("Enter key value: ");
        int k=sc.nextInt();
        RecLDemo rl=new RecLDemo();
        Date dp=new Date();
        int res=rl.rsearch(a,0,n,k);
        Date df=new Date();
        System.out.println("Time(ms)= " + (df.getTime()-dp.getTime()));
        if(res==-1)
            System.out.println("Key not Found!!!");
        else
            System.out.println("Key Found at position "+res);
    }
}

class RecLDemo
{
    int rsearch(int a[],int i,int n,int k)
    {
        int v;
        if(i==n)
            return -1;
        else if(a[i]==k) 
            return(i+1);
        else
            v=rsearch(a,i+1,n,k);
        return v;
    }           
}
