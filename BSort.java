import java.util.*;
class BSort 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size:");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter array values:");
        for(int i=0;i<n;i++)
           a[i]=sc.nextInt();
        BDemo b=new BDemo();
        b.sort(a,n);
        for(int i=0;i<n;i++)
          System.out.println(a[i]);
        
    }
}

class BDemo
{
    void sort(int a[],int n)
    {
        int flag,i,j;
        for(i=0;i<n-1;i++)
        {
            flag=0;
            for(j=0;j<n-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0)
              return;  
        }
    }
}
