package com.company;

public class PassingCars {
    public static final int[] A1 = {0, 1, 0, 1, 1};
    public static final int[] A2 = {0, 1, 1, 1, 1};
    public static final int[] A3 = {0, 1, 0, 1, 0};
    public static final int THRESHOLD = 1000000000;

    public static void main(String[] args) {
        System.out.println(solution(A1) == 5);
    }

    private static int solution(int[] A) {
        int answer = 0;
        int zeroStack = 0;
        for (int aA : A) {
            if (aA == 0) {
                zeroStack++;
            } else {
                answer += zeroStack;
            }
            if (answer > THRESHOLD) {
                return -1;
            }
        }
        return answer;
    }
}
