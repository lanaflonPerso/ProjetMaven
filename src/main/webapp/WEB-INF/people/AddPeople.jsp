<c:set var="titlePage" value="Ajout d'une personnalité" scope="session"/>
<form method="post" action="">
	<fieldset class="form-group">
		<legend>${ titlePage } <small class="text-danger">${ error.msg }</small></legend>
		
		<div class="form-group">
			<label for="lastName">Nom: </label>
			<small class="text-danger">${ error.msgLastName }</small>
			<input class="form-control" id="lastName" type="text" name="lastName" value="${ error.people.lastName }">
		</div>
		
		<div class="form-group">
			<label for="firstName">Prénom: </label>
			<small class="text-danger">${ error.msgFirstName }</small>
			<input class="form-control" id="firstName" type="text" name="firstName" value="${ error.people.firstName }">
		</div>
		
		<div class="form-group">
			<label for="birthDay">Date de naissance: </label>
			<small class="text-danger ">${ error.msgBirthDay }</small>
			<input class="form-control" id="birthDay" type="text" name="birthDay" value="${ error.people.birthDay }">
		</div>
		
		<div class="form-group">
			<label for="picture">Photo: </label>
			<small class="text-danger ">${ error.msgPicture }</small>
			<input class="form-control" id="picture" type="text" name="picture" value="${ error.people.picture }">
		</div>
		
		<div class="form-group">
			<label for="biography">Biography: </label>
			<small class="text-danger ">${ error.msgBiography }</small>
			<textarea class="form-control" id="biography" name="biography" rows="3">${ error.people.biography }</textarea>
		</div>
		
		<button type="submit" class="btn btn-primary">Enregistrement</button>
	</fieldset>    
</form>