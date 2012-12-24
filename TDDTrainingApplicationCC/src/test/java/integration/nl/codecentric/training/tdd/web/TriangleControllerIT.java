package integration.nl.codecentric.training.tdd.web;

import nl.codecentric.training.tdd.web.TriangleController;
import nl.codecentric.training.tdd.web.form.TriangleForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import static org.hamcrest.Matchers.*;

/**
 * User: Hylke Stapersma
 * Company: codecentric
 * Date: 24-12-12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-integration.xml", "classpath:applicationContext-webmvc.xml"})
public class TriangleControllerIT {

    @Autowired
    private TriangleController triangleController;

    @Test
    public void testWiring() {
        Assert.assertThat("Triangle calculator service cannot be null", triangleController.getTriangleCalculatorService(), is(not(nullValue())));
    }

    @Test
    public void testCalculateTriangleTypeWithEmptyForm() {
        TriangleForm triangleForm = new TriangleForm();
        BindingResult bindingResult = new BeanPropertyBindingResult(triangleForm,"triangleForm");
        Assert.assertThat("Redirect to default page", triangleController.calculate(triangleForm, bindingResult), is(equalTo("redirect:/triangle")));
    }


}
