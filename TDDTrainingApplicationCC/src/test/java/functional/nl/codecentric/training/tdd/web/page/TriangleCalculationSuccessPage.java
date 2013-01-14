package functional.nl.codecentric.training.tdd.web.page;

import lombok.Getter;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * User: Hylke Stapersma
 * Company: codecentric
 * Date: 14-01-13
 */
@Getter
@At(urls = {"#HOST/triangle/success"})
public class TriangleCalculationSuccessPage extends PageObject {

    @FindBy(css="span.result")
    private WebElement triangleTypeSpan;

    public TriangleCalculationSuccessPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasTriangleTypeSpan(){
        return element(getTriangleTypeSpan()).isCurrentlyVisible();
    }

}
