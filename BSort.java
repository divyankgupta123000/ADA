import java.util.*;

class Bsort
{
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter array size: \n");
     int n=sc.nextInt();
     int a[]=new int[n];
     System.out.println("Enter array values: \n");
     for(int i=0;i<n;i++)
       a[i]=sc.nextInt();
     BDemo b=new BDemo();
     b.sort(a,n);
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
       
      System.out.println("\nSorted Array: \n");
      for(i=0;i<n;i++)
         System.out.println(a[i]);
    }
 }


