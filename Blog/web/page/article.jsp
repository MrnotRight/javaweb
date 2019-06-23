<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.title} | MyBlog</title>
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->

<!-- 引入本页面的特殊样式 -->
<link type="text/css" rel="stylesheet" href="./css/article.css" />
<link type="text/css" rel="stylesheet" href="./css/comment.css" />

<script src="./js/article.js"></script>
</head>
<body>
	<div class="head_line"></div>
	<div class="container" id="main">

		<div class="head">
			<div id="title">
				<h2>
					<a href="/Blog/index.jsp">MyBlog</a>
				</h2>
			</div>
		</div>

		<div id="article">

			<div id="a_head ">
				<h3>${article.title}</h3>
				<br />
				<div>
					<h5>
						<span>${article.time}</span> <a href="/Blog/SortServlet?get=${article.sort}">${article.sort}</a>
					${article.author}
					</h5>
				</div>
				<div class="r_div">
					<h5>
						<span class="glyphicon glyphicon-eye-open">&nbsp;${article.visit}&nbsp;</span>						
					</h5>
				</div>
			</div>
		</div>
			<div class="line"></div>



			<div id="a_content">
			<!-- 引入 show.jsp 显示文章内容 ${article.content}-->
			<jsp:include page="/page/show.jsp"/>			
			</div>


			<div>
				<div class="f_div">
					<span class="glyphicon glyphicon-chevron-left"></span>
					
					
					<c:choose>
						<c:when test="${article_pre!=null}">
							<a href="/Blog/ArticleServlet?id=${article_pre.id}">&nbsp;上一篇:${article_pre.title}</a>
						</c:when>					
						<c:otherwise>
							&nbsp;没有更早的文章了
						</c:otherwise>					
					</c:choose>
					
				</div>				
				<div class="r_div">
				
						<c:choose>
						<c:when test="${article_next!=null}">
							<a href="/Blog/ArticleServlet?id=${article_next.id}">下一篇:&nbsp;${article_next.title}</a>
						</c:when>					
						<c:otherwise>
							&nbsp;没有更多的文章了
						</c:otherwise>					
					</c:choose>
						
					<span class="glyphicon glyphicon-chevron-right"></span>
				</div>
									
				<br/>
			</div>
			
			<div class="line"></div>
							
			
	<div id="footer">	
	<a href="/Blog/index.jsp">MyBlog首页&nbsp;&nbsp;</a>|
	<a href="#">&nbsp;&nbsp;返回顶部</a>
	</div>
	<!-- footer -->
</body>
</html>