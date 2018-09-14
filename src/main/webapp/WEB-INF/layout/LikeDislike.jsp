<c:choose>
	<c:when test="${ param.progressBar=='NaN' }">
		<c:set var="progressBar" scope ="session" value="50"/>
	</c:when>
	<c:otherwise>
		<c:set var="progressBar" scope ="session" value="${ param.progressBar }"/>
	</c:otherwise>
</c:choose>


<div class="vote ${ param.myVote }">
	<div class="vote_bar">
		<div class="vote_progress" style="width:${ progressBar }%;"></div>
	</div>

	<div class="vote_btns">

		<form action='<c:url value="/like?like=1${ param.url }" />' method="post">
			<button type="submit" class="vote_btn vote_like"><i class="fa fa-thumbs-up">${ param.likeCount }</i></button>
		</form>		

		<form action="<c:url value="/like?like=-1${ param.url }" />" method="post">
			<button type="submit" class="vote_btn vote_dislike"><i class="fa fa-thumbs-down">${ param.dislikeCount }</i></button>
		</form>

	</div>
</div>