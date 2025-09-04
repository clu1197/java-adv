package lambda.expression.challenge;

import java.util.function.Supplier;

public class SupplierChallenge {

    public static void main(String[] args) {

        Supplier<String> iLoveJava = ()-> "I love java";
        Supplier<String> iLoveJava2 = ()-> {return "I love java";};

        System.out.println(iLoveJava.get());
        System.out.println(iLoveJava2.get());

    }
}
