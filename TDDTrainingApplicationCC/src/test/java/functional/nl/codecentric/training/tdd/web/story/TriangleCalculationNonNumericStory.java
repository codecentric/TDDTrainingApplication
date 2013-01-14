package functional.nl.codecentric.training.tdd.web.story;

import functional.nl.codecentric.training.tdd.web.Application;
import functional.nl.codecentric.training.tdd.web.steps.TriangleCalculationSteps;
import lombok.Getter;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 02-01-13
 * Time: 19:31
 */
@RunWith(ThucydidesRunner.class)
@Story(Application.TriangleCalculation.NonNumericInput.class)
public class TriangleCalculationNonNumericStory {


    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Getter
    @ManagedPages
    public Pages pages;


    @Steps
    public TriangleCalculationSteps steps;


    @Test
    @Title("Test non numeric input for side 1")
    public void testNonNumericInputSide1() {
        fillInTriangleCalculationForm("a", "3", "7");
    }

    @Test
    @Title("Test non numeric input for side 2")
    public void testNonNumericInputSide2() {
        fillInTriangleCalculationForm("3", "ab", "4");
    }

    @Test
    @Title("Test non numeric input for side 3")
    public void testNonNumericInputSide3() {
        fillInTriangleCalculationForm("2", "3", "sd");
    }

    private void fillInTriangleCalculationForm(String side1, String side2, String side3) {
        steps.openTriangleCalculationForm();
        steps.fillInTriangleSides(side1, side2, side3);
        steps.submitTriangleSideForm();
    }

}
