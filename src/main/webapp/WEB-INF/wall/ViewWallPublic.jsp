<form class="form-inline" method="post" action="<c:url value="/shortcontent"/>">
	<fieldset class="form-group">
		<legend>Ajouter un message sur le mur</legend>
		<textarea class="form-control" id="messageForm" name="contenu" rows="3" cols="50"></textarea>
		<button type="submit" class="btn btn-primary">Envoyer</button>
	</fieldset>    
</form>

<c:forEach items="${ bricks }" var="brick">
	<div class="row">
		<div style="background-color: #ffece6; margin: 20px;" class="col-md-12">
			<header class="headerMessage">
				<span>
				<%-- 	<c:if test = "${ prive }"> --%>
						 <c:choose>
							<c:when test="${ brick.share }">
								<a href="<c:url value = "/wall?id=${ brick.id }&partage=0" />">partage plus</a>
							</c:when>

							<c:otherwise>
								<a href="<c:url value = "/wall?id=${ brick.id }&partage=1"/>">on partage</a>
							</c:otherwise>
						</c:choose>
				<%-- 	</c:if> --%>
					
				</span>
			</header>
			<p>${ brick.html }</p>
			<footer class="footerMessage">
				<span>il y a environ une heure</span>
				<span><a href="<c:url value = "" />">J'aime</a></span>
				<span><a href="<c:url value = "" />">Commenter</a></span>
				<span><a href="<c:url value = "" />">Afficher le suivi</a></span>
			</footer>
		</div>
	</div>
</c:forEach>