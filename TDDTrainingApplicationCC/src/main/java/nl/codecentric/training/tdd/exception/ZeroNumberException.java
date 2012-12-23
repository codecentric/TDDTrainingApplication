package nl.codecentric.training.tdd.exception;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 12:20
 */
public class ZeroNumberException extends IllegalArgumentException {
    public ZeroNumberException(String message) {
        super(message);
    }
}
