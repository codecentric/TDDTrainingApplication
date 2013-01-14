package functional.nl.codecentric.training.tdd.web;

import net.thucydides.core.annotations.Feature;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 02-01-13
 * Time: 19:33
 */
public class Application {

    @Feature
    public static class TriangleCalculation{
        public static class Success{};
        public static class NonNumericInput{};
    }

}
