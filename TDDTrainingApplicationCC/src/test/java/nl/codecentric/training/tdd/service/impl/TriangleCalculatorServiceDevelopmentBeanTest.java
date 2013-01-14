package nl.codecentric.training.tdd.service.impl;

import nl.codecentric.training.tdd.exception.*;
import nl.codecentric.training.tdd.model.TriangleType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 12:50
 */
public class TriangleCalculatorServiceDevelopmentBeanTest {

    private final String triangleSideNegative = "-1";
    private final String triangleSidePositive = "1";
    private final String triangleSideZero = "0";
    private final String triangleSideGreaterThenMax = "10";
    private final String triangleSideNotNumeric1 = "AA";
    private final String triangleSideNotNumeric2 = ":";
    private final String triangleSideNull = null;
    private final String triangleSideEmpty = "";

    private TriangleCalculatorServiceDevelopmentBean triangleCalculatorServiceDevelopmentBean;

    @Before
    public void setup(){
        triangleCalculatorServiceDevelopmentBean = new TriangleCalculatorServiceDevelopmentBean();
    }

    //@Test
    public void testValidateTriangleSide(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSidePositive);
    }

    //@Test(expected = NegativeNumberException.class)
    public void testTriangleSideIsNegative(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSideNegative);
    }

    //@Test(expected = ZeroNumberException.class)
    public void testTriangleSideIsZero(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSideZero);
    }

    //@Test(expected = ExceedsMaxTriangleSideException.class)
    public void testTriangleSideGreaterThenMax(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSideGreaterThenMax);
    }

    //@Test(expected = NotNumericException.class)
    public void testTriangleSideNotNumeric1(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSideNotNumeric1);
    }

    //@Test(expected = NotNumericException.class)
    public void testTriangleSideNotNumeric2(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSideNotNumeric2);
    }

    //@Test(expected = IllegalArgumentException.class)
    public void testTriangleSideNull(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSideNull);
    }

    //@Test(expected = IllegalArgumentException.class)
    public void testTriangleSideEmpty(){
        triangleCalculatorServiceDevelopmentBean.validateTriangleSide(triangleSideEmpty);
    }

    //@Test(expected = IncorrectTriangleSidesException.class)
    public void testInvalidTriangleSides1(){
        triangleCalculatorServiceDevelopmentBean.calculateTriangleType("2", "4", "6");
    }

    //@Test(expected = IncorrectTriangleSidesException.class)
    public void testInvalidTriangleSides2(){
        triangleCalculatorServiceDevelopmentBean.calculateTriangleType("2", "8", "6");
    }

    //@Test(expected = IncorrectTriangleSidesException.class)
    public void testInvalidTriangleSides3(){
        triangleCalculatorServiceDevelopmentBean.calculateTriangleType("9", "4", "5");
    }

    //@Test
    public void testDetermineTriangleTypeEQUILATERAL(){
         Assert.assertThat("A triangle with 3 equal sides is equilateral", triangleCalculatorServiceDevelopmentBean.determineTriangleType(2,2,2),equalTo(TriangleType.EQUILATERAL));
    }

    //@Test
    public void testDetermineTriangleTypeSCALENEL(){
         Assert.assertThat("A triangle with 2 equal sides is scalenel", triangleCalculatorServiceDevelopmentBean.determineTriangleType(2,2,8),equalTo(TriangleType.SCALENE));
         Assert.assertThat("A triangle with 2 equal sides is scalenel", triangleCalculatorServiceDevelopmentBean.determineTriangleType(2,8,2),equalTo(TriangleType.SCALENE));
         Assert.assertThat("A triangle with 2 equal sides is scalenel", triangleCalculatorServiceDevelopmentBean.determineTriangleType(8,2,2),equalTo(TriangleType.SCALENE));
    }

    //@Test
    public void testDetermineTriangleTypeISOSCELES(){
        Assert.assertThat("A triangle with 3 different sides is isoceles", triangleCalculatorServiceDevelopmentBean.determineTriangleType(2,5,4),equalTo(TriangleType.ISOSCELES));
    }


}
