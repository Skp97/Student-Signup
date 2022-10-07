<%@page import="com.ty.dto.Student"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2px">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Address</th>
			<th>Phoneno</th>
			<th>Email</th>
			<th>Delete</th>
		</tr>
		<%
		List<Student> list = (List) request.getAttribute("list");
		%>
		<%
		for (Student s : list) {
		%>

		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getAge()%></td>
			<td><%=s.getAddress()%></td>
			<td><%=s.getPhoneno()%></td>
			<td><%=s.getEmail()%></td>
			<td><a href="delete?id=<%=s.getId()%>">delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>