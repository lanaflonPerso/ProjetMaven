<form class="form-inline" method="post" action="<c:url value="/comment" />">
	<fieldset class="form-group">
		<legend>Commantaire</legend>
		<c:if test="${ error.error }">
			<p class="text-danger">${ error.msgContenu }</p>
		</c:if>
		
		<input type="hidden" name="id" value="${ brick.id }" />
		<textarea class="form-control" id="messageForm" name="comment" rows="3" cols="50">${ error.comment.contenu }</textarea>
		<button type="submit" class="btn btn-primary">Envoyer</button>
	</fieldset>    
</form>
