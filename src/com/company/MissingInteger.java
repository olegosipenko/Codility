package com.company;

import java.util.HashSet;

public class MissingInteger {

    private static final int[] INPUT = new int[]{1, 3, 6, 4, 1, 2};
    private static final int ANSWER = 5;

    public static void main(String[] args) {
        System.out.println(solution(INPUT));
        System.out.println(ANSWER == solution(INPUT));
    }

    public static int solution(int[] A) {
        HashSet<Integer> existingValues = new HashSet<>();
        int answer = 1;
        for (int aA : A) {
            existingValues.add(aA);

            while (existingValues.contains(answer)) {
                answer++;
            }
        }
        return answer;
    }
}
