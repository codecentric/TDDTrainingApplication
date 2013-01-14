package functional.nl.codecentric.training.tdd.web.page;

import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * User: Hylke Stapersma
 * Company: codecentric
 * Date: 14-01-13
 */
@At(urls = {"#HOST/triangle/calculate"})
public class TriangleCalculationErrorPage extends PageObject {

    public TriangleCalculationErrorPage(WebDriver driver) {
        super(driver);
    }
}
