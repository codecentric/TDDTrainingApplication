package functional.nl.codecentric.training.tdd.web.steps;

import functional.nl.codecentric.training.tdd.web.page.TriangleCalculationErrorPage;
import functional.nl.codecentric.training.tdd.web.page.TriangleCalculationPage;
import functional.nl.codecentric.training.tdd.web.page.TriangleCalculationSuccessPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import nl.codecentric.training.tdd.model.TriangleType;
import org.hamcrest.Matchers;
import org.junit.Assert;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 02-01-13
 * Time: 19:42
 */
public class TriangleCalculationSteps extends ScenarioSteps{

    public TriangleCalculationSteps(Pages pages) {
        super(pages);
    }

    @Step("Open triangle calculation form")
    public void openTriangleCalculationForm(){
        getPages().get(TriangleCalculationPage.class).open();
    }

    @Step("Fill in triangle sides")
    public void fillInTriangleSides(String triangleSide1,String triangleSide2,String triangleSide3){
        TriangleCalculationPage triangleCalculationPage = getPages().currentPageAt(TriangleCalculationPage.class);
        triangleCalculationPage.getInputSide1().clear();
        triangleCalculationPage.getInputSide2().clear();
        triangleCalculationPage.getInputSide3().clear();
        triangleCalculationPage.getInputSide1().sendKeys(triangleSide1);
        triangleCalculationPage.getInputSide2().sendKeys(triangleSide2);
        triangleCalculationPage.getInputSide3().sendKeys(triangleSide3);
    }

    @Step("Submit triangle calculation form")
    public void submitTriangleSideForm(){
        TriangleCalculationPage triangleCalculationPage = getPages().currentPageAt(TriangleCalculationPage.class);
        triangleCalculationPage.getSubmitButton().click();
    }

    @Step("Should see the error page")
    public void shouldBeAtErrorPage(){
        Assert.assertTrue("Should see the error page", getPages().isCurrentPageAt(TriangleCalculationErrorPage.class));
    }

    @Step("Should see the success page")
    public void shouldBeAtSuccessPage(){
        Assert.assertTrue("Should see the success page", getPages().isCurrentPageAt(TriangleCalculationSuccessPage.class));
    }


    @Step("Expect triangle type on success page")
    public void expectTriangleTypeOnSuccessPage(TriangleType triangleType){
        TriangleCalculationSuccessPage triangleCalculationSuccessPage = getPages().currentPageAt(TriangleCalculationSuccessPage.class);
        Assert.assertTrue("Triangle success page should have triangle type element",triangleCalculationSuccessPage.hasTriangleTypeSpan());
        Assert.assertThat("Triangle type is not correct",triangleType, Matchers.equalTo(TriangleType.valueOf(triangleCalculationSuccessPage.getTriangleTypeSpan().getText())));
    }

}
