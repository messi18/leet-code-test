package dp;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = new int[]{1,5,2,4,3};
        System.out.println(solution(input));
    }
    
    private static int len(int[] input, int i) {
        int l = 1;
        for (int j = i+1; j < input.length; j++) {
            if (input[j] >= input[i]) {
                l = Math.max(1+ len(input, j), l);
            }
        }
        return l;
    }

    private static int solution(int[] input) {
        int len = 0;
        for (int i = 0; i < input.length; i++) {
            len = Math.max(len, len(input, i));
        }

        return len;
    }
}
