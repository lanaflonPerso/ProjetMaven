<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="<c:url value = "/" />">Réseau Social</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="<c:url value= "/mur/prive" />">Mur Prive<span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item">
 				<a class="nav-link" href="<c:url value= "/mur/public" />">Mur Public</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">user= ${ sessionScope.user.lastName }</a>
			</li>
			
<%--                Menu Utilisateur              --%>			
			
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Recherche
				</a>
				
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="<c:url value= "/utilisateur/recherche" />">Un Utilisateur</a>
					<a class="dropdown-item" href="<c:url value= "/film/recherche" />">Un Film</a>
				</div>
			</li>
			<li class="nav-item">
				<c:if test="${ not empty sessionScope.user.id }">
					<c:choose>
						<c:when test="${ category == 'films'}">
							<a href="<c:url value= "/film/ajout" />"><i class="fas fa-plus-circle"></i></a>
						</c:when>
						<c:when test="${ category == 'jeux'}">
							<a href="<c:url value= "/jeux/ajout" />"><i class="fas fa-plus-circle"></i></a>
						</c:when>
					</c:choose>
				</c:if>
			</li>
<%--                Menu Ajout              --%>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">	Ajout</a>
				
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="<c:url value= "/movie/add" />">Film</a>
					<a class="dropdown-item" href="<c:url value= "/film/recherche" />">Un Film</a>
				</div>
			</li>
			<li class="nav-item">
				<c:if test="${ not empty sessionScope.user.id }">
					<c:choose>
						<c:when test="${ category == 'films'}">
							<a href="<c:url value= "/film/ajout" />"><i class="fas fa-plus-circle"></i></a>
						</c:when>
						<c:when test="${ category == 'jeux'}">
							<a href="<c:url value= "/jeux/ajout" />"><i class="fas fa-plus-circle"></i></a>
						</c:when>
					</c:choose>
				</c:if>
			</li>
			<li class="nav-item">
				<c:choose>
					<c:when test="${ not empty sessionScope.user.id }">
						<a class="nav-link" href="<c:url value = "/user/connection?type=off" />">Déconnection</a>
					</c:when>
					<c:otherwise>
						<a class="nav-link" href="<c:url value = "/user/connection?type=on" />">Connection</a>
					</c:otherwise>
				</c:choose>
			</li>
		</ul>
  </div>
</nav>