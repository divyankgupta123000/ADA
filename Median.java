import java.util.*;

class Median
{
    public static void main(String args[])
    {   
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array1 size: ");
        int n1=sc.nextInt();
        int a1[]=new int[n1];
        System.out.println("Enter array2 size: ");
        int n2=sc.nextInt();
        int a2[]=new int[n2];
        if(n1==n2)
        {
            System.out.println("Enter sorted array1 values: ");
            for(int i=0;i<n1;i++)
                a1[i]=sc.nextInt();
            System.out.println("Enter sorted array2 values: ");
            for(int i=0;i<n2;i++)
                a2[i]=sc.nextInt();
            MedianDemo md=new MedianDemo(n1);
            double res=md.checkmedian(a1,a2);
            System.out.println("Median: " + res);
        }
        else
            System.out.println("Arrays are not of same size!!!");
    }
}

class MedianDemo
{
    int x,n,s1,s2,e1,e2;
    
    MedianDemo(int n)
    {
        s1=s2=0;
        this.n=n;
        e1=e2=n-1;
    }
    
    double getmedian(int a[],int s,int e)
    {
        x=e-s+1;
        if(x%2==0)
            return((a[s+(x/2)]+a[s+(x/2)-1])/2);
        else 
            return(a[s+(x/2)]);
    }
    
    double checkmedian(int a[],int b[])
    {
        double m1=getmedian(a,s1,e1);
        double m2=getmedian(b,s2,e2);
        
        if(e1-s1==1)
        {
            double p,q;
            if(a[s1]>b[s2])
                p=a[s1];
            else
                p=b[s2];
            
            if(a[e1]<b[e2])
                q=a[e1];
            else
                q=b[e2];
            
            return((p+q)/2);
        }
        
        else if(m1==m2)
            return m1;
        
        else if(m1>m2)
        {
            n=n/2;
            e1=s1+n;
            s2=s2+n;
            return(checkmedian(a,b));
        }
        
        else
        {
            n=n/2;
            e2=s2+n;
            s1=s1+n;
            return(checkmedian(a,b));
        }
    }
}
