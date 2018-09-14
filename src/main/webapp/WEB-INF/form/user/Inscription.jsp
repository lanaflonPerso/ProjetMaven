<div class="row">
	<form method="post" action="">
		<fieldset class="form-group">
			<legend>Connection</legend>
			
			<div class="form-group row">
				<div class="col-md-12">
					<small class="text-danger">${ error.msgLastName }</small>
				</div>
				<label class="col-md-5 col-form-label" for="lastName">Nom: </label>
				<div class="col-md-7">
					<input id="lastName" type="text" name="lastName" value="${ user.lastName }">
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-md-12">
					<small class="text-danger">${ error.msgFirstName }</small>
				</div>
				<label class="col-md-5 col-form-label" for="firstName">Prénom: </label>
				<div class="col-md-7">
					<input id="firstName" type="text" name="firstName" value="${ user.firstName }">
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-md-12">
					<small class="text-danger ">${ error.msgEmail }${ error.msgUser }</small>
				</div>
				<label class="col-md-5 col-form-label" for="email">Email: </label>
				<div class="col-md-7">
					<input id="email" type="email" name="email" value="${ user.email }">
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-md-12">
					<small class="text-danger ">${ error.msgPassword }</small>
				</div>
				<label class="col-md-5 col-form-label" for="password">Mot de Passe: </label>
				<div class="col-md-7">
					<input id="password" type="password" name="password">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-md-5 col-form-label" for="passwordC">Confirmation</label>
				<div class="col-md-7">
					<input id="passwordC" type="password" name="passwordC">
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary">Connection</button>
		</fieldset>    
	</form>
</div>