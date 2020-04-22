import java.util.*;
class RodCut
{
    static int prices[];
    static int PriceMat[][];
    static int total[];

    static int calcMax(){

        for(int i=0;i<prices.length;i++){
            int f = 0;
            for(int j=0;j<prices.length;j++){
                int price = ((i+1) * prices[j]);
                int temp;
                if((j!=0 && i!=prices.length-1) || j!=prices.length-1)
                    temp = prices.length - ((i+1) * (j+1)) - 1;
                else
                    temp = prices.length - ((i+1) * (j+1));
                if(temp<0){
                    PriceMat[i][j] = -1;
                }
                else{
                    PriceMat[i][j] = price + prices[temp];
                }
                if((i==prices.length-1 && j==0) || (i==0 && j==prices.length-1)){
                    PriceMat[i][j] = (i+1) * prices[j];
                }
            }
        }
        int max = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<prices.length;j++){
                if(PriceMat[i][j] > max){
                    max = PriceMat[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the longest length of the rod");
        int n = s.nextInt();
        System.out.println("Enter the prices for each length");
        prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = s.nextInt();
        }
        PriceMat = new int[n][n];
        total = new int[n];
        int Max = calcMax();
        System.out.println("Maximum value is "+Max);
    }
}
