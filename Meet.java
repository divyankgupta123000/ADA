import java.util.*;

class Meet
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Total no. of desired meetings:");
    int n=sc.nextInt();
    int s[]=new int[n];
    int f[]=new int[n];
    System.out.println("Enter Start Time of Meeting:");
    for(int i=0;i<n;i++)
     s[i]=sc.nextInt();
    System.out.println("Enter Finish Time of Meeting:");
    for(int i=0;i<n;i++)
     f[i]=sc.nextInt();
    MeetDemo md=new MeetDemo();
    md.meeting(s,f);
  }
}


class MeetDemo
{
  int i,small,j=1,count=1;

  void meeting(int a[],int b[])
  {
    System.out.println("possible Meetings are:");
    int smallest=min(a);
    int k=i-1;  
    System.out.println("Meeting " + k);
    do
    {
      int comp=b[i-1];
      small=9999;
      smallest=min(a);
      if(smallest>comp)
       {
         count++;
         k=i-1;
         System.out.println("Meeting " + k);
       }
      j++;
    }while(j<a.length);
    System.out.println("total Meetings " + count);
  }

  int min(int a[])
  {
     small=a[0];
      for(int i=1;i<a.length;i++)
      {
        if(small>a[i])
          small=a[i];
      }
     return small;
  }

}




 
