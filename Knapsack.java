import java.util.Scanner;

class Knapsack
{

    static int max(int a, int b) { return (a > b)? a : b; }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        if (n == 0 || W == 0)
            return 0;
        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1);
        else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                knapSack(W, wt, val, n-1)
        );
    }

    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of items");
        int n = s.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        System.out.println("Enter the values/profit");
        for(int i=0;i<n;i++){
            val[i]=s.nextInt();
        }
        System.out.println("Enter the weights");
        for(int i=0;i<n;i++){
            wt[i]=s.nextInt();
        }
        System.out.println("Enter the capacity");
        int W = s.nextInt();
        System.out.println(knapSack(W, wt, val, n));
    }
}
