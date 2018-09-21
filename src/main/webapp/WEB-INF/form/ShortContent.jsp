<form class="form-inline" method="post" action="<c:url value="/shortcontent"/>">
	<fieldset class="form-group">
		<legend>Ajouter un message sur le mur</legend>
		<p>erreur= ${ error.error } ${ error.msgShortContent }</p>
		<c:if test="${ error.error }">
			<p class="text-danger">${ error.msgShortContent }</p>
		</c:if>
		<textarea class="form-control" id="messageForm" name="shortContent" rows="3" cols="50">${ error.shortContent }</textarea>
		<button type="submit" class="btn btn-primary">Envoyer</button>
	</fieldset>    
</form>