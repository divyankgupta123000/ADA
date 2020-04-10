import java.util.*;
class Partition {
    static ArrayList<Integer> ind = new ArrayList<Integer>();
    static ArrayList<Integer> res1 = new ArrayList<Integer>();
    static int wind;
    static int sum;
    static int f=0;
    static void gensub(int arr[],int tot,int s){
        int csum;
        for(int i=s+1;i<=arr.length-tot;i++){
            csum=0;
            if(f==1)
                return;
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
                if((csum)+arr[i]==(sum/2)){
                    for(int j=0;j<ind.size();j++){
                        res1.add(ind.get(j));
                    }
                    res1.add(i);
                    f=1;
                }
            }
        }
    }

    static void part(int arr[]){
        int n=arr.length;
        int z=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==sum/2){
                res1.add(i);
                z = i;
                break;
            }
        }
        if(z!=-1){
            f=1;
            return;
        }
        else{
            for(int i=2;i<=n/2;i++){
                wind = i-1;
                gensub(arr,i,-1);
                if(f==1)
                    return;
            }
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
            sum+=arr[i];
        }
        if(sum%2!=0){
            System.out.println("It is not possible");
        }
        else {
            part(arr);
            if(f==1){
                System.out.println("The subsets are=> ");
                System.out.print("Subset 1: ");
                for(int i=0;i<res1.size();i++){
                    System.out.print(arr[res1.get(i)]+" ");
                }
                System.out.println();
                System.out.print("Subset 2: ");
                for(int i=0;i<n;i++){
                    if(!res1.contains(i)){
                        System.out.print(arr[i]+" ");
                    }
                }
            }
            else {
                System.out.println("Not possible");
            }
        }
    }
}
