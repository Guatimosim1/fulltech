<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>Atualizar Sessão</title>
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
        .margem {
            margin-top: 2px;
            margin-bottom: 2px;
        }
        label {
            margin-top: 2px;
        }
    </style>
</head>
<body>
    <c:set var="sessao" value="${sessao}"/>
    <div class="conteudo borda">
        <form action="/sessoes/atualizar" method="post">
            <h2>Fomulário de Inserção de Sessão</h2> <br>
            <input type="hidden" name="id" value="${sessao.id}">
            <label>Digite o nome do Filme:</label>
            <input type="text" name="movieName" placeholder="Ex: Star Wars VI - Uma Nova Esperança" size="50" value="${sessao.movieName}"> <br>
            <label>Digite a hora de início:</label> <input type="time" name="startingTime" value="${sessao.startingTime}"> <br>
            <label>Digite a hora de início:</label> <input type="time" name="endingTime" placeholder="Hora de Término" value="${sessao.endingTime}"> <br>
            <div class="conteudo margem">
                <a href="/" class="btn btn-primary">&#10554; Voltar</a>
                <input type="submit" class="btn btn-dark" value="Atualizar Sessão">
            </div>
        </form>
    </div>
</body>
</html>