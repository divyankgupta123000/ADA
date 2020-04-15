import java.util.*;
class MinCoin
{
    static int minCoins(int coins[], int m, int V)
    {
        int table[] = new int[V + 1];
        table[0] = 0;
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++)
        {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
            }
        }
        return table[V];

    }

    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of coins");
        int m = s.nextInt();
        System.out.println("Enter the elements");
        int coins[]=new int[m];
        for(int i=0;i<m;i++){
            coins[i] = s.nextInt();
        }
        System.out.println("Enter the total amount");
        int V = s.nextInt();
        System.out.println ( "Minimum coins required is "
                + minCoins(coins, m, V));
    }
} 
