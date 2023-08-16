<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cinema Pantera</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>
	<body>
		<div class="container">
			<h1 class="text-center">Bem-vindos(as) ao Cinema Pantera</h1>
		</div>
		<table class="table">
		    <thead>
		        <tr>
		            <th>Id</th>
		            <th>Nome do Filme</th>
		            <th>Horário de Início</th>
		            <th>Horário do Fim</th>
		        </tr>
		    </thead>
		    <tbody>
				<c:forEach var="sessao" items="${sessionList}">
					<tr>
						<td>${sessao.id}</td>
						<td>${sessao.movieName}</td>
						<td>${sessao.startingTime}</td>
						<td>${sessao.endingTime}</td>
					</tr>
				</c:forEach>
		    </tbody>
		</table>
	</body>
</html>