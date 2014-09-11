<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hibernate.entity.TUser"%>
<%@page import="org.a805.tools.StringHandle"%>
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
<script type="text/javascript">
function goBack(){
window.history.back();
}

function submitForm(){
var realname = document.getElementById("realname").value;
var college = document.getElementById("college").value;
if(window.confirm("您确定要修改吗？")){
	if(realname.length<1){
	alert("真实姓名不能为空！");
	return false;
	}
	if(college.length<1){
	alert("所在学校不能为空！");
	return false;
	}



document.form1.submit();
}

}


</script>
</head>

<body>
<div align="center" class="STYLE1">
              <p>修改用户信息</p>
                <hr/>
</div>
         <%
         TUser tuser = new TUser();
         if(request.getAttribute("tuser")!=null){
    	 tuser = (TUser)request.getAttribute("tuser");
    }
         
          %>

<div align="center"></div>
<div align="center">
  <form id="form1" name="form1" method="post" action="editTUser.action">
    <table width="400" cellspacing="0" class="mytable">
      <tr>
        <td>用户名</td>
        <td><label>
          <input type="text" name="tuser.username" value="<%=StringHandle.nullToSpace(tuser.getUsername()) %>"/>
          <input type="hidden" name="tuser.id" value="<%=StringHandle.nullToSpace(tuser.getId()) %>"/>
          <input type="hidden" name="tuser.pwd" value="<%=StringHandle.nullToSpace(tuser.getPwd()) %>"/>
        </label></td>
      </tr>
      <tr>
        <td>真实姓名</td>
        <td><label>
          <input type="text" id="realname" name="tuser.realname" value="<%=StringHandle.nullToSpace(tuser.getRealname()) %>"/>
        </label></td>
      </tr>
      <tr>
        <td>所在学校</td>
        <td><input type="text" id="college" name="tuser.college" value="<%=StringHandle.nullToSpace(tuser.getCollege()) %>"/></td>
      </tr>
      <tr>
        <td>电话号码</td>
        <td><input type="text" name="tuser.phoneNumber" value="<%=StringHandle.nullToSpace(tuser.getPhoneNumber()) %>"/></td>
      </tr>
      <tr>
        <td>电子邮件</td>
        <td><input type="text" name="tuser.email" value="<%=StringHandle.nullToSpace(tuser.getEmail()) %>"/></td>
      </tr>
      <tr>
        <td>角色</td>
        <td><select name="tuser.roleId">
  <option value="000001" <%if("000001".equals(tuser.getRoleId())){out.print("selected");} %>>超级管理员</option>
  <option value="000002" <%if("000002".equals(tuser.getRoleId())){out.print("selected");} %>>管理员</option>
  <option value="000003" <%if("000003".equals(tuser.getRoleId())){out.print("selected");} %>>用户</option>
  </select> </td>
      </tr>
      <tr>
        <td>确认修改</td>
        <td><label>
          <input type="button" onclick="goBack()" value="返回" />
          <input type="button" name="Submit2" onclick="return submitForm()" value="提交" />
        </label></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>


