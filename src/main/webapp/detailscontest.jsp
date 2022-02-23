<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 23/02/2022
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<form class="container w-50" action="${pageContext.request.contextPath}/detailscontest-servlet?purpose=addContestor" method="post">
    <label for="inlineFormCustomSelect">Add contestor</label>
    <input type="hidden" value="${currentContest.getId()}" name="idContest">
    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="contestor">
        <c:forEach items="${ playerList }" var="element" varStatus="count">
            <option value="${element.getId()}">${element.getNickname()}</option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table id="tableGame" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Nickname</th>
        <th scope="col">Email</th>
        <th scope="col">Supprimer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${currentContest.getContestors()}" var="element">
        <tr>
            <th scope="row" class="align-middle">${element.getId()}</th>
            <td class="align-middle">${element.getNickname()}</td>
            <td class="align-middle">${element.getEmail()}</td>
            <td class="align-middle">
                <form class="container w-50" action="${pageContext.request.contextPath}/detailscontest-servlet?purpose=deleteContestor" method="post">
                    <input type="hidden" value="${element.getIdFromContest()}" name="idToDelete">
                    <input type="hidden" value="${currentContest.getId()}" name="idContest">
                    <button type="submit">
                            Supprimer
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${currentContest.getContestors().size() < currentContest.getGame().getMax_players()}">
    <p>Not enough contestors</p>
</c:if>
<c:if test="${currentContest.getContestors().size() > currentContest.getGame().getMax_players()}">
    <p>Too much contestors</p>
</c:if>
<form class="container w-50" action="${pageContext.request.contextPath}/detailscontest-servlet?purpose=changeWinner" method="post">
    <label for="inlineFormCustomSelect2">Winner ?</label>
    <input type="hidden" value="${currentContest.getId()}" name="idContest">
    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect2" name="winner">
        <c:forEach items="${ playerList }" var="element" varStatus="count">
            <option value="${element.getId()}">${element.getNickname()}</option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
</body>
</html>
