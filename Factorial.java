import java.util.*;

class Factorial 
{
    public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter n value:");
       int n=sc.nextInt();
       FDemo f=new FDemo();
       int res=f.fact(n);
       System.out.println(n+"! = "+res);
    }
}

class FDemo
{
    int fact(int n)
    {
        if(n==0)
            return 1;
        else
            return(n*fact(n-1));
    }
}