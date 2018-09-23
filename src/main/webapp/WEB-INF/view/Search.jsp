<c:set var="titlePage" value="Page de recherche" scope="session"/>
<div class="row">
	<div class="col-md-12">
		<c:if test="${ not empty movies }">
			<h1>Les Films</h1>
			<table class="table">
				<thead>
					<tr>
						<td>Titre</td>
						<td>Année</td>
						<td>Synopsis</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ movies }" var="movie">
						<tr>
							<td><a href='<c:url value="/movie?id=${ movie.id }" />'>${ movie.title }</a></td>
							<td>${ movie.releaseDate }</td>
							<td>${ movie.synopsis }</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</c:if>	
		
		<c:if test="${ not empty peoples }">
			<h1>Les Personnalités</h1>
			<table class="table">
				<thead>
					<tr>
						<td>Nom</td>
						<td>Prenom</td>
						<td>Date de naissance</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ peoples }" var="people">
						<tr>
							<td><a href='<c:url value="/people?id=${ people.id }" />'>${ people.lastName }</a></td>
							<td>${ people.firstName }</td>
							<td>${ people.birthDay }</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</c:if>
		
		<c:if test="${ not empty series }">
			<h1>Les Series</h1>
			<table class="table">
				<thead>
					<tr>
						<td>Titre</td>
						<td>Date de réalisation</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ series }" var="serie">
						<tr>
							<td><a href='<c:url value="/serie?id=${ serie.id }" />'>${ serie.title }</a></td>
							<td>${ serie.releaseDate }</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</c:if>
		
		<c:if test="${ not empty albums }">
			<h1>Les Series</h1>
			<table class="table">
				<thead>
					<tr>
						<td>Groupe</td>
						<td>Titre</td>
						<td>Date de réalisation</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ albums }" var="album">
						<tr>
							<td>${ album.band.bandName }</td>
							<td><a href='<c:url value="/album?id=${ album.id }" />'>${ album.title }</a></td>
							<td>${ album.releaseDate }</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</c:if>
	</div>
</div>