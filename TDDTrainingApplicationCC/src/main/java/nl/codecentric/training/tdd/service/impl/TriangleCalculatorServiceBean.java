package nl.codecentric.training.tdd.service.impl;

import nl.codecentric.training.tdd.exception.*;
import nl.codecentric.training.tdd.model.TriangleType;
import nl.codecentric.training.tdd.service.TriangleCalculatorService;

import java.util.regex.Pattern;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 12:38
 */
public class TriangleCalculatorServiceBean implements TriangleCalculatorService {

    private static final Pattern NUMBERPATTERN = Pattern.compile("-?\\d+");
    private static final Integer MAXTRIANGLESIZE = new Integer(9);

    @Override
    public TriangleType calculateTriangleType(String inputTriangleSide1, String inputTriangleSide2, String inputTriangleSide3){
        validateTriangleSide(inputTriangleSide1);
        validateTriangleSide(inputTriangleSide2);
        validateTriangleSide(inputTriangleSide3);

        Integer triangleSide1 = Integer.valueOf(inputTriangleSide1,10);
        Integer triangleSide2 = Integer.valueOf(inputTriangleSide2,10);
        Integer triangleSide3 = Integer.valueOf(inputTriangleSide3,10);

        validateIfSumOfTwoIsNotEqualToThird(triangleSide1,triangleSide2,triangleSide3);
        return determineTriangleType(triangleSide1,triangleSide2,triangleSide3);
    }

    protected TriangleType determineTriangleType(Integer triangleSide1, Integer triangleSide2, Integer triangleSide3){
        if(triangleSide1 == triangleSide2 && triangleSide2 == triangleSide3){
            return TriangleType.EQUILATERAL;
        }else if(triangleSide1 == triangleSide2 || triangleSide1 == triangleSide3 || triangleSide2 == triangleSide3){
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }

    protected void validateTriangleSide(String inputTriangleSide){
        validateTriangleSideIsEmptyOrNull(inputTriangleSide);
        validateTriangleSideIsNumeric(inputTriangleSide);
        Integer triangleSide = Integer.valueOf(inputTriangleSide, 10);
        validateTriangleSideIsNotNegative(triangleSide);
        validateTriangleSideIsNotZero(triangleSide);
        validateTriangleSideIsNotGreaterThenMax(triangleSide);
    }

    private void validateTriangleSideIsEmptyOrNull(String inputTriangleSide){
        if(null==inputTriangleSide||"".equals(inputTriangleSide)){
            throw new IllegalArgumentException("Triangle side cannot be empty or null");
        }
    }

    private void validateTriangleSideIsNumeric(String inputTriangleSide){
        if(!NUMBERPATTERN.matcher(inputTriangleSide).matches()){
            throw new NotNumericException("Triangle side must be a number");
        }
    }

    private void validateTriangleSideIsNotNegative(Integer triangleSide){
        if(triangleSide < 0){
            throw new NegativeNumberException("Triangle side cannot be negative");
        }
    }

    private void validateTriangleSideIsNotZero(Integer triangleSide){
        if(triangleSide == 0){
            throw new ZeroNumberException("Triangle side cannot be zero");
        }
    }

    private void validateTriangleSideIsNotGreaterThenMax(Integer triangleSide){
        if(triangleSide>MAXTRIANGLESIZE){
            throw new ExceedsMaxTriangleSideException("Triangle side cannot be greater then max.");
        }
    }

    private void validateIfSumOfTwoIsNotEqualToThird(Integer triangleSide1, Integer triangleSide2, Integer triangleSide3){
        validateTriangleSum(triangleSide1, triangleSide2, triangleSide3);
        validateTriangleSum(triangleSide1, triangleSide3, triangleSide2);
        validateTriangleSum(triangleSide2, triangleSide3, triangleSide1);
    }

    private void validateTriangleSum(Integer triangleSide1, Integer triangleSide2, Integer triangleSide3){
        if((triangleSide1+triangleSide2)==triangleSide3){
            throw new IncorrectTriangleSidesException("The sum of two triangle side cannot be the sum of the third triangle side.");
        }
    }



}
