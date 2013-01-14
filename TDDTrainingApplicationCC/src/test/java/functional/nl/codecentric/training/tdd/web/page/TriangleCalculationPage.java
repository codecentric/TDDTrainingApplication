package functional.nl.codecentric.training.tdd.web.page;

import lombok.Getter;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 02-01-13
 * Time: 19:42
 */
@Getter
@DefaultUrl("http://localhost:8080/triangle")
@At(urls = {"#HOST/triangle"})
public class TriangleCalculationPage extends PageObject {

    public TriangleCalculationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "triangleSide1")
    private WebElement inputSide1;

    @FindBy(name = "triangleSide2")
    private WebElement inputSide2;

    @FindBy(name = "triangleSide3")
    private WebElement inputSide3;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;



    public boolean hasInputSide1() {
        return element(getInputSide1()).isCurrentlyVisible();
    }

    public boolean hasInputSide2() {
        return element(getInputSide2()).isCurrentlyVisible();
    }

    public boolean hasInputSide3() {
        return element(getInputSide3()).isCurrentlyVisible();
    }

    public boolean hasSubmitButton(){
        return element(getSubmitButton()).isCurrentlyVisible();
    }


}
