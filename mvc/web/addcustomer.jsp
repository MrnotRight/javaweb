<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddCustomer</title>
</head>
<body>
<form action="add.do" method="post">
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
			<input type="submit" value="Add" >
		</label>
	</form>
	
</body>
</html>
