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
<form class="container w-50" action="${pageContext.request.contextPath}/game-servlet" method="post">
    <div class="mb-3">
        <label for="titleInput" class="form-label">Title</label>
        <input type="text" class="form-control" id="titleInput" name="title">
    </div>
    <div class="row">
    <div class="col mb-3">
        <label for="minplayersinput" class="form-label">Min players</label>
        <input type="number" class="form-control" id="minplayersinput" name="minplayers">
    </div>
    <div class="col mb-3">
        <label for="maxplayersinput" class="form-label">Max players</label>
        <input type="number" class="form-control" id="maxplayersinput" name="maxplayers">
    </div>
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form>
</body>
</html>