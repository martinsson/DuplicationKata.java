package org.learnwithllew.duplicationkata;

import java.util.Optional;

public class ExampleNullObject {

    public static void main(String[] args) {

        Optional<String> result = getNameToGreet(args[1]);
        result.ifPresent((n) -> System.out.println("Hi " + n));
        Optional<String> s = result.map((name) -> "hello " + name);

        String greeting = s.orElse("Hi somebody");

//        if (isRightCase) {
//            System.out.println("Hi " + name);
//        } else {
//            // on ne fait rien
//        }


    }

    private static Optional<String> getNameToGreet(String arg) {
        String name = arg;
        boolean isRightCase = "toto".equals(name);


        Optional<String> result;
        if (isRightCase) {
            result = Optional.of(name);
        } else {
            result = Optional.empty();
            // on ne fait rien
        }
        return result;
    }
}
