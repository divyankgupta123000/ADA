import java.util.*;

class Prims {
    static int c = 0;
    static boolean v[];
    static int rem[][];
    static int top = -1;
    static int num = 0;

    static void mst(int[][] mat,int s){
        num++;
        int n=mat.length;
        if(num>=n)
            return;

        int small = 1000;
        int smallind = 1000;
        int ind = 1000;
        for(int i=0;i<n;i++){
            if(mat[s][i]<small && !v[i]){
                small = mat[s][i];
                ind = i;
            }
        }
        for(int i=0;i<n;i++){
            if(mat[s][i]!=999 && mat[s][i]!=small && !v[i]){
                if(top==-1){
                    top++;
                    rem[top][0] = s;
                    rem[top][1] = i;
                }
                else{
                    int temp = top;
                    int f=0;
                    for(int j=0;j<=temp;j++){
                        if(rem[j][1]==i){
                            rem[j][0] = s;
                            f=1;
                            break;
                        }
                    }
                    if(f==0){
                        top++;
                        rem[top][0] = s;
                        rem[top][1] =i;
                    }
                }
            }
        }
        for(int i=0;i<=top;i++){
            if(rem[i][0]!=999 && rem[i][1]!=999){
                if(mat[rem[i][0]][rem[i][1]]<small && !v[rem[i][1]] && s!=rem[i][1]){
                    small = mat[rem[i][0]][rem[i][1]];
                    smallind = i;
                }
            }
        }
        if(smallind==1000){
            v[s] = true;
            c += mat[s][ind];
            mst(mat,ind);

        }
        else{
            v[s] = true;
            c += mat[rem[smallind][0]][rem[smallind][1]];
            rem[smallind][0] = 999;
            rem[smallind][1] = 999;
            mst(mat,rem[smallind][0]);
        }


    }

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n=s.nextInt();
        System.out.println("Enter the adjacency weighted matrix");
        int mat[][]=new int[n][n];
        v = new boolean[n];
        rem = new int[n*n][2];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = s.nextInt();
            }
        }
        mst(mat,0);
        System.out.println("Minimal cost: "+c);
    }
}
