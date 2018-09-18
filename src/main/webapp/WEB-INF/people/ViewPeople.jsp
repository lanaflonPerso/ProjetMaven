<%-- <c:set var="titlePage" value="Ajout d'un Film" scope="session"/> --%>
<c:choose>
	<c:when test="${ error != true }">
	<div class="row">
	  <div class="col-md-4">
	    <img src="${ people.picture }" class="img-fluid" alt="${ people.lastName }">
	  </div>
	
	  <div class="col-md-8">
	    <h3>${ people.firstName } ${ people.lastName } née en ${ people.birthDay }</h3>
	    
		<c:if test="${ sessionScope.user != null  }">
			<jsp:include page="/WEB-INF/layout/LikeDislike.jsp" >
			  <jsp:param name="likeCount" value="${ people.likeCount }" />
			  <jsp:param name="dislikeCount" value="${ people.dislikeCount }" />
			  <jsp:param name="progressBar" value="${ 100*(people.likeCount / (people.likeCount + people.dislikeCount)) }" />
			  <jsp:param name="myVote" value="is-disliked" />
			  <jsp:param name="url" value="&id=${ people.id }&type=movie" />
			</jsp:include>
		</c:if>
		
		<h5>Biographie</h5>
	   
	    <p>${ people.biography }</p>
	  </div>
	</div>
	</c:when>
	<c:otherwise>
		<h1>Personalité Introuvable</h1>
	</c:otherwise>
</c:choose>