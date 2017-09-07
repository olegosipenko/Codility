package com.company;

public class EquiLeader {

    private static final int[] INPUT = {4, 3, 4, 4, 4, 2};
    private static final int[] I2 = {4, 6, 6, 6, 6, 8, 8};
    private static final int ANSWER = 2;
    private static final int NO_LEADER = -1;

    public static void main(String[] args) {
        System.out.println(ANSWER == solution(INPUT));
        System.out.println(getLeader(INPUT));
        System.out.println(getLeader(I2));
    }

    private static int solution(int[] A) {
        int n = A.length;
        int leader = getLeader(A);
        int leaderLeft = countOccurences(A, leader);

        int leaderOut = 0;
        int equiLeaders = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                leaderOut++;
                leaderLeft--;
            }
            if (leaderOut > (i + 1) / 2 && leaderLeft > (n - (i + 1)) / 2) {
                equiLeaders++;
            }
        }
        return equiLeaders;
    }

    private static int getLeader(int[] A) {
        int size = 0;
        int value = 0;
        for (int i : A) {
            if (size == 0) {
                size++;
                value = i;
            } else {
                if (value != i) {
                    size--;
                } else {
                    size++;
                }
            }
        }

        int candidate = NO_LEADER;
        if (size > 0) {
            candidate = value;
        }

        int candidateOccurences = countOccurences(A, candidate);

        return isLeader(A, candidateOccurences) ? candidate : NO_LEADER;
    }

    private static int countOccurences(int[] A, int candidate) {
        int count = 0;
        for (int i : A) {
            if (i == candidate) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLeader(int[] A, int candidateOccurence) {
        return candidateOccurence > (A.length / 2);
    }
}
