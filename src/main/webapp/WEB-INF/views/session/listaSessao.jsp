<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
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
			.bloco-acoes {
				text-align: center;
			}
			.borda-preta {
				border: 1px solid black;
				border-radius: 5px;
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

		<c:set var="contador" value="${1}"/>
		<c:forEach var="sessao" items="${sessionList}">
			<c:set var="contador" value="${contador+1}"/>
			<div class="card float borda-preta" style="width: 18rem;">
				<img class="card-img-top" src="https://img.freepik.com/fotos-gratis/fundo-abstrato-preto-escuro-com-lascas-de-madeira_24972-208.jpg" alt="">
				<div class="card-body">
					<div class="bloco-acoes">
						<a href="/sessoes/${sessao.id}" class="btn btn-success" title="Visualizar Cadeiras Disponíveis">
							<span style="font-family: 'Courier New', Courier, monospace;">&#128065;</span>
						</a>
						<a href="/sessoes/atualizar/${sessao.id}" class="btn btn-warning" title="Editar Sessão">&#9998;</a>
						<a href="" class="btn btn-danger" title="Remover Sessão">&#x2715;</a>
					</div>
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