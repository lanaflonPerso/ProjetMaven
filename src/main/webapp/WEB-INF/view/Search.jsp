<c:set var="titlePage" value="Page de recherche" scope="session"/>
<div class="row">
	<div class="col-md-12">
		<c:if test="${ movies != null }">
			<table class="table">
				<thead>
					<tr>
						<td>Titre</td>
						<td>année</td>
						<td>synopsis</td>
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
	</div>
</div>