<c:set var="titlePage" value="Ecrire un message" scope="session"/>
<form method="post" action="">
	<fieldset class="form-group">
		<legend>${ titlePage }</legend>
		
		<input class="form-control" id="receiver" type="hidden" name="receiver" value="${ receiverId }">

		<div class="form-group">
			<label for="contents">Contenu: </label>
			<small class="text-danger ">${ error.msgContents }</small>
			<textarea class="form-control" id="contents" name="contents" rows="3"></textarea>
		</div>
		
		<button type="submit" class="btn btn-primary">Envoyer</button>
	</fieldset>    
</form>