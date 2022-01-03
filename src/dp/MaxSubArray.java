package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSubArray {
    private static Map<Integer,Integer> sets = new HashMap<>();
    public static void main(String[] args) {
        int[] input = new int[]{1,5,2,4,3};
        System.out.println("legacy :"+solution(input));
        System.out.println("dp :"+dpSolution(input));
    }
    
    private static int len(int[] input, int i) {
        if (sets.containsKey(i)) {
            return sets.get(i);
        }

        int l = 1;
        for (int j = i+1; j < input.length; j++) {
            if (input[j] >= input[i]) {
                l = Math.max(1+ len(input, j), l);
            }
        }

        sets.put(i,l);
        return l;
    }

    private static int solution(int[] input) {
        int len = 0;
        for (int i = 0; i < input.length; i++) {
            len = Math.max(len, len(input, i));
        }

        return len;
    }

    private static int dpSolution(int[] input) {
        int[] L = new int[input.length];
        Arrays.fill(L, 1);

        for (int i = input.length - 1; i >=0 ; i--) {
            for (int j = i+1; j <input.length ; j++) {
                if (input[j] >= input[i]) {
                    L[i] = Math.max(L[i], L[j] + 1);
                }
            }
        }

        return Arrays.stream(L).max().orElse(0);
    }
}
