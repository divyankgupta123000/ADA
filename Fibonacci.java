import java.util.*;
class Fibonacci 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of n: ");
        int n=sc.nextInt();
        Fibo f=new Fibo();
        int num=f.fib(n);
        System.out.println("nth Fibonacci number: "+num);
         
    }
}

class Fibo
{
    int n;
    int fib(int n)
    {
        this.n=n;
        if(n==1)
            return 0;
        else if(n==2)
            return 1;
        else
        {
            return(fib(n-1)+fib(n-2));
        }
    }
}