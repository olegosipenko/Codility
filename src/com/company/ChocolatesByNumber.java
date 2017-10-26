package com.company;

public class ChocolatesByNumber {
    private static final int IN1 = 10;
    private static final int IN3 = 12;
    private static final int IN2 = 4;
    private static final int IN4 = 21;
    private static final int A1 = 5;
    private static final int A2 = 4;

    public static void main(String[] args) {
        System.out.println(A1 == solution(IN1, IN2));
        System.out.println(A2 == solution(IN3, IN4));
    }

    private static int solution(int N, int M) {
        return N / gcd(N, M);
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
