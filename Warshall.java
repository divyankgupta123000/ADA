import java.util.*;
class Warshall {

    static int v;
    static boolean tc[][];

    static void TC(int ad[][]){
        v=ad.length;
        tc=new boolean[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(ad[i][j]!=0){
                    tc[i][j]=true;
                }
                tc[i][i]=true;
            }
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(tc[j][i]){
                    for(int k=0;k<v;k++){
                        if(tc[j][i] && tc[i][k])
                            tc[j][k]=true;
                    }
                }
            }
        }
    }
    static void display(){
        System.out.println("Transitive closure is-->");
        System.out.println();
        for(int j=0;j<v;j++){
            for(int k=0;k<v;k++){
                if(tc[j][k]){
                    System.out.print("   1   ");
                }
                else
                    System.out.print("  INF  ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("ENter the number of vertices");
        int n=s.nextInt();
        System.out.println("Enter the adjacency matrix");
        int ad[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ad[i][j]=s.nextInt();
            }
        }
        TC(ad);
        display();
    }
}
