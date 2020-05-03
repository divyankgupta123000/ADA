import java.util.Scanner;

class MinRange {

    static int n=0;

    static int ptr[] = new int[501];
    static void findSmallestRange(int arr[][], int n, int k)
    {
        int i, minval, maxval, minrange, minel = 0, maxel = 0, flag, minind;
        for (i = 0; i <= k; i++) {
            ptr[i] = 0;
        }

        minrange = Integer.MAX_VALUE;

        while (true) {
            minind = -1;
            minval = Integer.MAX_VALUE;
            maxval = Integer.MIN_VALUE;
            flag = 0;
            for (i = 0; i < k; i++){
                if (ptr[i] == n) {
                    flag = 1;
                    break;
                }

                if (ptr[i] < n && arr[i][ptr[i]] < minval) {
                    minind = i;
                    minval = arr[i][ptr[i]];
                }

                if (ptr[i] < n && arr[i][ptr[i]] > maxval) {
                    maxval = arr[i][ptr[i]];
                }
            }

            if (flag == 1) {
                break;
            }

            ptr[minind]++;

            if ((maxval - minval) < minrange) {
                minel = minval;
                maxel = maxval;
                minrange = maxel - minel;
            }
        }
        System.out.printf("The smallest range is "+minel+" "+maxel);
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the number of lists");
        int k = s.nextInt();
        System.out.println("Enter the number of elements in each list");
        n = s.nextInt();
        int arr[][] = new int[k][n];
        System.out.println("Enter the elements int the list");
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = s.nextInt();
            }
        }
        findSmallestRange(arr, n, k);
    }
}
