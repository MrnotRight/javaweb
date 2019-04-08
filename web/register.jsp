<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">    
<link href="signin.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">
	body{
		margin:0;
		padding :0;
		background-image:url("register_background.jpg") ;
		background-reapet:no-repeat;
		background-position:50% 50%;
		background-size:cover;
		
	}
	#copyright
		{
		width:100%;
		background-repeat:repeat-x;
		height:111px;
		background-image:url(footer.jpg);
		position:fixed;
		bottom:0;	
		}
	#copyright p
		{
		height:25px;
		line-height:25px;
		padding-top:40px;
		text-align:center;
		font-size:12px;
		}
	
</style>
</head>
<body bgcolor="#666666">
<div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading" style="color:#FFFAFA ">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
            <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label  style="color:#FFFAFA ;font-size:1.5em;line-height:1em">
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>

    </div> <!-- /container -->
    
<div id="copyright">
	<p>版权所有：西南大学 Mr_NotRight</p>
	<br>
    <p style="padding-top:0;">联系我们：| 地址:重庆北碚天生路2号 | 邮编：400100</p>
</div>
</body>
</html>