package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class Nested {
    private static final String NESTED = "(()(())())";
    private static final String NOT = "())";

    private static final char OPEN = '(';

    public static void main(String[] args) {
        System.out.println(1 == solution(NESTED));
        System.out.println(0 == solution(NOT));
    }

    private static int solution(String S) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(S.charAt(i));
            } else {
                if (S.charAt(i) == OPEN) {
                    stack.addFirst(S.charAt(i));
                } else {
                    if (!stack.isEmpty()) {
                        stack.removeFirst();
                    }
                }
            }
        }
        return stack.isEmpty() ? 1: 0;
    }
}
