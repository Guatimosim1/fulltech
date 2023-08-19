<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Erro</title>
</head>
<body>
    <h2>Ops... Um erro surgiu</h2>
    <table class="table table-dark">
        <tr>
            <td>O que houve?</td>
            <td>${exception.getMessage()}</td>
        </tr>
        <tr>
            <td>Código de Erro</td>
            <td>${exception.getStatusCode()}</td>
        </tr>
        <tr>
            <td>Path</td>
            <td>${exception.getPath()}</td>
        </tr>
        <tr>
            <td>Timestamp</td>
            <td>${exception.getTimestamp()}</td>
        </tr>
    </table>
</body>
</html>