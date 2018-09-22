<!DOCTYPE html>
<html lang="fr">

 	<%@ include file="/WEB-INF/layout/Head.jsp" %>
 		
 	<body>
		<%@ include file="/WEB-INF/layout/Menu.jsp" %>
 		
		<div class="container">
		
			<div class="row">

				<div class="col-md-8">
					<c:choose>
						<c:when test="${ not empty page }">
							<% pageContext.include((String) request.getAttribute("page")); %>
						</c:when>
						<c:otherwise>
							<%@ include file="/WEB-INF/view/Home.jsp" %>	
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="col-md-4">
					<%@ include file="/WEB-INF/follower/ViewFollowers.jsp" %>
				</div>
			</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>