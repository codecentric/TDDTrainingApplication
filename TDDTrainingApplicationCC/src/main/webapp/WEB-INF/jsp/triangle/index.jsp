<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

    <head>
        <title>TDD Training application</title>

    </head>

    <body>
        <h2>TDD Training application</h2>
        <form:form method="post" action="/triangle/calculate" commandName="triangleForm">

            <div>
                <form:label path="triangleSide1">Triangle side 1</form:label>
                <form:input path="triangleSide1"/>
            </div>

            <div>
                <form:label path="triangleSide2">Triangle side 2</form:label>
                <form:input path="triangleSide2"/>
            </div>

            <div>
                <form:label path="triangleSide3">Triangle side 3</form:label>
                <form:input path="triangleSide3"/>
            </div>

            <button type="reset">Reset form</button>
            <button type="submit">Calculate triangle type</button>
        </form:form>
    </body>

</html>