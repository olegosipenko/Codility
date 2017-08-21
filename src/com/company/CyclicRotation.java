package com.company;

import java.util.Arrays;

/**
 * Created by olegosipenko on 31.07.17.
 */
public class CyclicRotation {
    private static final int[] A = new int[]{1, 2, 3, 4, 5, 6, 7};
    private static final int[] B = new int[]{3, 8, 9, 7, 6};

    public static void main(String[] args) {
        assert Arrays.equals(solution(A, 3), new int[]{5, 6, 7, 1, 2, 3, 4});
        assert Arrays.equals(solution(A, 4), new int[]{4, 5, 6, 7, 1, 2, 3});
        assert Arrays.equals(solution(A, 5), new int[]{3, 4, 5, 6, 7, 1, 2});
        assert Arrays.equals(solution(A, 7), A);
        assert Arrays.equals(solution(B, 3), new int[]{9, 7, 6, 3, 8});
        assert Arrays.equals(solution(B, 4), new int[]{8, 9, 7, 6, 3});
        assert Arrays.equals(solution(B, 5), B);
    }

    private static int[] solution(int[] A, int K) {
        if (A.length - K < K) {
            return copyLeftMoveRight(A, K);
        } else {
            return copyRightMoveLeft(A, K);
        }
    }

    private static int[] copyRightMoveLeft(int[] A, int K) {
        int[] rightSlice = Arrays.copyOfRange(A, A.length - K, A.length);
        System.out.println(Arrays.toString(rightSlice));
        System.arraycopy(A, 0, A, A.length - K - 1, A.length - K);
        System.out.println(Arrays.toString(A));
        System.arraycopy(rightSlice, 0, A, 0, rightSlice.length);
        return A;
    }

    private static int[] copyLeftMoveRight(int[] A, int K) {
        int[] leftSlice = Arrays.copyOfRange(A, 0, A.length - K);
        System.out.println(Arrays.toString(leftSlice));
        System.arraycopy(A, A.length - K, A, 0, K);
        System.out.println(Arrays.toString(A));
        System.arraycopy(leftSlice, 0, A, K, leftSlice.length);
        return A;
    }

    private static int[] previous(int[] A, int K) {
        int[] leftSlice = Arrays.copyOfRange(A, 0, A.length - K);
        System.out.println(Arrays.toString(leftSlice));
        System.arraycopy(A, A.length - K, A, 0, K);
        System.out.println(Arrays.toString(A));
        System.arraycopy(leftSlice, 0, A, K, leftSlice.length);
        return A;
    }
}
