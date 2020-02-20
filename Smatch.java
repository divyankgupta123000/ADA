import java.util.*;

class Smatch
{
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter the test string: ");
     String s1=sc.next();
     System.out.println("Enter the pattern string: ");
     String s2=sc.next();
     SmatchDemo sd=new SmatchDemo();
     int res=sd.stest(s1,s2);
     if (res!=-1)
       System.out.println("Pattern found at" + res+"th position");
     else
       System.out.println("Patter not found!!");
  }
}

class SmatchDemo
{
   int stest(String s1,String s2)
   {
      for(int i=0;i<s1.length()-s2.length();i++)
      {
        for(int j=0;j<s2.length();j++)
        {
           if(s1.charAt(i+j)==s2.charAt(j))
             j++;
           else
             break;
        }
        if(int j==s2.length())
          return i;
     }
     return -1;
  }

}


