<%@ include file="header.jsp"%>


	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous">


 <form action="BugReport"  method="POST" class="w-75 mx-auto mt-5 border p-4">
    <% if(session.getAttribute("User")==null) {%>
     <p class="text-danger">*Login Required.</p>
     <% }%>
        <h1 class="mb-4">Bug Report</h1>
		<div class="form-group">
			<label for="BugReportTitle">Title</label> <input
				type="text" class="form-control" name="BugReportTitle"
			   placeholder="Write a descriptive title" required> 
		</div>
		<div class="form-group">
			<label for="BugReportDescription">Description</label> <input
				type="text" class="form-control" name="BugReportDescription"
				placeholder="Provide supporting details or context" required>
		</div>
		<input type="submit" class="btn btn-primary">
</form>
<%@ include file="footer.jsp"%>