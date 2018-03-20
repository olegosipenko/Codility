package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
 * <p>
 * Complete the function provided in the editor below. It has one parameter: a pointer to a Node object named that points to the head of a linked list. Your function must return a boolean denoting whether or not there is a cycle in the list. If there is a cycle, return true; otherwise, return false.
 * <p>
 * Note: If the list is empty,  will be null.
 * <p>
 * Input Format
 * <p>
 * Our hidden code checker passes the appropriate argument to your function. You are not responsible for reading any input from stdin.
 * <p>
 * Constraints
 * <p>
 * <p>
 * Output Format
 * <p>
 * If the list contains a cycle, your function must return true. If the list does not contain a cycle, it must return false. The binary integer corresponding to the boolean value returned by your function is printed to stdout by our hidden code checker.
 * <p>
 * Sample Input
 * <p>
 * The following linked lists are passed as arguments to your function:
 * <p>
 * Sample Inputs
 * Sample Output
 * <p>
 * 0
 * 1
 * Explanation
 * <p>
 * The first list has no cycle, so we return false and the hidden code checker prints  to stdout.
 * The second list has a cycle, so we return true and the hidden code checker prints  to stdout.
 * <p>
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
 */
public class DetectCycle {

    public static void main(String[] args) {
        Node node0 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        node0.data = 0;
        node0.next = node1;

        node1.data = 1;
        node1.next = node2;

        node2.data = 2;
        node2.next = node1;

        System.out.println(hasCycle(node0));
    }

    static boolean hasCycle(Node head) {
        List<Node> visitedNodes = new ArrayList<>();
        Node underReview = head;
        while (underReview.next != null) {
            Node next = underReview.next;
            if (visitedNodes.contains(next)) return true;
            visitedNodes.add(underReview);
            underReview = next;
        }
        return false;
    }

    private static class Node {
        int data;
        Node next;
    }
}
