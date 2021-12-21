package org.learnwithllew.duplicationkata;

import java.util.function.Function;

public class Lesson3HigherOrderFunctions extends Song {

    public void singCheers() {
        repeat(0, this::addTwo, "Who do we appreciate?");
        repeat(13, this::getNextPrime, "These are the primes, that we find fine!");
    }

    private void repeat(int number, Function<Integer, Integer> nextNumberFn, String closingPhrase) {
        for (int i = 0; i < 4; i++) {
            number = nextNumberFn.apply(number);
            sing(number + "! ");
        }
        sing(closingPhrase);
    }

    private int addTwo(int number) {
        return number + 2;
    }

    private int getNextPrime(int number) {
        switch (number) {
            case 13:
                return 17;
            case 17:
                return 19;
            case 19:
                return 23;
            case 23:
                return 29;
        }
        return 0;
    }
}
