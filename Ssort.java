import java.util.*;

class Ssort
{
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter array size: \n");
     int n=sc.nextInt();
     System.out.println("Enter no. of largest values : \n");
     int k=sc.nextInt();
     int a[]=new int[n];
     /*System.out.println("Enter array values: \n");
     for(int i=0;i<n;i++)
       a[i]=sc.nextInt();*/
     Random r=new Random();
     for(int i=0;i<a.length;i++)
        a[i]=r.nextInt(8000);
     SDemo s=new SDemo();
     Date past=new Date();
     s.sort(a,n);
     Date future=new Date();
     System.out.println("\nTime(ms) = "+ (future.getTime() - past.getTime()));
     System.out.println("\n"+k + "Largest Elements are :\n");
     for(int i=n-1;i>=n-k;i--)
       System.out.print(a[i] + " ");
  }
}

class SDemo
{
    int i,j,min;
    void sort(int a[],int n)
    {
      for(i=0;i<n-1;i++)
      {
        min=i;
        for(j=i+1;j<n;j++)
        {
           if(a[min]>a[j])
           {
              min=j;
           }
        }
        int temp=a[min];
        a[min]=a[i];
        a[i]=temp; 
      }
    }
 }


