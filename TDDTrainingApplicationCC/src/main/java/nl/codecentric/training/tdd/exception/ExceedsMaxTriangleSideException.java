package nl.codecentric.training.tdd.exception;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 12:21
 */
public class ExceedsMaxTriangleSideException extends IllegalArgumentException {
    public ExceedsMaxTriangleSideException(String message) {
        super(message);
    }
}
