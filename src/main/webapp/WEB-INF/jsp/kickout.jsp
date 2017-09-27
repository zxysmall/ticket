<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
 <link rel="icon" type="image/x-icon" href="favicon.ico">
 <%@include  file="commen.jsp" %>
<style>
/* background-position: center 24%; */
body{margin:0;background-color: #f5f5f5;background-image:url(image/background2.jpg);right-border：none;background-size:100% auto;background-repeat: no-repeat;background-position: 100% 10%;}
*{font-family:Gill Sans, Gill Sans MT, Myriad Pro, DejaVu Sans Condensed, Helvetica, Arial,' sans-serif'}
body{margin:0;background-color: #f5f5f5;}
	a{text-decoration: none;}
img{border:none;}
::-webkit-input-placeholder { /* WebKit browsers */  
    color:    #d1d1d1;  
}  
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */  
   color:    #d1d1d1;  
   opacity:  1;  
}  
::-moz-placeholder { /* Mozilla Firefox 19+ */  
   color:    #d1d1d1;  
   opacity:  1;  
}  
:-ms-input-placeholder { /* Internet Explorer 10+ */  
   color:    #d1d1d1;  
}
.top_box{background-color:white;}
.top_nav{margin-left:auto;margin-right:auto;width:50%;padding-top: 10px;}
.top_nav a{float:left;}
.top_nav .logo{padding-right: 16px;border-right:1px solid #b2b2b2;}
.top_nav .welcome{font-size: 28px;line-height: 76px;text-decoration: none;padding-left: 16px;color:#333333;}
.clearfix{clear:both;}
.login_bg_box{background-color: #f5f5f5;}
.login_sm_box{margin-left:auto;margin-right:auto;width:1000px;}
.login_box{width: 560px;height: 450px;background-color: white;border-radius: 20px;margin-left: 544px;margin-top:158px;position: absolute;}
.login_box .user{margin-left:auto;margin-right:auto;color: #0087cf;font-size: 24px;padding-top:5%;padding-bottom: 8px;border-bottom: 2px solid #0087cf;width: 96px;color: #0087cf;}
input[type=password],input[type=text]{height:54px;border: 2px solid #d1d1d1;font-size: 22px;position: relative;left: 50%;margin-left: -213px;display: block;border-radius: 4px;color: #d1d1d1; width: 366px;padding-left: 1.5cm;}
input[type=submit]{width:426px;height:56px;left: 50%;margin-left:-213px;display: block;position: relative;margin-top: 20px;background-color: #0087cf;font-size: 22px;color:white;border-radius: 4px;;border:none;text-align: center;}
input[type=text]{margin-top: 40px;background-image: url(image/user_icon.png);background-repeat: no-repeat;background-position: 14px center;}
input[type=password]{margin-top:20px;background-image: url(image/password_icon.png);background-repeat: no-repeat;background-position: 14px center;}
.help_box{width: 426px;margin-top:22px;position: absolute;left: 50%;margin-left:-213px;}
.help_box a{float:right;font-size: 18px;}
.help_box span{font-size: 18px;float: left;margin-left: 6px;}
label{margin:0; padding:0; outline:none;}
input[type=checkbox]{height: 26px;width:18px;margin:0; padding:0; outline:none;float:left;}
.help_box .forget{padding-left: 12px;color: #0087cf;} 
.error{
	color:red;
	padding-left: 80px;
}

.text{border:solid 2px #ccc;width:400px;height:40px;background:url(http://d.lanrentuku.com/down/png/1211/blueberry/user_friend.png) no-repeat 0 center;}
.text input{float:left;border:none;background:none;height:40px;line-height:30px;width:100%; text-indent:32px;}

</style>
</head>
<body>
<div class="top_box">
          <div class="top_nav">
          	<a href="" class="logo"><img src="image/logo.png"></a>
          	<a href="" class="welcome">票务系统-登录</a>
          	<div class="clearfix"></div>
          </div>
	 </div>
<div class="login_bg_box">
	<div class="login_sm_box">
		<div class="login_box">
			<div class="user">用户登录</div>
			<span id="result"></span>
			<form id="loginForm" method="post" action="/ticket/login">
				<input name="username" id="username" placeholder="请输入用户名" required="required" type="text"> 
				<input name="password" id="password" placeholder="请输入登录密码"	required="required" type="password"> 
				<label class="error">${msg }</label>
				<input value="确认登录" type="submit">
				<div class="help_box">
					<label class="checkbox"> <input type="checkbox"
						name="rememberMe"> <span>下次自动登录</span>
					</label> 
					 <a onClick="alert('请联系管理员')" class="forget">忘记密码？</a>
					<a>帮助</a>
				</div>
				<div class="clearfix"></div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">  
    function kickout(){  
       var href=location.href;  
       if(href.indexOf("kickout")>0&&href.indexOf("JSESSIONID")>0){  
    	   $.alert({
               title: '安全提示!',
               content: "您的账号在另一台设备上登录，您被挤下线，若不是您本人操作，请立即修改密码！",
               icon: 'fa fa-rocket',
               animation: 'scale',
               closeAnimation: 'scale',
               buttons: {
                   okay: {
                       text: '确定',
                       btnClass: 'btn-blue'
                   }
               }
           });
       }   
    }  
    window.onload=kickout();   
</script> 
</body>
</html>
