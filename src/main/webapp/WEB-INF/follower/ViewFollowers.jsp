<ul>
	<c:forEach items="${ followers }" var="follower">
		<li><a href='<c:url value="/user?id=${ follower.id }" />' >${ follower.firstName } ${ follower.lastName }</a></li>	
	</c:forEach>
</ul>