<%@page import="models.BugReport"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ include file="header.jsp"%>
<%
	ArrayList<BugReport> result = (ArrayList<BugReport>) session.getAttribute("processing_bugs");
%>
<div class="mx-auto w-75 mt-5">
	<%
		for (int i = result.size() - 1; i >= 0; i--) {
			Date dNow = new Date(result.get(i).getBugCreatedAt().getTime());
			SimpleDateFormat ft = new SimpleDateFormat("dd-MM-YYYY 'at' hh:mm a");
	%>
	<div class="mb-5 card">
		<div class="card-header">
			<%=result.get(i).getBugReportTitle()%>
			<div class="float-right">
				Created by:
				<%=result.get(i).getUsername()%></div>
		</div>
		<div class="card-body">
			<p class="card-text"><%=result.get(i).getBugReportDescription()%></p>
			<div>
				<a href="delete?id=<%=result.get(i).getBugId()%>"
					class="btn btn-primary">Delete</a>
			</div>
			<div class="mt-3"><%=ft.format(dNow)%></div>
		</div>
	</div>
	<%
		}
	%>

</div>
<%@ include file="footer.jsp"%>
