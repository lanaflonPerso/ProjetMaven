<c:set var="titlePage" value="Ajout d'un Film" scope="session"/>
<form method="post" action="">
	<fieldset class="form-group">
		<legend>${ titlePage }</legend>
		
		<div class="form-group">
			<label for="title">Titre: </label>
			<small class="text-danger">${ error.msgTitle }</small>
			<input class="form-control" id="title" type="text" name="title" value="${ movie.title }">
		</div>
		
		<div class="form-group">
			<label for="releaseDate">Année: </label>
			<small class="text-danger">${ error.msgReleaseDate }</small>
			<input class="form-control" id="releaseDate" type="text" name="releaseDate" value="${ movie.releaseDate }">
		</div>
		
		<div class="form-group">
			<label for="picture">Pochette: </label>
			<small class="text-danger ">${ error.msgPicture }</small>
			<input class="form-control" id="picture" type="text" name="picture" value="${ movie.picture }">
		</div>
		
		<div class="form-group">
			<label for="synopsis">Synopsis: </label>
			<small class="text-danger ">${ error.msgSynopsis }</small>
			<textarea class="form-control" id="synopsis" name="synopsis" rows="3">${ movie.synopsis }</textarea>
		</div>
		
		<button type="submit" class="btn btn-primary">Enregistrement</button>
	</fieldset>    
</form>
