Calculate triangle type

Scenario: Calculate triangle type EQUILATERAL

Given The triangle form is loaded
When side A is 2, side B is 2 and side C is 2
And submits the triangle form
Then the triangle type should be EQUILATERAL

Scenario: Calculate triangle type ISOSCELES

Given The triangle form is loaded
When side A is 2, side B is 2 and side C is 3
And submits the triangle form
Then the triangle type should be ISOSCELES

Scenario: Calculate triangle type SCALENE

Given The triangle form is loaded
When side A is 2, side B is 4 and side C is 3
And submits the triangle form
Then the triangle type should be SCALENE