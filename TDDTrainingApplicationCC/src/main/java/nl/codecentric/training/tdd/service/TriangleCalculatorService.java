package nl.codecentric.training.tdd.service;

import nl.codecentric.training.tdd.model.TriangleType;

/**
 * User: Hylke Stapersma
 * E-mail:[ hylke.stapersma@codecentric.nl]
 * Date: 23-12-12
 * Time: 11:09
 */
public interface TriangleCalculatorService {

    public TriangleType calculateTriangleType(String triangleSide1, String triangleSide2, String triangleSide3);

}
