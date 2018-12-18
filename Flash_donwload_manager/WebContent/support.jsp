<%@ page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ page import="models.Thread"%>
<%@ include file="header.jsp"%>
<div class="mx-auto mt-5 w-75">
	<%
			ArrayList<Thread> result = (ArrayList<Thread>)session.getAttribute("Thread_list");
		%>
	<a href="#" class="question_button btn btn-primary mb-5">Ask a Question</a>
	<form class="question mb-5 pb-5" style="display:none;" method="POST" action="new_question">
	    <p class="text-danger">*Login Required.</p>
		<div class="form-group">
			<label for="title">Question Title</label> <input
				type="text" class="form-control" name="title" required>
		</div>
		<div class="form-group">
			<label for="desc">Question Description</label>
			<textarea class="form-control" id="desc"
				rows="3" name="desc" required></textarea>
		</div>
		 <button type="submit" class="btn btn-primary float-right">Add Question</button>
	</form>
	<%
		for (int i = result.size()-1; i >=0; i--) {
			Date dNow = new Date(result.get(i).getCreated_On().getTime());
			SimpleDateFormat ft = new SimpleDateFormat("dd-MM-YYYY 'at' hh:mm a");	 
	    %>
	<div class="mb-5 card">
		<div class="card-header">
			<%=result.get(i).getQuestion_Title()%>
			<div class="float-right">
				Created by:
				<%=result.get(i).getUsername()%></div>
		</div>
		<div class="card-body">
			<p class="card-text"><%=result.get(i).getQuestion_Description()%></p>
			<div>
				<a href="question?question_id=<%=result.get(i).getQuestion_Id()%>" class="btn btn-primary">See replies</a>
			</div>
			<div class="float-right btn-group" role="group"
				aria-label="Third group">
				<a href="question?question_id=<%=result.get(i).getQuestion_Id()%>" class="btn btn-secondary"><%=result.get(i).getReply_count() %></a>
			</div>
			<div class="mt-3"><%=ft.format(dNow)%></div>
		</div>
	</div>
	<%
		}
	%>
</div>
<%@ include file="footer.jsp"%>
<script type="text/javascript">
var question_button = document.querySelector(".question_button");
var question = document.querySelector(".question");
var flag=true; 
question_button.addEventListener("click",function(){
	 if(flag)
		 question.style.display = "block";
	 else
		 question.style.display = "none";
	 flag = !flag;
});
document.querySelector(".support").classList.add("active");
</script>
