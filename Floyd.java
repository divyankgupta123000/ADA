import java.util.*;
class Floyd {
    static int v;

    static void floyd(int mat[][]) {
        v=mat.length;
        int A[][]=new int[v][v];
        int i,j,k;

        for (i = 0; i < v; i++)
            for (j = 0; j < v; j++)
                A[i][j] = mat[i][j];

        for (k = 0; k < v; k++) {
            for (i = 0; i < v; i++) {
                for (j = 0; j < v; j++) {
                    if (A[i][k] + A[k][j] < A[i][j])
                        A[i][j] = A[i][k] + A[k][j];
                }
            }
        }
        printMatrix(A);
    }

    static void printMatrix(int A[][]) {
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < v; ++j) {
                if (A[i][j] == 999)
                    System.out.print("INF ");
                else
                    System.out.print(A[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        v=s.nextInt();
        int mat[][]=new int[v][v];
        System.out.println("Enter the matrix od weights, if infinite mention 999 ");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                mat[i][j]=s.nextInt();
            }
        }
        floyd(mat);
    }
}
