package com.company;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    private static final int[] LEAVES = new int[]{1, 3, 1, 4, 2, 3, 5, 4};

    public static void main(String[] args) {
        System.out.println(solution(5, LEAVES));
        System.out.println(solution(5, LEAVES) == 6);
    }

    private static int solution(int X, int[] A) {
        Set<Integer> leavesToFall = new HashSet<>();
        for (int i = 0; i < X; i++) {
            leavesToFall.add(i + 1);
        }
        for (int i = 0; i < A.length; i++) {
            leavesToFall.remove(A[i]);
            if (leavesToFall.isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}
