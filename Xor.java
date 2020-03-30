import java.util.*;
class Xor {
    static int x,y=0,i=0,j=0;
    static void genMat(int n,int a[][]) {
        if(x==0){
            return;
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                a[i][j]=y;
                y++;
            }
        }
        x--;
        genMat(n,a);
    }

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=s.nextInt();
        int a[][]=new int[n][n];
        x=n;
        genMat(n,a);
        for(int m=0;m<n;m++){
            for(int l=0;l<n;l++){
                System.out.print(a[m][l]+" ");
            }
            System.out.println();
        }
    }
}
