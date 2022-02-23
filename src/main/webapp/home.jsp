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
<table id="tableGame" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Email</th>
        <th scope="col">Nickname</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${playersList}" var="element">
        <tr>
            <th scope="row" class="align-middle">${element.getId()}</th>
            <td class="align-middle">${element.getEmail()}</td>
            <td class="align-middle">${element.getNickname()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table id="tableGame" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Game</th>
        <th scope="col">Contestors number</th>
        <th scope="col">Start Date</th>
        <th scope="col">Winner</th>
        <th scope="col">Détails</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contestList}" var="element">
        <tr>
            <th scope="row" class="align-middle">${element.getId()}</th>
            <td class="align-middle">${element.getGame().getTitle()}</td>
            <td class="align-middle">${element.getContestors().size()}</td>
            <td class="align-middle">${element.getStart_date()}</td>
            <td class="align-middle">${element.getWinner().getNickname()}</td>
            <td class="align-middle">
                <c:url value="/detailscontest-servlet?id=${element.getId()}" var="contest"></c:url>
                <button type="button">
                    <a href="${contest}">
                        Détails
                    </a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table id="tableGame" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Titre</th>
        <th scope="col">Min_Players</th>
        <th scope="col">Max_Players</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${gameList}" var="element">
        <tr>
            <th scope="row" class="align-middle">${element.getId()}</th>
            <td class="align-middle">${element.getTitle()}</td>
            <td class="align-middle">${element.getMin_players()}</td>
            <td class="align-middle">${element.getMax_players()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>