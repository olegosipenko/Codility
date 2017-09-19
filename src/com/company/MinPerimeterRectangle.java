package com.company;

public class MinPerimeterRectangle {
    private static final int I1 = 30;
    private static final int A1 = 22;

    public static void main(String[] args) {
        System.out.println(A1 == solution(I1));
    }
    private static int solution(int N) {
        int a = 1;
        int minPerimeter = Integer.MAX_VALUE;
        while (a * a <= N) {
            if (N % a == 0) {
                int b = N / a;
                minPerimeter = Math.min(minPerimeter, perimeter(a, b));
            }
            a++;
        }
        return minPerimeter;
    }

    private static int perimeter(int a, int b) {
        return (a + b) * 2;
    }
}
