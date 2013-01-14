package functional.nl.codecentric.training.tdd.web.story;

import functional.nl.codecentric.training.tdd.web.Application;
import functional.nl.codecentric.training.tdd.web.steps.TriangleCalculationSteps;
import lombok.Getter;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import nl.codecentric.training.tdd.model.TriangleType;
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
@Story(Application.TriangleCalculation.Success.class)
public class TriangleCalculationSuccessStory {


    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Getter
    @ManagedPages
    public Pages pages;


    @Steps
    public TriangleCalculationSteps steps;


    @Test
    @Title("Test triangle type EQUILATERAL")
    public void testNonNumericEquilateral() {
        fillInTriangleCalculationForm("2", "2", "2", TriangleType.EQUILATERAL);
    }

    @Test
    @Title("Test triangle type ISOSCELES")
    public void testNonNumericInputSide2() {
        fillInTriangleCalculationForm("2", "5", "2", TriangleType.ISOSCELES);
    }

    @Test
    @Title("Test triangle type SCALENE")
    public void testNonNumericInputSide3() {
        fillInTriangleCalculationForm("2", "5", "4", TriangleType.SCALENE);
    }

    private void fillInTriangleCalculationForm(String side1, String side2, String side3, TriangleType triangleType) {
        steps.openTriangleCalculationForm();
        steps.fillInTriangleSides(side1, side2, side3);
        steps.submitTriangleSideForm();
        steps.shouldBeAtSuccessPage();
        steps.expectTriangleTypeOnSuccessPage(triangleType);
    }

}
