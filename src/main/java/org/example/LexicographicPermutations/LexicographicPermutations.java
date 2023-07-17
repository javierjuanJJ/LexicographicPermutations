package org.example.LexicographicPermutations;

import java.util.ArrayList;
import java.util.Arrays;

public class LexicographicPermutations {

    public static int getIndex(String[] args) throws Exception {
        int index = 0;

        if (args.length != 1){
            throw new Exception("You must put a 1 argument what must be a number between " + 0 + " and " + Integer.MAX_VALUE);
        }
        else if (!LexicographicPermutations.isANumber(args[0])){
            throw new Exception("The character " + args[0] + " is not a number");
        }
        else if (Integer.parseInt(args[0]) < 0){
            throw new Exception("The number must be greater tha 0 and the number is " + Integer.parseInt(args[0]));
        }
        else {
            index = Integer.parseInt(args[0]);
        }

        index++;
        return index;
    }

    public static String lexicographicPermutations(int index) {
        int[] arrayNumbers = new int[index];

        for (int counter = 0; counter < index; counter++) {
            arrayNumbers[counter] = (counter);
        }

        return lexicographicPermutations(0, arrayNumbers);
    }

    public static String lexicographicPermutations(int actuallyCounter, int... originalArray) {
        int[] array = copyArray(originalArray);
        int lengthArray = array.length;
        int newPositionArray = 0;
        int temp = 0;

        StringBuilder text = new StringBuilder();

        temp = array[actuallyCounter];
        array[actuallyCounter] = array[newPositionArray];
        array[newPositionArray] = temp;

        text
                .append("Combinations of number ")
                .append(originalArray[actuallyCounter])
                .append(System.lineSeparator())
                .append("-------------------")
                .append(System.lineSeparator());

        for (int counterArray = 0; counterArray < lengthArray - 1; counterArray++) {

            if (counterArray == lengthArray - 1){
                newPositionArray = counterArray;
            }
            else {
                newPositionArray = counterArray + 1;
            }

            temp = array[counterArray];
            array[counterArray] = array[newPositionArray];
            array[newPositionArray] = temp;

            text
                    .append(Arrays.toString(array))
                    .append(System.lineSeparator())
                    .append(System.lineSeparator());

        }

        if (actuallyCounter < array.length - 1){
            actuallyCounter++;

            return  text +
                    System.lineSeparator() +
                    "-----------------------------" +
                    System.lineSeparator() +
                    lexicographicPermutations(actuallyCounter, originalArray);
        }

        return text.toString();

    }

    private static int[] copyArray(int[] originalArray) {
        int lengthArray = originalArray.length;
        int[] copiedArray = new int[lengthArray];

        for (int counterArray = 0; counterArray < lengthArray; counterArray++) {
            copiedArray[counterArray] = originalArray[counterArray];
        }

        return copiedArray;
    }

    public static boolean isANumber(String arg) {
        boolean isANumber = true;
        try {
            Integer.parseInt(arg);
        }catch (Exception e){
            isANumber = false;
        }
        return isANumber;
    }

}
