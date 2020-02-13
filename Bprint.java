import java.util.*;

class Bprint
{
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter array size: \n");
     int n=sc.nextInt();
     int a[]=new int[n];
     /*System.out.println("Enter array values: \n");
     for(int i=0;i<n;i++)
       a[i]=sc.nextInt();*/
     Random r=new Random();
     for(int i=0;i<a.length;i++)
        a[i]=r.nextInt(8000);
     BDemo b=new BDemo();
     System.out.println("Enter k value: ");
     int k=sc.nextInt(); 
     Date past=new Date();    
     b.sort(a,n);
     Date future=new Date();
     System.out.println("\nTime(ms) = "+ (future.getTime() - past.getTime())+ "\n");
     for(int i=n-1;i>=n-k;i--)
      System.out.print(a[i] + " ");
  }
}

class BDemo
{
    int i,j;
    void sort(int a[],int n)
    {
      for(i=0;i<n-1;i++)
      {
        for(j=0;j<n-1;j++)
        {
           if(a[j]>a[j+1])
           {
             int temp=a[j];
             a[j]=a[j+1];
             a[j+1]=temp;
           }
        }
      }
       
      /*System.out.println("\nSorted Array: \n");
      for(i=0;i<n;i++)
         System.out.print(a[i] + " ");*/
    }
 }


