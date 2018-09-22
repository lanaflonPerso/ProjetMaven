<div class="row">
	<div class="col-md-12">
		<h1><a href='<c:url value="/user?id=${ message.sender.id }" />'>${ message.sender.firstName } ${ message.sender.lastName }</a></h1>
		
		<div class="col-md-8 offset-md-1">
			<header>
				<p>le <fmt:formatDate type = "both" value = "${ message.createdAt }" /></p>
			</header>
			
			<p>${ message.contents }</p>
			
			<footer>
				<ul class="list-inline">
					<li class="list-inline-item"><a href="<c:url value="/message?id=${ message.sender.id }" />"><button>Repondre</button></a></li>
					<li class="list-inline-item"><a href="<c:url value="/mailbox?status=delete&id=${ message.id }" />"><button>Effacer</button></a></li>
				</ul>
			</footer>
		</div>	
	</div>
</div>
