<%-- <c:set var="titlePage" value="Ajout d'un Film" scope="session"/> --%>
<c:choose>
	<c:when test="${ error != true }">
		<div class="row">
			<div class="col-md-4">
		    
			</div>
		
			<div class="col-md-8">
				<h3>${ searchedUser.firstName } ${ searchedUser.lastName } </h3>
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