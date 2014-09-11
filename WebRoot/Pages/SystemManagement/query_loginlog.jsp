<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.a805.tools.StringHandle"%>
<%@page import="com.hibernate.entity.TLoginLog"%>
<%@page import="org.a805.tools.PageView"%>
<%@page import="org.a805.tools.DateFormatTransfer"%>
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

<body>
<div align="center" class="font1">
              <p>查看登录日志</p>
                <hr/>
</div>
         
<%TLoginLog loginlog= new TLoginLog();
	if(request.getAttribute("loginlog")!=null){
	loginlog = (TLoginLog)request.getAttribute("loginlog");
	}

 %>
<div align="center">
  <form id="form1" name="form1" method="post" action="queryLoginlog.action">
    用户名
    <label>
    <input name="loginlog.username" type="text" size="15" value="<%=StringHandle.nullToSpace(loginlog.getUsername()) %>"/>
    </label>
  &nbsp;&nbsp; 真实姓名
  <label>
  <input name="loginlog.realname" type="text" size="15" value="<%=StringHandle.nullToSpace(loginlog.getRealname()) %>"/>
  </label>
 &nbsp;<label>
 <input type="button" name="button1" value="点击查询" onclick="submitForm()"/>
  </label>
  <input type="hidden" name="currentPage" value="1"/>
  </form>
</div>
<br/>
<div align="center">
 <table width="900" cellspacing="0" class="mytable">
    <tr>
      <td width="150" class="head">用户名</td>
      <td width="150" class="head">真实姓名</td>
      <td width="300" class="head">登录时间</td>
      <td width="150" class="head">登录IP</td>
      <td width="150" class="head">登录主机</td>
    </tr>
    <%if(request.getAttribute("queryResult")!=null){
    PageView<TLoginLog> pageview = (PageView<TLoginLog>)request.getAttribute("queryResult");
    
    List<TLoginLog> listTLoginlog = pageview.getResultlist();
    Iterator<TLoginLog> it = listTLoginlog.iterator();
    int flag=0;
    while(it.hasNext()){
    TLoginLog tLoginLog = it.next();
    if(flag%2==0){
   	%>
	   	    <tr>
      <td ><%=StringHandle.nullToSpace(tLoginLog.getUsername()) %></td>
      <td ><%=StringHandle.nullToSpace(tLoginLog.getRealname()) %></td>
      <td ><%=DateFormatTransfer.dateToString(tLoginLog.getLoginTime(),"yyyy-MM-dd HH:mm:ss")%></td>
      <td  ><%=StringHandle.nullToSpace(tLoginLog.getLoginIp()) %></td>
      <td ><%=StringHandle.nullToSpace(tLoginLog.getLoginHost())%></td>
         </tr>
	<%
	}
	else{
	%>
      	    <tr>
         <td  class="alt"><%=StringHandle.nullToSpace(tLoginLog.getUsername()) %></td>
      <td  class="alt"><%=StringHandle.nullToSpace(tLoginLog.getRealname()) %></td>
      <td  class="alt"><%=DateFormatTransfer.dateToString(tLoginLog.getLoginTime(),"yyyy-MM-dd HH:mm:ss")%></td>
      <td class="alt"><%=StringHandle.nullToSpace(tLoginLog.getLoginIp()) %></td>
      <td  class="alt"><%=StringHandle.nullToSpace(tLoginLog.getLoginHost())%></td>    
      </tr>

	<%
	}
	flag++;
    }
    %>
    <tr>
    <td colspan=5>
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

