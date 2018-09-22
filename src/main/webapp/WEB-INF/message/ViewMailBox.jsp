<div class="row">
	<c:if test="${ status }">
		<div class="md-col-12">
			<p class="alert alert-success">Le message a bien etait envoyer</p>
		</div>
	</c:if>
	
	<div class="col-md-12">
		<table class="table">
			<thead>
				<tr>
					<td>Expediteur</td>
					<td>Date</td>
					<td>contenu</td>
					<td>Effacer</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${ messages }" var="message">
					<tr>
						<td><a href='<c:url value="/user?id=${ message.sender.firstName }" />'>${ message.sender.firstName } ${ message.sender.lastName }</a></td>
						<td><fmt:formatDate type = "both" value = "${ message.createdAt }" /></td>
						<td>${ message.introContents }</td>
						<td><a href="<c:url value="/mailbox?status=delete&id=${ message.id }" />"><button>Effacer</button></a>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	</div>
</div>
