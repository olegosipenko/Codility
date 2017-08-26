package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class Brackets {

    private static final String NESTED = "{[()()]}";
    private static final String NOT_NESTED = "([)()]";
    private static final String N1 = ")(";
    private static final String N2 = "{{{{";
    private static final char CURLY_O = '{';
    private static final char SQUARE_O = '[';
    private static final char BRACKET_O = '(';
    private static final char CURLY_C = '}';
    private static final char SQUARE_C = ']';
    private static final char BRACKET_C = ')';


    public static void main(String[] args) {
        System.out.println(1 == solution(NESTED));
        System.out.println(0 == solution(NOT_NESTED));
        System.out.println(0 == solution(N1));
        System.out.println(0 == solution(N2));
    }

    private static int solution(String S) {
        Deque<Character> chars = new LinkedList<>();

        for (char c : S.toCharArray()) {
            if (c == CURLY_O || c == SQUARE_O || c == BRACKET_O) {
                chars.addFirst(c);
            } else if (c == CURLY_C || c == SQUARE_C || c == BRACKET_C) {
                if (chars.isEmpty()) return 0;
                char open = chars.removeFirst();
                if (c == CURLY_C) {
                    if (open != CURLY_O) {
                        return 0;
                    }
                } else if (c == SQUARE_C) {
                    if (open != SQUARE_O) {
                        return 0;
                    }
                } else {
                    if (open != BRACKET_O) {
                        return 0;
                    }
                }
            } else {
                return 0;
            }
        }
        if (chars.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
