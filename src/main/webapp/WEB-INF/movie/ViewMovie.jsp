<c:set var="titlePage" value="Ajout d'un Film" scope="session"/>
<c:choose>
	<c:when test="${ error != true }">
	<div class="row">
	  <div class="col-md-4">
	    <img src="${ movie.picture }" class="img-fluid" alt="${ movie.title }">
	  </div>
	
	  <div class="col-md-8">
	    <h3>${ movie.title } (${ movie.releaseDate }) </h3>
	    
		<c:if test="${ sessionScope.user != null  }">
			<jsp:include page="/WEB-INF/layout/LikeDislike.jsp" >
			  <jsp:param name="likeCount" value="${ movie.likeCount }" />
			  <jsp:param name="dislikeCount" value="${ movie.dislikeCount }" />
			  <jsp:param name="progressBar" value="${ 100*(movie.likeCount/(movie.likeCount+movie.dislikeCount)) }" />
			  <jsp:param name="myVote" value="is-disliked" />
			  <jsp:param name="url" value="&id=${ movie.id }" />
			</jsp:include>
		</c:if>
	   
	    <p>${ movie.synopsis }</p>
	    
	    <ul class="list-group">
	    	<c:if test="${ sessionScope.user != null  }">
	    		<li>
	    			<a href='<c:url value="/people/add?function=actor&type=movie&id=${ movie.id }" />'>
	    				<button type="button" class="btn btn-secondary btn-xs">Ajouter un acteur</button>
	    			</a>
	    		</li>
	    	</c:if>
	    	
	    	<c:forEach items="${ movie.actors }" var="actor">
		        <li class="list-group-item">
					<a href='<c:url value="/people?id=${ actor.id }" />' >${ actor.firstName } ${ actor.lastName }</a>
		        </li>
	    	</c:forEach>
	      </ul>
	  </div>
	</div>
	</c:when>
	<c:otherwise>
		<h1>film introuvable</h1>
	</c:otherwise>
</c:choose>