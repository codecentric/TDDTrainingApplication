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
public class TriangleCalculatorServiceBeanTest {

    private final String triangleSideNegative = "-1";
    private final String triangleSidePositive = "1";
    private final String triangleSideZero = "0";
    private final String triangleSideGreaterThenMax = "10";
    private final String triangleSideNotNumeric1 = "AA";
    private final String triangleSideNotNumeric2 = ":";
    private final String triangleSideNull = null;
    private final String triangleSideEmpty = "";

    private TriangleCalculatorServiceBean triangleCalculatorServiceBean;

    @Before
    public void setup(){
        triangleCalculatorServiceBean = new TriangleCalculatorServiceBean();
    }

    @Test
    public void testValidateTriangleSide(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSidePositive);
    }

    @Test(expected = NegativeNumberException.class)
    public void testTriangleSideIsNegative(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSideNegative);
    }

    @Test(expected = ZeroNumberException.class)
    public void testTriangleSideIsZero(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSideZero);
    }

    @Test(expected = ExceedsMaxTriangleSideException.class)
    public void testTriangleSideGreaterThenMax(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSideGreaterThenMax);
    }

    @Test(expected = NotNumericException.class)
    public void testTriangleSideNotNumeric1(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSideNotNumeric1);
    }

    @Test(expected = NotNumericException.class)
    public void testTriangleSideNotNumeric2(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSideNotNumeric2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleSideNull(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSideNull);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleSideEmpty(){
        triangleCalculatorServiceBean.validateTriangleSide(triangleSideEmpty);
    }

    @Test(expected = IncorrectTriangleSidesException.class)
    public void testInvalidTriangleSides1(){
        triangleCalculatorServiceBean.calculateTriangleType("2","4","6");
    }

    @Test(expected = IncorrectTriangleSidesException.class)
    public void testInvalidTriangleSides2(){
        triangleCalculatorServiceBean.calculateTriangleType("2","8","6");
    }

    @Test(expected = IncorrectTriangleSidesException.class)
    public void testInvalidTriangleSides3(){
        triangleCalculatorServiceBean.calculateTriangleType("9","4","5");
    }

    @Test
    public void testDetermineTriangleTypeEQUILATERAL(){
         Assert.assertThat("A triangle with 3 equal sides is equilateral",triangleCalculatorServiceBean.determineTriangleType(2,2,2),equalTo(TriangleType.EQUILATERAL));
    }

    @Test
    public void testDetermineTriangleTypeISOSCELES(){
         Assert.assertThat("A triangle with 2 equal sides is isoceles",triangleCalculatorServiceBean.determineTriangleType(2,2,8),equalTo(TriangleType.ISOSCELES));
         Assert.assertThat("A triangle with 2 equal sides is isoceles",triangleCalculatorServiceBean.determineTriangleType(2,8,2),equalTo(TriangleType.ISOSCELES));
         Assert.assertThat("A triangle with 2 equal sides is isoceles",triangleCalculatorServiceBean.determineTriangleType(8,2,2),equalTo(TriangleType.ISOSCELES));
    }

    @Test
    public void testDetermineTriangleTypeSCALENEL(){
        Assert.assertThat("A triangle with 3 different sides is scalenel",triangleCalculatorServiceBean.determineTriangleType(2,5,4),equalTo(TriangleType.SCALENE));
    }


}
