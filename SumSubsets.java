import java.util.*;
class SumSubsets 
{
    static ArrayList<Integer> ind = new ArrayList<Integer>();
    static ArrayList<Integer> res1 = new ArrayList<Integer>();
    static int wind;
    static int sum;
    static int f=0;
    static void gensub(int arr[],int tot,int s){
        int csum;
        for(int i=s+1;i<=arr.length-tot;i++){
            csum=0;
            if(tot!=1){
                if(!ind.contains(i)){
                    ind.add(i);
                }

                gensub(arr,tot-1,i);
                ind.clear();
            }
            else{
                for(int j=0;j<ind.size();j++){
                    csum+=arr[ind.get(j)];
                }
                if((csum)+arr[i]==sum){
                    for(int j=0;j<ind.size();j++){
                        System.out.print(arr[ind.get(j)]+" ");
                    }
                    System.out.print(arr[i]+" ");
                    System.out.println();
                    f=1;
                }
            }
        }
    }

    static void part(int arr[]){
        int n=arr.length;
        int z=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==sum){
                System.out.print(arr[i]+" ");
                System.out.println();
                z = i;
            }
        }
        for(int i=2;i<=n;i++){
            wind = i-1;
            gensub(arr,i,-1);
        }
    }

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n=s.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements");
        sum=0;
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println("Enter the number");
        sum = s.nextInt();
        part(arr);
        if(f==0){
            System.out.println("Not Possible");
        }
    }
}
