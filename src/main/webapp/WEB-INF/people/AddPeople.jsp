<c:choose>
	<c:when test="${ param.function == 'actor' }">
		<c:set var="titlePage" value="Ajout d'un Acteur" scope="session"/>
	</c:when>
</c:choose>



<form method="post" action="">
	<fieldset class="form-group">
		<legend>${ titlePage }</legend>
		
		<input type="hidden" value="${ param.id }" name="id" />
		<input type="hidden" value="${ param.type }" name="type" />
		<input type="hidden" value="${ param.function }" name="type" />
		
		<div class="form-group">
			<label for="lastName">Nom: </label>
			<small class="text-danger">${ error.msgLastName }</small>
			<input class="form-control" id="lastName" type="text" name="lastName" value="${ people.lastName }" />
		</div>
		
		<div class="form-group">
			<label for="firstName">Prenom: </label>
			<small class="text-danger">${ error.msgFirstName }</small>
			<input class="form-control" id="firstName" type="text" name="firstName" value="${ people.firstName }">
		</div>
		
		<div class="form-group">
			<label for="picture">Photo: </label>
			<small class="text-danger ">${ error.msgPicture }</small>
			<input class="form-control" id="picture" type="text" name="picture" value="${ movie.picture }">
		</div>
		
		<div class="form-group">
			<label for="biography">Biographie: </label>
			<small class="text-danger ">${ error.biography }</small>
			<textarea class="form-control" id="biography" name="biography" rows="3">${ people.biography }</textarea>
		</div>
		
		<button type="submit" class="btn btn-primary">Enregistrement</button>
	</fieldset>    
</form>
