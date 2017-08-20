package com.company;

public class FrogJump {

    public static void main(String[] args) {
	    System.out.println(solution(10, 85, 30));
        System.out.println(solution(10, 100, 30));
    }

    public static int solution(int X, int Y, int D) {
        if (Y < X || Y == 0 || Y == X) return 0;
        if ((Y - X) % D == 0) {
            return ((Y - X) / D);
        } else {
            return ((Y - X) / D + 1);
        }
    }
}
