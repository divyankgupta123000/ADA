import java.util.*;

class RecBsearch 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n=sc.nextInt();
        int a[]=new int[n];
        /*Random r=new Random();
        for(int i=0;i<n;i++)
            a[i]=r.nextInt(5);*/
        System.out.println("Enter array values: \n");
        for(int i=0;i<n;i++)
          a[i]=sc.nextInt();
        System.out.println("Enter key value: ");
        int k=sc.nextInt();
        RecBDemo rb=new RecBDemo();
        Date dp=new Date();
        int res=rb.rsearch(a,0,n-1,k);
        Date df=new Date();
        System.out.println("Time(ms)= " + (df.getTime()-dp.getTime()));
        if(res==-1)
            System.out.println("Key not Found!!!");
        else
            System.out.println("Key Found at position "+res);
    }
}

class RecBDemo
{
    int first,mid,last;
    
    int rsearch(int a[],int f,int l,int k)
    {
        mid=(f+l)/2;
        int v=-1;
        if(f>l)
            return -1;
        else if(a[mid]==k)
            return(mid+1);
        else if(a[mid]<k)
            v=rsearch(a,mid+1,l,k);
        else if(a[mid]>k)
            v=rsearch(a,f,mid-1,k);
        return v;
    }
}

