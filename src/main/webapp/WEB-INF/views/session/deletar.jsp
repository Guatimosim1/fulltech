<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="sessao" value="${sessao}"/>
    <title>Deletar - ${sessao}</title>
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
    <div class="conteudo borda">
        <form action="/sessoes/deletar/${sessao.id}">
            <div style="padding: 5px;">
                Tem certeza que deseja deletar a Sessão "${sessao.movieName}" que começa às
                ${sessao.startingTime}hr e termina às ${sessao.endingTime}hr?
            </div>
            <div style="padding: 5px;">
                <input type="submit" class="btn btn-dark" value="Sim, quero deletar">
                <a href="/sessoes" class="btn btn-primary">&#10554; Voltar</a>
            </div>
        </form>
    </div>
</body>
</html>