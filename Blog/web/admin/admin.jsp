<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理 | MyBlog</title>


<!-- Bootstrap core CSS -->
<link	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->

<link type="text/css" rel="stylesheet" href="./css/public.css" />
<link type="text/css" rel="stylesheet" href="./css/admin.css" />

<script src="./js/admin.js"></script>
</head>
<body>
	<div class="head_line"></div>
	<div class="container" id="main">
				
		<div id="header">
			<div>
				<h2><a href="/Blog/login.html">MyBlog-管理</a></h2>
				</div>		
		</div>
				 
				 <div class="admin_div">
				<h4 class="btn btn-default">统计</h4>
				<h5> 被访问了 ${visited } 次</h5>
				<h5> 一共有 ${member}个访问者</h5>    
				
				</div>
				<div class="admin_div">
				<h4 class="btn btn-default">管理日志</h4>
				
				<c:forEach var="a" items="${articles}">				
				<div class="list-group-item">						
						<span>${a.title}</span>
						 <div class="r_div">	
						 <span>${a.time}</span>
						 
						 <a href="/Blog/AdminDataServlet?op=edit_article&&article_id=${a.id}">
						 <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil" style="color:#5bc0de" >编辑</span>&nbsp;</button>
						 </a>
						 
						 <button class="btn btn-default">&nbsp;
						 <span class="glyphicon glyphicon-trash" style="color:#d9534f" onclick="delete_article(this,'${a.id}')"> 删除</span>&nbsp;</button>
						 </div>										 
				</div>							
				</c:forEach>					
				</div>		
	<div id="footer">		
		<a href="/Blog/index.jsp">&nbsp;&nbsp;MyBlog</a>	
	</div> 		
	
</body>
</html>