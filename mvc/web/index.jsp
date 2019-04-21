<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.swu.mvcapp.domain.Customer"  %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MvcApp</title>
<style>
	body{
		font-size:14px;
	}
	label span{
		display:inline-block;
		width:100px;
	}
	label input{
		display:inline-block;
		width:100px;
	}
</style>
</head>
<body>
	<form action="query.do" method="post">
		<label>
			<span>Name</span>
			<input type="text" name="name"/>
		</label><br>
		<label>
			<span>Address</span>
			<input type="text" name="address"/>
		</label><br>
		<label>
			<span>Phone</span>
			<input type="text" name="phone"/>
		</label><br>
		<label>
			<input type="submit" value="Submit" >
		</label>
		<a href="addcustomer.jsp">Add new</a>
	</form>
	
	<br/>
	<hr/>
	<br/>
	<%
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
		if(customers != null && customers.size() > 0){
	%>
		<table>
			<tr>
				<th>ID</th><th>Name</th><th>Address</th><th>Phone</th><th>Delete/Update</th>
			</tr>
			<% 
				for(Customer customer:customers){ 
			%>
					<tr>
						<td><%=customer.getId() %></td>
						<td><%=customer.getName() %></td>
						<td><%=customer.getAddress() %></td>
						<td><%=customer.getPhone() %></td>
						<td>
							<a href="delete.do?id=<%=customer.getId() %>">Delete</a>
							<a href="update.jsp?id=<%=customer.getId() %>">Update</a>
						</td>
					</tr>
			<%	
				} 
			%>
		</table>
	<%
		} 
	%>
	
</body>
</html>
