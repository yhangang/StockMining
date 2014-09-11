<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hibernate.entity.TUser"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" type="text/css" href="css/tableSetStyle.css" />
<script language="javascript" src="js/jquery.js"></script>
<title>新用户注册</title>
<script type="text/javascript">

function submitForm(){
var username = document.getElementById("username").value;
var pwd = document.getElementById("pwd").value;
var pwd2 = document.getElementById("pwd2").value;
var realname = document.getElementById("realname").value;
var college = document.getElementById("college").value;

if(window.confirm("您确定要提交吗？")){
	if(username.length<5){
	alert("用户名长度5位以上！");
	return false;
	}
		if(pwd.length<5){
	alert("密码长度5位以上！");
	return false;
	}
		if(pwd2.length<5){
	alert("密码长度5位以上！");
	return false;
	}
	if(realname.length<1){
	alert("请输入真实姓名！");
	return false;
	}

	if(college.length<1){
	alert("请输入所在学校！");
	return false;
	}
	if(pwd==pwd2){}
	else{
	alert("两次输入密码不一致！");
	return false;
	}

document.form1.submit();
}

}
<%if(request.getAttribute("msg")!=null){
%>
	alert("<%=request.getAttribute("msg") %>");
 <%}%>

	function checkUser(){
	$.ajax({
	type:"POST",
	url:"ajaxValidate.action",
	data:{"username":$("#username").val()},
	success:function(data){
	if(data=="false"){
	alert("该用户名已被注册！");
	}
	}
	});
	}

</script>
<STYLE type=text/css> 
.font1{
	font-size: 18px;
	font-weight: bold;
}
</style>
</head>

<body>
<div align="center" class="font1">
              <p>新用户注册</p>
                <hr/>
</div>


<div align="center"></div>
<div align="center">
  <form id="form1" name="form1" method="post" action="saveTUser.action">
   <div>带"*"号的为必填项</div>
    <table width="400" cellspacing="0" class="mytable">
      <tr>
        <td>用户名</td>
        <td>
          <input type="text" id="username" name="tuser.username" onblur="checkUser()"/><label style="color:#FF0000">*</label></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" id="pwd" name="tuser.pwd" size="22"/><label style="color:#FF0000">*</label></td>
      </tr>
      <tr>
        <td>确认密码</td>
        <td><input type="password" id="pwd2"name="pwd2" size="22"/><label style="color:#FF0000">*</label></td>
      </tr>
      <tr>
        <td>真实姓名</td>
        <td>
          <input type="text" id="realname"name="tuser.realname" /><label style="color:#FF0000">*</label></td>
      </tr>
      <tr>
        <td>所在学校</td>
        <td><input type="text" id="college"name="tuser.college" /><label style="color:#FF0000">*</label></td>
      </tr>
      <tr>
        <td>电话号码</td>
        <td> <input type="text" id="phoneNumber"name="tuser.phoneNumber" />&nbsp;</td>
      </tr>
      <tr>
        <td>电子邮件</td>
        <td><input type="text" id="email"name="tuser.email" />&nbsp;</td>
      </tr>
      <tr>
        <td>确认修改</td>
        <td><label>
          <a href="index.jsp" style="font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;">返回首页</a> &nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" name="Submit2" onclick="return submitForm()" value="提交" />
        </label></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>


