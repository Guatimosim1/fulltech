<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadeira</title>
    <style>
        .conteudo {
            margin: auto;
            margin-top: 50px;
            max-width: 500px;
            text-align: center;
            font-weight: bold;
        }
        .borda {
            border: 1px solid black;
            border-radius: 3px;
            box-shadow: 5px 5px black;
        }
        input {
            margin-left: 2px;
        }
    </style>
</head>
<body>
    <c:set var="cadeira" value="${chair}"/>
    id = ${cadeira.id}
    <div class="conteudo borda">
        <c:if test="${!cadeira.status}">
            Esta cadeira está disponível. Digite o nome do cliente que deseja assinalar:
            <form action="/cadeiras/assign/${cadeira.id}" method="get">
                <input type="text" name="nomeCliente">
                <input class="btn btn-dark" type="submit" value="Assinalar">
            </form>
        </c:if>
        <c:if test="${cadeira.status}">
            Desculpe. Esta cadeira já foi assinalada para o cliente ${cadeira.costumerName}
        </c:if> <br>
        <a href="/sessoes/${cadeira.session.id}" class="btn btn-primary">Voltar</a>
        <br>
    </div>
</body>
</html>