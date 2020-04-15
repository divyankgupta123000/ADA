import java.util.*;
class Kruskal {
    static int c=0;
    static int[][] mat,binmat;
    static ArrayList<Integer> parent = new ArrayList<Integer>();
    static boolean v[];
    static boolean vis[][];
    static int f=0;
    static int num=0;
    static void cycle(int i){
        for(int j=0;j<mat.length;j++){
            if(f==1){
                return;
            }
            if(binmat[i][j] == 1){
                if(v[j] && parent.size()!=0){
                    int z;
                    for(z=0;z<parent.size()-1;z++){
                        if(parent.get(z)==j){
                            f=1;
                            return;
                        }
                    }
                }
                if(parent.size()!=0){
                    if(parent.get(parent.size()-1)==j){
                        continue;
                    }
                }

                if(f==0){
                    parent.add(i);
                    cycle(j);
                    parent.clear();
                }

            }
        }
    }

    static void detcycle(){
        for(int i=0;i<v.length;i++){
            if(f==1)
                return;
            if(v[i]){
                cycle(i);
            }
        }
    }

    static void minSpantree(int max){
        int n = mat.length;
        for(int i=1;i<=max;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(c==0 && mat[j][k] == i && !vis[j][k]){
                        c += mat[j][k];
                        binmat[j][k] = binmat[k][j] = 1;
                        v[j] = v[k] = true;
                        vis[j][k] = vis[k][j] = true;
                        num+=1;
                    }
                    else if(mat[j][k] == i && vis[j][k]==false){
                        binmat[j][k] = binmat[k][j] = 1;
                        v[j] = true;
                        v[k] = true;
                        f=0;
                        if(num==v.length-1){
                            return;
                        }
                        detcycle();
                        if(f==1){
                            binmat[j][k] = binmat[k][j] = -1;
                            v[j] = v[k] = false;
                        }
                        else {
                            vis[j][k] = vis[k][j] = true;
                            c += mat[j][k];
                            num +=1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph");
        int n = s.nextInt();
        System.out.println("Enter the adjacency weighted matrix");
        mat = new int[n][n];
        binmat = new int[n][n];
        v = new boolean[n];
        vis = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = s.nextInt();
                binmat[i][j] = -1;
            }
        }

        int max = mat[0][0];
        for (int arr[] : mat) {
            for (int x : arr) {
                if(x>max){
                    max = x;
                }
            }
        }

        minSpantree(max);
        System.out.println(c);
    }
}
