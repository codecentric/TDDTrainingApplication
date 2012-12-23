package nl.codecentric.training.tdd.exception;

/**
 * TDD Training CodeCentric
 * User: Hylke Stapersma
 * Date: 23-12-12
 */
public class IncorrectTriangleSidesException extends IllegalStateException {
    public IncorrectTriangleSidesException(String message) {
        super(message);
    }
}
