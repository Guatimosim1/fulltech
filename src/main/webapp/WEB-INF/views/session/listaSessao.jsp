<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cinema Pantera</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<style>
			.float {
				float: left;
				margin: 1%;
			}
			.submit {
				background-color: transparent;
				border: 0;
				color: white;
			}
			.link {
				text-decoration: none;
				color: white;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			  <div class="navbar-nav">
				<a class="nav-item nav-link" href="/">Home</a>
				<a class="nav-item nav-link" href="/sessoes/criar-sessao">Criar Sessão</a>
			  </div>
			</div>
		  </nav>
		</nav>

		<div class="container">
			<h1 class="text-center">Bem-vindos(as) ao Cinema Pantera</h1>
		</div>

		<c:set var="contador" value="${0}"/>
		<c:forEach var="sessao" items="${sessionList}">
			<c:set var="contador" value="${contador+1}"/>
			<div class="card float" style="width: 18rem;">
				<img class="card-img-top" src="https://img.freepik.com/vetores-gratis/fundo-monocromatico-do-padrao-quadrado-ilustracao-vetorial-geometrica_1164-1143.jpg" alt="">
				<div class="card-body">
					<h5 class="card-title">${sessao.movieName}</h5>
					<p>Hora de Início: ${sessao.startingTime}</p>
					<p>Hora de Término: ${sessao.endingTime}</p>
				</div>
			</div>
			<c:if test="${contador % 5 == 0}">
				<br>
			</c:if>
		</c:forEach>
	</body>
</html>