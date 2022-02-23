<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<c:import url="navbar.jsp"/>
<form class="container w-50" action="${pageContext.request.contextPath}/contest-servlet" method="post">
    <div class="mb-3">
        <label class="mr-sm-2" for="inlineFormCustomSelect">Game</label>
        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="game">
            <c:forEach items="${ gameList }" var="element" varStatus="count">
                <option value="${element.getId()}">${element.getTitle()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col mb-3">
        <label for="dateInput" class="form-label">Start Date</label>
        <input type="date" class="form-control" id="dateInput" name="date">
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form>
</body>
</html>