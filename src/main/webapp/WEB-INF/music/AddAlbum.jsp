<c:set var="titlePage" value="Ajout d'un Album" scope="session"/>
<form method="post" action="">
	<fieldset class="form-group">
		<legend>${ titlePage }</legend>
		
		<div class="form-group">
			<label for="bandName">Groupe: </label>
			<small class="text-danger">${ error.msgbandName }</small>
			<input class="form-control" id="bandName" type="text" name="bandName" value="${ error.album.bandName }">
		</div>
		
		<div class="form-group">
			<label for="title">Titre: </label>
			<small class="text-danger">${ error.msgTitle }</small>
			<input class="form-control" id="title" type="text" name="title" value="${ error.album.title }">
		</div>
		
		<div class="form-group">
			<label for="releaseDate">Année: </label>
			<small class="text-danger">${ error.msgReleaseDate }</small>
			<input class="form-control" id="releaseDate" type="text" name="releaseDate" value="${ error.album.releaseDate }" minlength="4" maxlength="4" pattern="[0-9]{4}">
		</div>
		
		<div class="form-group">
			<label for="picture">Pochette: </label>
			<small class="text-danger ">${ error.msgPicture }</small>
			<input class="form-control" id="picture" type="text" name="picture" value="${ error.album.picture }">
		</div>
		
		<button type="submit" class="btn btn-primary">Enregistrement</button>
	</fieldset>    
</form>
