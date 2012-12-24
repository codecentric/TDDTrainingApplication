package nl.codecentric.training.tdd.web.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 10:59
 */
@Getter
@Setter
public class TriangleForm {

    @NotEmpty
    private String triangleSide1,triangleSide2,triangleSide3;

}
