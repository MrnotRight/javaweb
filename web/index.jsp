<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
<style type="text/css">
	body,div,p,h1,h2,h3,h4,h5,h6,ol,li,ul,form
    {
	 	margin:0;
	 	padding:0;
	 	word-wrap:break-word; 
    }
	body
    {
		 
		background-color:#FDEABF;
		  
    }
	#banner
	{
		background-image:url(banner.jpg);
		margin:0 auto;
		width:1000px;
		height:300px;
		}
	#navbar
    {
		width:1000px;
	    height:45px;
	    /* background-color:#000;*/
	    margin:0 auto;
	    list-style-type:none;
	    border-left:1px solid #3B9BCB;
	    border-right:1px solid #3B9BCB;
     }
	#navbar li
    {
	    width:200px;
	    height:45px;
	    line-height:45px;   
	    /*background-color:#F90;*/
	    float:left;
	    text-align:center;
	    background-color:#DAF9CA;
    }
	#navbar li a
    {
	    float:left;
	    width:150px;
	    height:45px;
	   /* background-color:#9F0;*/
	    color:#E03636;
	    font-size:large;
	    text-decoration:none;	
	    text-align:center; 
     }
  
	#navbar li a:hover
    {
	   text-decoration:underline;
	   background-color:#FDBC54;
    }
	#navbar li span
    {
	    float:right;
	    height:25px;
	    width:200px;
	    border-right:1px solid #3B9BCB;
	    margin-top:10px;
	}
	h2
	{
		text-align:center;
		margin:20px auto;
		color:#FC3;
		}
	#copyright
		{
		background-repeat:repeat-x;
		height:111px;
		background-image:url(footer.jpg);	
		}
	#copyright p
		{
		height:19px;
		line-height:19px;
		padding-top:40px;
		text-align:center;
		font-size:12px;
		}
	
</style>
</head>

<body topmargin="0">
	<div id="banner"></div>
    <ol id="navbar">                  <!--导航条 -->
    	<li><a href="intorduce.html">996.icu的来源</a><span></span></li>
    	<li><a href="classvsid.html">996.icu的现状</a><span></span></li>
    	<li><a href="classvsid.html">国外人的评价</a><span></span></li>
    	<li><a href="classvsid.html">如何自救！</a><span></span></li>
    	<li><a href="register.jsp">加入我们！</a><span></span></li>
        <!--  <li><a href="classvsid.html">更多</a></li>-->
  	</ol>
  	<!-- 图片 -->

  	<center><img src="996_icon.png" alt="996" width="1000px" height="600px"/></center>
    <div id="copyright">
	<p>版权所有：西南大学 Mr_NotRight</p>
    <p style="padding-top:0;">联系我们：| 地址:重庆北碚天生路2号 | 邮编：400100</p>
	</div>
</body>
</html>
