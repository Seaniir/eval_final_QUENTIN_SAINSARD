<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/game-servlet" var="game"></c:url>
<c:url value="/player-servlet" var="player"></c:url>
<c:url value="/contest-servlet" var="contest"></c:url>
<c:url value="/home-servlet" var="home"></c:url>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${home}">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${game}">Game</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${player}">Player</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contest}">Contest</a>
                </li>
            </ul>
        </div>
    </div>
</nav>