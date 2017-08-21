package com.company;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by olegosipenko on 04.08.17.
 */
public class PermCheck {
    private static final int[] a = new int[]{4, 1, 3, 2};
    private static final int[] b = new int[]{4, 1, 3};

    public static void main(String[] args) {
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution2(a));
        System.out.println(solution2(b));
    }

    private static int solution(int[] A) {
        HashSet<Integer> range = new HashSet<>();
        for (int i = 1; i <= A.length; i++) {
            range.add(i);
        }
        for (int a : A) {
            range.remove(a);
        }
        if (range.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int solution2(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }
        return 1;
    }
}
