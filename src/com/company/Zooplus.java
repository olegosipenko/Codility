package com.company;

public class Zooplus {
    private static final String INPUT_1 = "00-44  48 5555 8361";
    private static final String OUTPUT_1 = "004-448-555-583-61";
    private static final String INPUT_2 = "0 - 22 1985--324";
    private static final String OUTPUT_2 = "022-198-53-24";
    private static final String INPUT_3 = "555372654";
    private static final String OUTPUT_3 = "555-372-654";

    private static final int BLOCK_SIZE = 3;
    private static final String PATTERN = "\\D";
    private static final String REPLACEMENT = "";
    private static final String HYPEN = "-";

    public static void main(String[] args) {
        System.out.println(solution(INPUT_1).equals(OUTPUT_1));
        System.out.println(solution(INPUT_2).equals(OUTPUT_2));
        System.out.println(solution(INPUT_3).equals(OUTPUT_3));
    }

    public static String solution(String S) {
        String replaced = getDigitsOnly(S);
        if (nothingToReplace(replaced)) {
            return replaced;
        }
        StringBuilder output = new StringBuilder(replaced);
        int modulo = getModulo(replaced);
        int numOfHypens = getNumOfHypens(replaced);
        insertMainHypens(output, numOfHypens);
        if (needExtraHypens(modulo)) {
            insertExtraHypens(output);
        }
        return output.toString();
    }

    private static final String getDigitsOnly(String s) {
        return s.replaceAll(PATTERN, REPLACEMENT);
    }

    private static final int getNumOfHypens(String s) {
        return s.length() / BLOCK_SIZE - 1;
    }

    private static final int getModulo(String s) {
        return s.length() % BLOCK_SIZE;
    }

    private static final boolean nothingToReplace(String s) {
        return s.length() <= BLOCK_SIZE;
    }

    private static final void insertMainHypens(StringBuilder sb, int numOfHypens) {
        for (int i = 0; i < numOfHypens; i++) {
            sb.insert((i + 1) * BLOCK_SIZE + i, HYPEN);
        }
    }

    private static final boolean needExtraHypens(int modulo) {
        return modulo < BLOCK_SIZE && modulo % BLOCK_SIZE > 0;
    }

    private static final void insertExtraHypens(StringBuilder sb) {
        sb.insert(sb.length() - 2, HYPEN);
    }
}

