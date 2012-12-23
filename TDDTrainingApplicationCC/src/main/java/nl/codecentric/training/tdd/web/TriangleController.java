package nl.codecentric.training.tdd.web;

import lombok.Getter;
import lombok.Setter;
import nl.codecentric.training.tdd.exception.ExceedsMaxTriangleSideException;
import nl.codecentric.training.tdd.exception.NegativeNumberException;
import nl.codecentric.training.tdd.exception.NotNumericException;
import nl.codecentric.training.tdd.exception.ZeroNumberException;
import nl.codecentric.training.tdd.web.form.TriangleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.regex.Pattern;

@Controller
@RequestMapping("/triangle")
public class TriangleController {


    @Getter
    @Setter
    private String triangleSide1,triangleSide2,triangleSide3;

    @Autowired
    public TriangleController(){

    }

    public TriangleForm getTriangleForm() {
        return new TriangleForm();
    }




}
