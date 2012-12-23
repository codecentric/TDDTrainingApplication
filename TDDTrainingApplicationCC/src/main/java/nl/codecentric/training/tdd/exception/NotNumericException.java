package nl.codecentric.training.tdd.exception;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 12:15
 */
public class NotNumericException extends IllegalArgumentException{
    public NotNumericException(String message){
        super(message);
    }
}
