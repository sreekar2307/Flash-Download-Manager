<%@page import="models.Question"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="models.Reply"%>
<%@ include file="header.jsp"%>
<%
	Question sp = (Question) session.getAttribute("specific_question");
	Date dNow = new Date(sp.getCreated_On().getTime());
	SimpleDateFormat ft = new SimpleDateFormat("dd-MM-YYYY 'at' hh:mm a");
%>
<div class="w-75 mx-auto">
	<div class="mt-5 card">
		<div class="card-header">
			<%=sp.getQuestion_Title()%>
			<div class="float-right">
				Created by:
				<%=sp.getUsername()%></div>
		</div>
		<div class="card-body">
			<p class="card-text">
				<%=sp.getQuestion_Description()%>
			</p>
			<div class="mt-3"><%=ft.format(dNow)%></div>
		</div>
	</div>
	<form  method="post" action="addreply?question_id=<%=request.getParameter("id")%>">
		<div class="form-group mt-4">
			<textarea class="form-control" rows="2" placeholder="Add your reply here" name="reply_desc"></textarea>
			<button class="btn btn-primary float-right mt-2">Reply</button>
		</div>
	</form>

	<button class="btn btn-primary btn-lg mt-3 disabled">Replies</button>
	<%
		ArrayList<Reply> rp = sp.getReplies();
	%>
	<%
		for (int i = rp.size() - 1; i >= 0; i--) {
			dNow = new Date(rp.get(i).getReplied_on().getTime());
	%>
	<div class="mt-3 card">
		<div class="card">
			<div class="card-body">
				<p class="card-text"><%=rp.get(i).getReply_description()%></p>
				<div class="float-right text-muted"><%=rp.get(i).getReplied_by()%></div>
				<div><%=ft.format(dNow)%></div>
			</div>
		</div>
	</div>
	<%
		}
	%>
</div>
<%@ include file="footer.jsp"%>
