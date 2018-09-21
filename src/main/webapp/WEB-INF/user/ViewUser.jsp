<%-- <c:set var="titlePage" value="Ajout d'un Film" scope="session"/> --%>
<c:choose>
	<c:when test="${ error != true }">
		<div class="row">
			<div class="col-md-4">
		    
			</div>
		
			<div class="col-md-8">
				<h3>${ searchedUser.firstName } ${ searchedUser.lastName } </h3>
				
				<c:if test="${ sessionScope.user != null  }">
					<jsp:include page="/WEB-INF/layout/LikeDislike.jsp" >
					  <jsp:param name="likeCount" value="${ searchedUser.likeCount }" />
					  <jsp:param name="dislikeCount" value="${ searchedUser.dislikeCount }" />
					  <jsp:param name="progressBar" value="${ 100*(searchedUser.likeCount/(searchedUser.likeCount+searchedUser.dislikeCount)) }" />
					  <jsp:param name="myVote" value="is-disliked" />
					  <jsp:param name="url" value="&id=${ searchedUser.id }&type=user" />
					</jsp:include>
				</c:if>
				
				<%-- <c:forEach items="${ bricks }" var="brick">
					${ brick.html }
				</c:forEach> --%>
				<%@ include file="/WEB-INF/wall/ViewBrick.jsp" %> 
			</div>
		</div>
		
	</c:when>
	<c:otherwise>
		<h1>Utilisateur Introuvable</h1>
	</c:otherwise>
</c:choose>