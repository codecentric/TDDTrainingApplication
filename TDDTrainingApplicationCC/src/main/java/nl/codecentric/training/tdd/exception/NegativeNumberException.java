package nl.codecentric.training.tdd.exception;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 12:19
 */
public class NegativeNumberException extends IllegalArgumentException{
    public NegativeNumberException(String message) {
        super(message);
    }
}
