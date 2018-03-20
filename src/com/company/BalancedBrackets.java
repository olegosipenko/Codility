package com.company;

import java.util.Deque;
import java.util.LinkedList;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * <p>
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 * <p>
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * <p>
 * Some examples of balanced brackets are []{}(), [({})]{}() and ({(){}[]})[].
 * <p>
 * By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:
 * <p>
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer, , denoting the number of strings.
 * Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.
 * <p>
 * Constraints
 * <p>
 * <p>
 * , where  is the length of the sequence.
 * Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
 * Output Format
 * <p>
 * For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.
 * <p>
 * Sample Input
 * <p>
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 * Sample Output
 * <p>
 * YES
 * NO
 * YES
 * Explanation
 * <p>
 * The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 * The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced. Thus, we print NO on a new line.
 * The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 * <p>
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
 */
public class BalancedBrackets {

    private static boolean isBalanced(String expression) {
        Deque<Character> brackets = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '[' || current == '(' || current == '{') {
                brackets.addFirst(current);
            } else {
                if (brackets.isEmpty()) return false;
                char lastBracket = brackets.removeFirst();
                if ((lastBracket == '[' && current != ']') ||
                        (lastBracket == '(' && current != ')') ||
                        (lastBracket == '{' && current != '}')) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}") == true);
        System.out.println(isBalanced("{[(])}") == false);
        System.out.println(isBalanced("{{[[(())]]}}") == true);
    }
}
