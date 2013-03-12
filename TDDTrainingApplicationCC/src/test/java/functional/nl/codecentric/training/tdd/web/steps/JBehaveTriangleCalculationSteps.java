package functional.nl.codecentric.training.tdd.web.steps;

import net.thucydides.core.annotations.Steps;
import nl.codecentric.training.tdd.model.TriangleType;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 */
public class JBehaveTriangleCalculationSteps {

    @Steps
    private TriangleCalculationSteps triangleCalculationSteps;

    @Given("The triangle form is loaded")
    public void openTriangleForm() {
        triangleCalculationSteps.openTriangleCalculationForm();
    }

    @When("side A is $sideA, side B is $sideB and side C is $sideC")
    public void fillInTriangleForm(String sideA, String sideB, String sideC) {
        triangleCalculationSteps.fillInTriangleSides(sideA, sideB, sideC);
    }

    @When("submits the triangle form")
    public void submitTriangleForm() {
        triangleCalculationSteps.submitTriangleSideForm();
    }

    @Then("the triangle type should be $triangleType")
    public void triangleTypeShouldBe(String triangleType) {
        triangleCalculationSteps.expectTriangleTypeOnSuccessPage(TriangleType.valueOf(triangleType));
    }
}
