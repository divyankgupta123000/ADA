import java.util.*;

class ISort
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter array size:");
    int n=sc.nextInt();
    int a[]=new int[n];
    Random r=new Random();
    for(int i=0;i<n;i++)
     a[i]=r.nextInt(1000);
    IDemo i=new IDemo();
    Date dp=new Date();
    i.isort(a);
    Date df=new Date();
    System.out.println("\nTime(ms) = "+ (df.getTime() - dp.getTime()));
    System.out.println("Sorted Array:\n");
    for(int j=0;j<a.length;j++)
      System.out.print(a[j] + " ");
  }
} 


class IDemo
{
  void isort(int a[])
  {
     int i;
     for(int j=1;j<a.length;j++)
     {
       int key=a[j];
       for(i=j-1;i>=0 && key<a[i];i--)
           a[i+1]=a[i];
       a[i+1]=key;    
     }
  }
}     
