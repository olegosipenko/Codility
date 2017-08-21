package com.company;

import java.util.Arrays;

/**
 * Created by olegosipenko on 31.07.17.
 */
public class PermElementMissing {

    private static final int[] A = new int[]{2, 3, 1, 5};

    public static void main(String[] args) {
        System.out.print("answer=" + solution(A));
    }

    private static int solution(int[] b) {
        Arrays.sort(b);
        for (int i = 0, j = 1; i < b.length; i++, j++) {
            if (b[i] != j) {
                return j;
            }
        }
        return b.length + 1;
    }
}
