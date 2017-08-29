package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class StoneWall {
    private static final int[] INPUT = {8, 8, 5, 7, 9, 8, 7, 4, 8};
    private static final int ANSWER = 7;

    public static void main(String[] args) {
        System.out.println(ANSWER == solution(INPUT));
    }

    private static int solution(int[] A) {
        int blockCount = 0;
        Deque<Integer> blocks = new LinkedList<>();
        for (int h : A) {
            while (!blocks.isEmpty() && blocks.peekFirst() > h) {
                blocks.removeFirst();
            }
            if (blocks.isEmpty() || blocks.peekFirst() < h) {
                blocks.addFirst(h);
                blockCount++;
            }
        }
        System.out.println("calculated=" + blockCount);
        return blockCount;
    }
}
