<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标签 | MyBlog</title>


<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">


<link type="text/css" rel="stylesheet" href="/Blog/css/public.css" />
<link type="text/css" rel="stylesheet" href="/Blog/css/tags.css" />
<style type="text/css">
@CHARSET "UTF-8";

.tags_name{
	margin-top:15px;
	margin-bottom:15px;
	text-align:left;
	margin-left:20px;	
}


@CHARSET "UTF-8";

body {
	background: #eee;
}

a:link {
	text-decoration: none;
}

.c_center {
	text-align: center;
}

.c_left {
	text-align: left;
}

.c_right {
	text-align: right;
}

.f_div {
	float: left;
}

.r_div {
	float: right;
}

.head_line {
	border-bottom: 1px solid #177cb0;
}

.foot_line {
	border-top: 1px solid #C0C0C0;
	margin-bottom: 20px;
}

.inline {
	display: inline;
	float: left;
	margin-left: 23px;
	margin-right: 25px;
	margin-bottom: 20px;
}

#main {
	width: 68%;
}

#content {
	text-align: center;
	clear: both;
}

#list {
	margin-top: 10px;
}

#tag {
	margin-top: 50px;
}

#footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	clear: both;
	text-align: center;
}
</style>
</head>
<body>
	<div class="head_line"></div>

	<div class="container" id="main">

		<div id="header"></div>

		<div class="row c_center">
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2>
						<a href="/Blog/index.jsp">MyBlog</a>
					</h2>
					<h5 class="text-muted">Rise and rise again until lambs become lions</h5>
				</div>

				<div class="c_center" id="person_info">
					<img src="/Blog/img/header.jpg" height="130" width="130"
						alt="what?" class="img-circle">
					<h5 class="text-muted">托遗响于悲风</h5>
				</div>


				<div id="list">
					<table class="table table-hover c_center">
						<tr>
							<td><a href="/Blog/index.jsp	"><span class="glyphicon glyphicon-home"></span>
								&nbsp;&nbsp;首页</a></td>
						</tr>
						<tr>	
							<td><a href="/Blog/SortServlet?get=all"><span class="glyphicon glyphicon-list"></span>
								&nbsp;&nbsp;分类</a></td>
						</tr>
						<tr>
							<td class="active"><a href="/Blog/TagsServlet?get=all"><span class="glyphicon glyphicon-tags"></span>
								&nbsp;&nbsp;标签</a></td>
						</tr>						
						<tr>
							<td><a href="/Blog/AxisServlet"><span class="glyphicon glyphicon-book"></span>
								&nbsp;&nbsp;时间轴</a></td>
						</tr>
						<tr>
							<td><a href="/Blog/page/about.html"><span class="glyphicon glyphicon-user"></span>
								&nbsp;&nbsp;关于</a></td>
						</tr>
					</table>
				</div>
				<!-- list -->
				<br />
			</div>
			<div class="col-md-2" id="center_content"></div>
			<div class="col-md-7 " id="right_content">
				<br /><br />
				<div class="list-group">

					<a href="#" class="list-group-item active">标签</a>
					<!-- 这里初始化标签 -->					
					<c:forEach var="map" items="${id_tag_map}">					
					<div class="tags_name">
					<!-- 标签名字 -->
					<span class="glyphicon glyphicon-triangle-bottom"></span>&nbsp;	&nbsp;${map.key}		
					</div>
					<div>
					<!-- 标签信息 -->
					<ul class="list-group">					
					<c:forEach var="list" items="${map.value}">
					<li class="list-group-item">
								<div>
									<div>
									<div>
										<a href="./ArticleServlet?id=${list.id}">${list.title}</a>
									</div>
									<div class="c_right">
									<img src="./img/time.png">
									${list.time}&nbsp;&nbsp; 
									<span class="visit"><img src="/Blog/img/visit.png">
									${list.visit}	</span>
									</div>
								</div>						
								</div>
					</li>
					</c:forEach>					
					</ul>
					</div>								
					</c:forEach>					
					<!-- 初始化标签完成 -->

				</div>
			</div>
		</div>

		<div class="foot_line"></div>
	</div>
	<!-- container -->


	<div id="footer">
		<a href="#">&nbsp;&nbsp;MyBlog</a>
	</div>
	<!-- footer -->

</body>
</html>