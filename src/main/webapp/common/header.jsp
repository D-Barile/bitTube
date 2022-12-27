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
						<button class="btn btn-outline-secondary" type="button" id="btnSearch">
							<i class="fa fa-search" aria-hidden="true"></i>
						</button>
					</div>
				</div>
				<!-- Searchbar [end] -->
				<!-- Sezione Login [init] -->
				<div class="col text-end dropdown">
					<%
						String email = null;
						if(session.getAttribute("email") == null){
					%>
					<button type="button" class="btn btn-light dropbtn" onclick="myFunction()">
						<i class="fa fa-user" aria-hidden="true"></i>
						Accedi
					</button>
					<div id="myDropdown" class="dropdown-content">
						<form action="${pageContext.request.contextPath}/login" method="POST">
							<input type="email" id="email" name="email" placeholder="Email" />
							<input type="password" id="password" name="password" placeholder="Password" />
							<input id="sub" type="submit" value="Login" />
						</form>
					</div>
						<% 
							}else{
								email = (String)session.getAttribute("email");
						%>
						<button type="button" class="btn btn-light dropbtn" onclick="error();">
							<a>Aggiungi un video</a>
						</button>
						<button type="button" class="btn btn-light dropbtn" onclick="myFunction()">
							<i class="fa fa-user" aria-hidden="true"></i>
							${email}
						</button>
						<div id="myDropdown" class="dropdown-content">
							<form action="${pageContext.request.contextPath}/logout" method="GET">
								<input type="submit" value="Logout" />
							</form>
						</div>
						<%
							}
						%>
				</div>
				<!-- Sezione Login [end] -->
			</div>
		</div>
	</nav>
</header>
<!-- Header [end] -->