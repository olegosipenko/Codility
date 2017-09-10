package com.company;

import static com.company.EquiLeader.getLeader;

public class Dominator {
    private static final int[] INPUT = {3, 4, 3, 2, 3, -1, 3, 3};
    private static final int ANSWER = 0;

    public static void main(String[] args) {
        System.out.println(ANSWER == solution(INPUT));
    }

    private static int solution(int[] A) {
        int answer = -1;
        int leader = getLeader(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                return i;
            }
        }
        return answer;
    }
}
