<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <form action="/sessoes/criar-sessao" method="post">
        <input type="text" name="movieName" placeholder="Nome do Filme"> <br>
        <input type="text" name="startingTime" placeholder="Hora de Início"> <br>
        <input type="text" name="endingTime" placeholder="Hora de Término">
        <input type="submit" class="btn btn-primary">
    </form>
</body>
</html>