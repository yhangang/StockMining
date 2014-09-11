<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.a805.tools.StringHandle"%>
<%@page import="com.hibernate.entity.TExperimentInformation"%>
<%@page import="org.a805.tools.PageView"%>
<%@page import="org.a805.tools.DateFormatTransfer"%>
<%@page import="org.a805.tools.SysglobalQuery"%>
<%@page import="org.a805.service.impl.UserServiceImpl"%>
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
              <p>我的实验</p>
                <hr/>
</div>
         


<br/>
<%TExperimentInformation experimentInformation= new TExperimentInformation();
	if(request.getAttribute("experimentInformation")!=null){
	experimentInformation = (TExperimentInformation)request.getAttribute("experimentInformation");
	}

 %>
<div align="center">
  <form id="form1" name="form1" method="post" action="queryMyExp.action">
    
 实验名称
    <label>
    <input name="experimentInformation.expName" type="text" size="15" 
    value="<%=StringHandle.nullToSpace(experimentInformation.getExpName()) %>"/>
    </label>
  
 <input type="button" name="button1" value="点击查询" onclick="submitForm()"/>
  <input type="hidden" name="currentPage" value="1"/>
  </form>
</div>
<br/>
<div align="center">
 <table width="900" cellspacing="0" class="mytable">
    <tr>
      <td width="70" class="head">实验ID</td>
      <td width="200" class="head">实验名称</td>
      <td width="100" class="head">试验人</td>
      <td width="200" class="head">创建时间</td>
      <td width="200" class="head">修改时间</td>
      <td width="100" class="head">权限</td>
    </tr>
    <%if(request.getAttribute("queryResult")!=null){
    PageView<TExperimentInformation> pageview = (PageView<TExperimentInformation>)request.getAttribute("queryResult");
    
    List<TExperimentInformation> listTExperimentInformation = pageview.getResultlist();
    Iterator<TExperimentInformation> it = listTExperimentInformation.iterator();
    int flag=0;
    while(it.hasNext()){
    TExperimentInformation tExperimentInformation = it.next();
    if(flag%2==0){
   	%>
	   	    <tr>
      <td ><%=StringHandle.nullToSpace(tExperimentInformation.getExpId()) %></td>
      <td ><a href="toPeriodSelect.action?expId=<%=tExperimentInformation.getExpId() %>"><%=StringHandle.nullToSpace(tExperimentInformation.getExpName()) %></a></td>
      <td ><%=StringHandle.nullToSpace(UserServiceImpl.getRealnameById(tExperimentInformation.getUserId()))%></td>
      <td  ><%=DateFormatTransfer.dateToString(tExperimentInformation.getCreateTime(),"yyyy-MM-dd HH:mm:ss") %></td>
      <td ><%=DateFormatTransfer.dateToString(tExperimentInformation.getUpdateTime(),"yyyy-MM-dd HH:mm:ss")%></td>
      <td ><%=StringHandle.nullToSpace(SysglobalQuery.queryValue("ExpPower",tExperimentInformation.getPower()))%></td>
         </tr>
	<%
	}
	else{
	%>
      	    <tr>
            <td class="alt"><%=StringHandle.nullToSpace(tExperimentInformation.getExpId()) %></td>
      <td class="alt"><a href="toPeriodSelect.action?expId=<%=tExperimentInformation.getExpId() %>"><%=StringHandle.nullToSpace(tExperimentInformation.getExpName()) %></a></td>
      <td class="alt"><%=StringHandle.nullToSpace(UserServiceImpl.getRealnameById(tExperimentInformation.getUserId()))%></td>
      <td  class="alt"><%=DateFormatTransfer.dateToString(tExperimentInformation.getCreateTime(),"yyyy-MM-dd HH:mm:ss") %></td>
      <td class="alt"><%=DateFormatTransfer.dateToString(tExperimentInformation.getUpdateTime(),"yyyy-MM-dd HH:mm:ss")%></td>
      <td class="alt"><%=StringHandle.nullToSpace(SysglobalQuery.queryValue("ExpPower",tExperimentInformation.getPower()))%></td>
      </tr>

	<%
	}
	flag++;
    }
    %>
    <tr>
    <td colspan=6>
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

