<div class="row">
	<div class="col-md-4">
		<img src="${ album.picture }" alt="${ album.band } ${ album.title }" />
	</div>
	
	<div class="col-md-8">
		<h1>${ album.band.bandName } ${ album.title } (${ album.releaseDate })</h1>
		
		<p>${ album.description }</p>
	
		<ul class="list-grouph">
			<c:if test="${ sessionScope.user != null  }">
		    		<li>
		    			<a href='<c:url value="/music/add?type=song&id=${ album.id }" />'>
		    				<button type="button" class="btn btn-secondary btn-xs">Ajouter des titres</button>
		    			</a>
		    		</li>
		    	</c:if>
		
			<c:forEach items="${ album.songs }" var="song">
				<li>${ song.number }: ${ song.title }</li>
			</c:forEach>
		</ul>
	</div>
</div>