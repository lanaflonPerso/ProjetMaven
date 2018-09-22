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
					<td>Repondre</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${ messages }" var="message">
					<tr>
						<td><a href='<c:url value="/user?id=${ message.sender.id }" />'>${ message.sender.firstName } ${ message.sender.lastName }</a></td>
						<td><fmt:formatDate type = "both" value = "${ message.createdAt }" /></td>
						<td><a href="<c:url value="/mailbox/view?id=${ message.id }" />">${ message.introContents }</a></td>
						<td><a href="<c:url value="/mailbox?status=delete&id=${ message.id }" />"><button>Effacer</button></a></td>
						<td><a href="<c:url value="/message?id=${ message.sender.id }" />"><button>Repondre</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	</div>
</div>
