import java.util.*;
class TaskPrerequisite {
    static int n,f=0;
    static ArrayList<Integer> order = new ArrayList<>();
    static int count(boolean v[][]){
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                if(v[i][j]){
                    c++;
                }
            }
        }
        return c;
    }

    static int findInd(boolean[][] v,ArrayList<Integer> col2,int key){
        int ind=0;
        for(int i=0;i<n;i++){
            if(!v[i][0] && key== col2.get(i)){
                ind = i;
            }
        }
        return ind;
    }

    static int find(boolean[][] v,ArrayList<Integer> col1, ArrayList<Integer> col2){
        int ind=-1;
        for(int i=0;i<n;i++){
            if(!v[i][0] && v[i][1] && !order.contains(col1.get(i))){
                ind = i;
            }
        }
        return ind;
    }

    static void check(ArrayList<Integer> col1, ArrayList<Integer> col2){
        boolean v[][] = new boolean[col1.size()][2];
        int i=0;
        for(;i<col1.size();i++){
            if(!col1.contains(col2.get(i))){
                v[i][1] = true;
                break;
            }
        }
        if(i==col1.size()){
            f=1;
            return;
        }
        int j=0;
        int key = col1.get(i);
        order.add(0);
        while(count(v)!=col1.size()*2){
            if(j==0){
                int temp = findInd(v,col2,key);
                v[i][0] = true;
                v[temp][1] = true;
                order.add(col1.get(i));
                j=1;
            }
            else{
                int temp = find(v,col1,col2);
                if(temp==-1){
                    f=1;
                    return;
                }
                key = col1.get(temp);
                if(count(v)==(col1.size()*2)-1){
                    v[temp][0] = true;
                    order.add(col1.get(temp));
                }
                else{
                    int temp2 = findInd(v,col2,key);
                    v[temp][0] = true;
                    v[temp2][1] = true;
                    order.add(col1.get(temp));
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of tasks");
        n = s.nextInt();
        int pre[][] = new int[n][2];
        System.out.println("Enter the prerequisite pairs");
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                pre[i][j] = s.nextInt();
            }
        }
        ArrayList<Integer>  col1 = new ArrayList<>();
        ArrayList<Integer>  col2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            col1.add(pre[i][0]);
            col2.add(pre[i][1]);
        }
        check(col1,col2);
        if(f==1){
            System.out.println("Not Possible");
        }
        else{
            for(int i=0;i<order.size();i++){
                System.out.println();
                System.out.print(order.get(i)+" ");
            }
        }
    }
}
