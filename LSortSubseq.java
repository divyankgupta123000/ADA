import java.util.*;
class LSortSubseq{
    static ArrayList<Integer> lis = new ArrayList<>();
    static ArrayList<Integer> start = new ArrayList<>();
    static int arr[];
    static int max(){
        int max = -1;
        for(int i=0;i<lis.size();i++){
            if(lis.get(i)>max){
                max = lis.get(i);
            }
        }
        return max;
    }

    static void print(int i){
        int st = start.get(i);
        int c = lis.get(i);
        System.out.println("-----------------------------------------------------");
        for(int j=0;j<=c;j++){
            System.out.print(arr[st+j]+" ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = s.nextInt();
        System.out.println("Enter the elements");
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        int c = 0,st = -1,f = 1;

        for(int i=0;i<n-1;i++){
            if(arr[i]<arr[i+1]){
                c++;
            }
            else{
                if(c!=0){
                    lis.add(c);
                    start.add(st);
                }
                c=0;
                f = 0;
            }
            if(c==1){
                st = i;
            }
            if(i==n-2){
                if(c>=max()){
                    lis.add(c);
                    start.add(st);
                }
            }
        }
        int x = max();
        System.out.println("There are "+(x+1)+" longest subsequence/subsequences");
        for(int i=0;i<lis.size();i++){
            if(x==lis.get(i)){
                print(i);
            }
        }
      /*  if(c==n-1){
            System.out.println("Longest sorted subsequence is "+(c+1));
        }
        else if(c==0){
            System.out.println("Longest sorted subsequence is");
        }
        else{
            findlss();
        }+*/
      //System.out.println(c);
    }
}
