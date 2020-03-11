import java.util.*;

class Meet 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total no. of meetings: ");
        int n=sc.nextInt();
        int s[]=new int[n];
        int f[]=new int[n];
        int p[]=new int[n];
        System.out.println("Enter start time of meeting: ");
        for(int i=0;i<s.length;i++)
            s[i]=sc.nextInt();
        System.out.println("Enter finish time of meeting: ");
        for(int i=0;i<f.length;i++)
            f[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            p[i]=i+1;
        Meeting m =new Meeting();
        m.sort(s,f,p);
    }
}


class Meeting
{
    void sort(int a[],int b[],int c[])
    {
         int i,j,temp;
         for(i=0;i<b.length-1;i++)    // sorting finish time and placing start time at corresponding indices
         {
             int key=b[i+1];
             int key1=a[i+1];
             int key2=c[i+1];
             for(j=i+1;j>0 && b[j-1]>key;j--)
             {
                 b[j]=b[j-1];
                 a[j]=a[j-1];
                 c[j]=c[j-1];
             }
             b[j]=key;
             a[j]=key1;
             c[j]=key2;
         }
    
      //   for(i=0;i<a.length;i++)
      //     System.out.println(a[i]+"  "+b[i]);
         
         meet(a,b,c);
    }
    
    void meet(int a[],int b[],int c[])
    {
         System.out.println("Possible Meetings are: ");
         System.out.println("Meeting " + c[0]);
         int i=0,count=1; 
         for(int j=i+1;j<a.length;j++)
         {
             if(b[i]<=a[j])
             {
                 i=j;
                 System.out.println("Meeting " + c[i]);
                 count++;
             }
         }
         System.out.println("Total possible meetings are: "+count);
    }
}



 
