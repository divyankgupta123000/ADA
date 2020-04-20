import java.util.*;
class Dijkstra {
    static int[][] resmat,mat;
    static boolean[] v;
    static int c = 0;
    static int tot = 0;
    static int x,f = 0;
    static int arr[] = new int[4];
    static void shortestPath(int i){
        if(c==mat.length-1)
            return;
        v[i] = true;
        int small = 10000;
        int smallind = mat.length+1;
        for(int j=0;j<mat.length;j++){
            if(mat[i][j]!=-999 && !v[j]){
                if(resmat[i][j] == -999)
                    resmat[i][j] = 0;
                int temp = tot + mat[i][j];
                if(!(temp<resmat[i][j]))
                    resmat[i][j] +=mat[i][j];
                if(resmat[i][j]<small){
                    small = resmat[i][j];
                    smallind = j;
                }
            }
        }
        tot += mat[i][smallind];
        arr[c] = tot;
        c++;
        shortestPath(smallind);
    }
    static ArrayList<Integer> nums = new ArrayList<>();
    static int val = 0;

    static void givVal(int s, int j){
        if(resmat[s][j]!=-999){
            if(nums.contains(resmat[s][j])){
                int small = 1000;
                for(int i=0;i<nums.size();i++){
                    if(nums.get(i)<small){
                        small = nums.get(i);
                    }
                }
                if(small==resmat[s][j]){
                    val += resmat[s][j];
                    return;
                }
            }
            else
                nums.add(resmat[s][j]);
        }
        x = 0;
        if(f==0){
            x = nums.size();
            for(int i=0;i<mat.length;i++){
                if(resmat[i][j]!=-999){
                    if(!nums.contains(resmat[i][j])){
                        nums.add(resmat[i][j]);
                    }
                }
            }
        }
        if(x==nums.size()){
            val += resmat[0][j];
            return;
        }
        else{
            int small = 1000;
            int smallind = 1000;
            for(int i=0;i<mat.length;i++){
                if(resmat[s][i]<small && resmat[s][i]!=-999){
                    small = resmat[s][i];
                    smallind = i;
                }
            }
            f = 1;
            val += resmat[s][smallind];
            givVal(smallind,j);
        }
    }

    static void print(int i){
        int sum = 0;
        for(int j=0;j<mat.length-1;j++){
            givVal(0,j+1);
            System.out.println((i+1)+" -> "+(j+2)+": "+val);
            val = 0;
            f = 0;
            nums.clear();
        }
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = s.nextInt();
        System.out.println("Enter the weighted matrix, if can't go to a particular vertex give value -999");
        mat = new int[n][n];
        resmat = new int[n][n];
        v = new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = s.nextInt();
                resmat[i][j] = -999;
            }
        }
        shortestPath(0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(resmat[i][j]+"      ");
            }
            System.out.println();
        }
        print(0);
        for(int i=0;i<4;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
