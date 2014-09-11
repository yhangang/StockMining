<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" type="text/css" href="../css/tableSetStyle.css" />
<title>无标题文档</title>
<STYLE type=text/css> 
.font1{
	font-size: 18px;
	font-weight: bold;
}
</style>

<script type="text/javascript">

	
	function validate(){
	var oldPwd = document.forms[0].oldPwd.value;
	var newPwd = document.forms[0].newPwd.value;
	var newPwd2 = document.forms[0].newPwd2.value;
	if(oldPwd.length<1){
	alert("原密码不能为空！");
	return false;
	}
	if(newPwd.length<3||newPwd2.length<3){
	alert("新密码长度3位以上！");
	return false;
	}
	if(newPwd == newPwd2){
	}
	else{
		alert("两次输入密码不一致！");
	return false;
	}
	document.forms[0].submit();
	
	} 



</script>
</head>
<body>
 <div align="center" class="font1">
              <p>修改密码</p>
                <hr/>
              </div>
<div align="center">
  <form id="form1" name="form1" method="post" action="resetPwd.action">
    <table width="300" cellspacing="0" class="mytable">
      <tr>
        <td>原密码</td>
        <td><label>
          <input type="password" name="oldPwd" />
        </label></td>
      </tr>
      <tr>
        <td>新密码</td>
        <td><label>
        <input type="password" name="newPwd" />
        </label></td>
      </tr>
      <tr>
        <td>重复新密码</td>
        <td><label>
        <input type="password" name="newPwd2" />
        </label></td>
      </tr>
      <tr>
        <td>确认修改</td>
        <td><label>
          <input type="button" value="修改密码" onclick="validate()"/>
        </label></td>
      </tr>
    </table>
    <div style="font-size:14px;color:#FF0000;">
    <%if(request.getAttribute("msg")!=null){
    out.print((String)request.getAttribute("msg"));
    }
    
     %>
    
    </div>
  </form>
</div>
</body>
</html>

