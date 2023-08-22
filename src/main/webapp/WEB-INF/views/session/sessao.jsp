<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="sessao" value="${sessao}"/>
    <title>Sessão - ${sessao.movieName}</title>
    <style>
        .center {
            text-align: center;
        }
        .square {
            width: 50px;
            height: 50px;
            border: 1px solid black;
            border-radius: 5px;
            padding: 20px;
            margin: 10px;
            display: inline-block;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="collapse navbar-collapse">
          <div class="navbar-nav">
            <a class="nav-item nav-link" href="/">Home</a>
            <a class="nav-item nav-link" href="/sessoes/criar-sessao">Criar Sessão</a>
          </div>
        </div>
      </nav>
    </nav>

    
    <div class="center">
        <h1>${sessao.movieName}</h1>
        <h4 class="font-weight-light">${sessao.startingTime} --- ${sessao.endingTime}</h4>
        <hr>
        <h5>Cadeiras Disponíveis</h5>
        <c:set var="contador" value="${1}"/>
        <c:forEach var="cadeira" items="${sessao.getChairs()}">
            <a href="/cadeiras/${cadeira.id}">
                <div class="square">${contador}</div>
            </a>
            <c:if test="${contador % 5 == 0}">
                <br>
            </c:if>
            <c:set var="contador" value="${contador + 1}"/>
        </c:forEach>
    </div>
</body>
</html>