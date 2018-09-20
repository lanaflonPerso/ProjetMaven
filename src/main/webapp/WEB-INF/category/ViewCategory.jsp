<%-- <c:set var="titlePage" value="Ajout d'un Film" scope="session"/> --%>
<c:choose>
	<c:when test="${ error != true }">
		<div class="row">
		  <div class="col-md-4">
		   
		  </div>
		
			<div class="col-md-8">
				<h3>${ category.name }</h3>
	
				<c:if test="${ sessionScope.user != null  }">
					<jsp:include page="/WEB-INF/layout/LikeDislike.jsp" >
					  <jsp:param name="likeCount" value="${ category.likeCount }" />
					  <jsp:param name="dislikeCount" value="${ category.dislikeCount }" />
					  <jsp:param name="progressBar" value="${ 100*(category.likeCount/(category.likeCount+category.dislikeCount)) }" />
					  <jsp:param name="myVote" value="is-disliked" />
					  <jsp:param name="url" value="&id=${ category.id }&type=category" />
					</jsp:include>
				</c:if>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<h1>Categorie Introuvable</h1>
	</c:otherwise>
</c:choose>