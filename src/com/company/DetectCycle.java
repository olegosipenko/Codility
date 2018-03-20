package com.company;

import java.util.ArrayList;
import java.util.List;

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
