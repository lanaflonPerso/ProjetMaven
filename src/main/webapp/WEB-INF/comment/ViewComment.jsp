<div class="row">

	<div class="col-md-12">
		<%@ include file="/WEB-INF/comment/FormComment.jsp" %>	
	</div>

	<div style="background-color: #ffece6; margin: 20px;" class="col-md-12">
		<p><a href='<c:url value="/user?id=${ brick.user.id }" />'>${ brick.user.firstName } ${ brick.user.lastName }</a> ${ brick.html }</p>
		
		<c:forEach items="${ brick.comments }" var="comment">
			<p><a href='<c:url value="/user?id=${ comment.user.id }" />'>${ comment.user.firstName } ${ comment.user.lastName }</a></p>
			<p>${ comment.contenu }</p>
		</c:forEach>
	</div>
</div>