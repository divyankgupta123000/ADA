import java.util.*;

public class QSort {
    int partition(int arr[],int s,int e)
    {
        int x=arr[e];
        int i=(s-1);
        for(int j=s;j<e;j++)
        {
            if (arr[j]<x)
            {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[e];
        arr[e]=temp;

        return i+1;
    }

    void sort(int arr[],int s,int e)
    {
        if(s<e)
        {
            int q=partition(arr,s,e);
            sort(arr,s,q-1);
            sort(arr,q+1,e);
        }
    }

    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=s.nextInt();
        System.out.println("Enter the elements");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        quickSort ob = new quickSort();
        ob.sort(arr,0,n-1);

        System.out.println("sorted array");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
    }
}
