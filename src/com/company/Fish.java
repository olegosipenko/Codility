package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class Fish {
    private static final int[] FISHES = {4, 3, 2, 1, 5};
    private static final int[] DIRECTIONS = {0, 1, 0, 0, 0};
    private static final int ANSWER = 2;
    private static final int UPSTREAM = 0;
    private static final int DOWNSTREAM = 1;

    public static void main(String[] args) {
        System.out.println(ANSWER == solution(FISHES, DIRECTIONS));
    }

    private static int solution(int[] A, int[] B) {
        Deque<Integer> upStream = new LinkedList<>();
        Deque<Integer> downStream = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] == UPSTREAM) {
                if (downStream.isEmpty()) {
                    upStream.addFirst(i);
                } else {
                    boolean upBigger = true;
                    int down = downStream.peekFirst();
                    while (!downStream.isEmpty() && upBigger) {
                        down = downStream.removeFirst();
                        if (A[i] < A[down]) {
                            upBigger = false;
                        }
                    }
                    if (upBigger) {
                        upStream.addFirst(i);
                    } else {
                        downStream.addFirst(down);
                    }
                }
            }
            if (B[i] == DOWNSTREAM) {
                downStream.addFirst(i);
            }
        }
        return downStream.size() + upStream.size();
    }
}
