
class transpose {
    static final int M = 3;
    static final int N = 4;

    static void transpose(int A[][], int B[][]) {
        int i, j;
        for (i = 0; i < N; i++)
            for (j = 0; j < M; j++)
                B[i][j] = A[j][i];
    }

    public static void main(String[] args)
    {
        int A[][] = { { 1, 2,3, 4 },
                { 4, 3, 1, 2 },
                { 1, 7, 5, 6 } };

        int B[][] = new int[N][M], i, j;

        transpose(A, B);

        System.out.print("Result matrix is \n");
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++)
                System.out.print(B[i][j] + " ");
            System.out.print("\n");
        }
    }
}



