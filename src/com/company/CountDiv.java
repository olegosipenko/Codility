package com.company;

public class CountDiv {

    public static int solution(int A, int B, int K) {
        int answer = 0;
        if (A == 0) {
            answer++;
            answer += ((B / K) - (A / K));
        } else {
            answer += (B / K) - ((A - 1) / K);
        }
        return answer;
    }
}
