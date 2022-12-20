<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>bitTube - Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
  </head>
  <body>
    <!-- Header [init] -->
	<header class="px-3">
		<nav class="navbar bg-white">
			<div class="container-fluid d-block">
				<div class="row align-items-center">
					<!-- Logo [init] -->
					<div class="col">
						<a class="navbar-brand" href="#">
							<img src="resources/img/bitTube-black.png" alt="Logo bitTube" height="28" />
						</a>
					</div>
					<!-- Logo [end] -->
					<!-- Searchbar [init] -->
					<div class="col">
						<div class="input-group">
							<input type="text" id="txtSearch" class="form-control" placeholder="Cerca" aria-label="Cerca" aria-describedby="btnSearch">
							<button class="btn btn-outline-secondary" type="button" id="btnSearch">icona</button>
						</div>
					</div>
					<!-- Searchbar [end] -->
					<!-- Sezione Login [init] -->
					<div class="col text-end">
						<button type="button" class="btn btn-light">Accedi</button>
					</div>
					<!-- Sezione Login [end] -->
				</div>
			</div>
		</nav>
	</header>
	<!-- Header [end] -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>