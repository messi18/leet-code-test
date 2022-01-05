package dp;

public class NapSack {
    private static int N = 6, W = 21;
    public static void main(String[] args) {
        int[][] B = new int[N][W];

        int[] w = {0,2,3,4,5,9};
        int[] v = {0,3,4,5,8,10};
        napSack(B, w, v);

        System.out.println(B[N-1][W-1]);
    }
    
    private static void napSack(int[][] B, int[] w, int[] v) {
        for (int k = 1; k < N; k++) {
            for (int c = 1; c < W ; c++) {
                if (w[k] > c) {
                    B[k][c] = B[k-1][c];
                } else {
                    B[k][c] = Math.max(B[k-1][c-w[k]]+v[k], B[k-1][c]);
                }
            }
        }
    }
}
