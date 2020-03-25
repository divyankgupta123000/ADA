import java.util.*;
class Msort {
    static void mergeArr(int arr[], int l, int m, int r)
    {
        int lsize=m - l + 1;
        int rsize=r - m;
        int left[]=new int [lsize];
        int right[]=new int [rsize];

        for (int i=0;i<lsize;++i)
            left[i]=arr[l+i];

        for (int j=0;j<rsize;++j)
            right[j]=arr[m+1+j];

        int i=0,j=0;
        int k=l;
        while (i<lsize && j<rsize)
        {
            if (left[i] <= right[j])
            {
                arr[k]=left[i];
                i++;
            }
            else
            {
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while (i<lsize)
        {
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j<rsize)
        {
            arr[k]=right[j];
            j++;
            k++;
        }
    }
    static void sortArr(int arr[],int l,int r)
    {
        if (l<r)
        {
            int m = (l+r)/2;
            sortArr(arr,l,m);
            sortArr(arr,m+1,r);
            mergeArr(arr,l,m,r);
        }
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n=s.nextInt();
        Random r=new Random();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(10000);
        }

        Date before=new Date();
        sortArr(a,0,n-1);
        Date after=new Date();
        double time=after.getTime()-before.getTime();
        /*for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }*/
        System.out.println();
        System.out.println("Time taken in ms = "+time);
    }
}
