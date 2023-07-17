package org.example;

import org.example.LexicographicPermutations.LexicographicPermutations;

public class Main {
    public static void main(String[] args) {
        int index = 0;
        String resultCombinationsLexicographicPermutations = "";

        try {

            index = LexicographicPermutations.getIndex(args);
            resultCombinationsLexicographicPermutations = LexicographicPermutations.lexicographicPermutations(index);
            System.out.println(resultCombinationsLexicographicPermutations);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}