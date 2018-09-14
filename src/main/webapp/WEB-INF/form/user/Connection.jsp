<div class="row">
  <div class="col-md-4">
    
  </div>

  <div class="col-md-8">
	<div class="row">
		
		<div class="col-md-12">
			<c:if test="${ error != null }">
				<div class="alert alert-danger" role="alert">
					<p>${ error }</p>
				</div>
			</c:if>
			
			<form method="post" action="">
				<fieldset class="form-group">
					<legend>Connection</legend>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="email">Email</label>
						<div class="col-md-10">
							<input id="email" type="text" name="email">
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="password">Mot de passe: </label>
						<div class="col-md-10">
							<input id="password" type="password" name="password">
						</div>
					</div>
					
					<button type="submit" class="btn btn-primary">Connection</button>
				</fieldset>    
			</form>
		</div>
		
		<div class="col-md-12">
			<p><a href="<c:url value="/user/inscription" />">Pas encore inscrit?</a></p>
		
		</div>
	</div>
  </div>
</div>
