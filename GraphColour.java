import java.util.*;
class GraphColour
{
    static int m;
    static int[][] arr;
    static int c = 0;
    static int[] color;

    static int maximum(int[] color){
        int l = 0;
        for(int i=0;i<color.length;i++){
            if(color[i]>l){
                l = color[i];
            }
        }
        return l;
    }

    static boolean isPresent(int key, ArrayList<Integer> clrs){
        for(int i=0;i<clrs.size();i++){
            if(clrs.get(i)==key){
                return true;
            }
        }
        return false;
    }

    static void colorTheGraph(int x){
        if(x==0){
            color[x] = 1;
            return;
        }
        ArrayList<Integer> clrs = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i][x]==1){
                if(color[i]!=-1){
                    clrs.add(color[i]);
                }
            }
        }
        int max = maximum(color);
        if(max==1){
            color[x] = 2;
            return;
        }
        int i=0;
        for(;i<color.length;i++){
            if(color[i]!=-1){
                if(!isPresent(color[i], clrs)){
                    color[x] = color[i];
                    break;
                }
            }
        }
        if(i==color.length){
            color[x] = max+1;
        }
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = s.nextInt();
        arr = new int[n][n];
        color = new int[n];
        System.out.println("Enter the adjacency matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = s.nextInt();
            }
            color[i] = -1;
        }
        System.out.println("Enter the maximum number of colors");
        m = s.nextInt();
        for(int i=0;i<n;i++){
            colorTheGraph(i);
        }
        if(maximum(color)>m){
            System.out.println("Not Possible");
        }
        else{
            System.out.println("Possible");
        }
    }
}
