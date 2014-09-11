<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hibernate.entity.TUser"%>
<%@page import="org.a805.tools.StringHandle"%>
<%@page import="org.a805.service.impl.UserServiceImpl"%>
<%@page import="org.a805.tools.PageView"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<STYLE type=text/css> 
.font1{
	font-size: 18px;
	font-weight: bold;
}
</style>
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="../css/tableStyle.css" />
<script type="text/javascript">
	function submitForm(){
	document.form1.submit();
	} 
	
	function submitByPage(currentPage){
	document.form1.currentPage.value=currentPage;
	document.form1.submit();
	} 
	
	function submitByJump(totalPage){
	var currentPage = document.getElementById("current").value;
	if(currentPage<1||currentPage>totalPage){
	alert("请输入有效的页码！");
	document.getElementById("current").value="";
	return false;
	}
	submitByPage(currentPage);
	}

</script>
</head>


<script type="text/javascript">
function deleteUser(){
if(window.confirm("您确定要删除该用户吗？")){
return true;
}
return false;
}


</script>
<body>
<div align="center" class="font1">
              <p>查看用户信息</p>
                <hr/>
</div>
         
<%TUser user= new TUser();
	if(request.getAttribute("tuser")!=null){
	user = (TUser)request.getAttribute("tuser");
	}

 %>
<div align="center">
  <form id="form1" name="form1" method="post" action="queryTUser.action">
    用户名
    <label>
    <input name="tuser.username" type="text" size="15" value="<%=StringHandle.nullToSpace(user.getUsername()) %>"/>
    </label>
  &nbsp;&nbsp; 真实姓名
  <label>
  <input name="tuser.realname" type="text" size="15" value="<%=StringHandle.nullToSpace(user.getRealname()) %>"/>
  </label>
 &nbsp; 所在学校
 <label>
 <input name="tuser.college" type="text" size="15" value="<%=StringHandle.nullToSpace(user.getCollege()) %>"/>
 </label>
&nbsp; 角色
  <label><select name="tuser.roleId">
   <option value="">---请选择---</option>
  <option value="000001" <%if("000001".equals(user.getRoleId())){out.print("selected");} %>>超级管理员</option>
  <option value="000002" <%if("000002".equals(user.getRoleId())){out.print("selected");} %>>管理员</option>
  <option value="000003" <%if("000003".equals(user.getRoleId())){out.print("selected");} %>>用户</option>
  </select> 
 &nbsp;  </label>
  <label>
  <input type="submit" name="Submit" value="点击查询" />
  </label>
   <input type="hidden" name="currentPage" value="1"/>
  </form>
</div>
<br/>
<div align="center">
 <table width="800" cellspacing="0" class="mytable">
    <tr>
      <td width="101" class="head">用户名</td>
      <td width="95" class="head">真实姓名</td>
      <td width="101" class="head">所在学校</td>
      <td width="100" class="head">角色</td>
      <td width="106" class="head">电话</td>
      <td width="136" class="head">电子邮件</td>
      <td width="145" class="head">操作</td>
    </tr>
    <%if(request.getAttribute("queryResult")!=null){
    PageView<TUser> pageview = (PageView<TUser>)request.getAttribute("queryResult");
    
    List<TUser> listTUser = pageview.getResultlist();
    Iterator<TUser> it = listTUser.iterator();
    int flag=0;
    while(it.hasNext()){
    TUser tuser = it.next();
    if(flag%2==0){
   	%>
	   	    <tr>
      <td width="101" ><%=StringHandle.nullToSpace(tuser.getUsername()) %></td>
      <td width="95" ><%=StringHandle.nullToSpace(tuser.getRealname()) %></td>
      <td width="101" ><%=StringHandle.nullToSpace(tuser.getCollege())%></td>
      <td width="100" ><%=UserServiceImpl.getNameById(tuser.getRoleId()) %></td>
      <td width="106" ><%=StringHandle.nullToSpace(tuser.getPhoneNumber())%></td>
      <td width="136" ><%=StringHandle.nullToSpace(tuser.getEmail()) %></td>
      <td width="145" ><a href="goEditTUser.action?id=<%=tuser.getId() %>">修改</a>|<a href="deleteTUser.action?id=<%=tuser.getId() %>" onclick="return deleteUser()">删除</a></td>
    </tr>
	<%
	}
	else{
	%>
      	    <tr>
      <td width="101" class="alt"><%=StringHandle.nullToSpace(tuser.getUsername()) %></td>
      <td width="95" class="alt"><%=StringHandle.nullToSpace(tuser.getRealname()) %></td>
      <td width="101" class="alt"><%=StringHandle.nullToSpace(tuser.getCollege())%></td>
      <td width="100" class="alt"><%=UserServiceImpl.getNameById(tuser.getRoleId())  %></td>
      <td width="106" class="alt"><%=StringHandle.nullToSpace(tuser.getPhoneNumber())%></td>
      <td width="136" class="alt"><%=StringHandle.nullToSpace(tuser.getEmail()) %></td>
      <td width="145" class="alt"><a href="goEditTUser.action?id=<%=tuser.getId() %>">修改</a>|<a href="deleteTUser.action?id=<%=tuser.getId() %>" onclick="return deleteUser()">删除</a></td>
    </tr>

	<%
	}
	flag++;
    }
     %>
    <tr>
    <td colspan=7>
    当前页：第<%=pageview.getCurrentpage() %>页 &nbsp;&nbsp;
    总页数：<%=pageview.getTotalpage() %>&nbsp;&nbsp;
    每页显示：<%=pageview.getPagesize() %>&nbsp;&nbsp;
    总记录数：<%=pageview.getTotalrecord() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:submitByPage('1')" >首页</a>&nbsp;&nbsp;
    <%if(pageview.getCurrentpage()!=1&&pageview.getCurrentpage()!=0){ %>
    <a href="javascript:submitByPage('<%=pageview.getCurrentpage()-1 %>')" >上一页</a>&nbsp;&nbsp;
    <%} else{%>
    上一页&nbsp;&nbsp;
    <%} %>
    <%if(pageview.getCurrentpage()<pageview.getTotalpage()){ %>
    <a href="javascript:submitByPage('<%=pageview.getCurrentpage()+1 %>')" >下一页</a>&nbsp;&nbsp;
     <%} else{%>
    下一页&nbsp;&nbsp;
    <%} %>
    
    <a href="javascript:submitByPage('<%=pageview.getTotalpage() %>')" >尾页</a>&nbsp;&nbsp;
    跳至<input type="text" id="current" size="2" maxLength="4"  onkeyup="value=value.replace(/[^\d]/g,'')" />页 
    <input type="button" value="确定" onclick="return submitByJump(<%=pageview.getTotalpage() %>)"/>
    
    
    
    </td>
    </tr>
    <%
    }
     %>
    


  </table>
</div>
</body>
</html>

