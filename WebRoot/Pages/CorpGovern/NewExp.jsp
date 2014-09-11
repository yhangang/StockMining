<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>Untitled Page</TITLE>
		<link rel="stylesheet" type="text/css" href="../css/tableSetStyle.css" />
		<script language="javascript" src="../js/jquery.js"></script>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
		
<STYLE type=text/css> 
.font1{
	font-size: 16px;
	font-weight: bold;
}

</style>

<script type="text/javascript">
	
	
		function goNext(){
				if(document.getElementById('expName').value==''){
	alert("实验名称不能为空！");
	return false;
	}
		window.wholeform.submit();
	}
	
		function issuccess(){
	var flag = "<%=request.getAttribute("flag")%>";
	if(flag == "success")
	alert("新建实验成功！");
	else if(flag == "error")
	alert("新建实验失败！");
	
	}
		
		

</script>
	</HEAD>
	


<body  onload="issuccess()">
<div align="center" class="font1">
			  <p>实验基本信息</p>
				<hr/>
</div>
<div align="center">
<form name="wholeform" action="goPeriodSelectAction.action" method="post">
<table width="800" border="0" >
<tr><td class="font1">
实验名称:<input type="text" id="expName" name="expName" size="30"/>
</td></tr>



<tr><td class="font1">
查看权限:<select name="power">
		<option value="0">仅自己可见</option>
		<option value="1">公开可见</option>
	</select>
</td></tr>

</table>
</form>
</div>



<div align="center">
  <table width="800" border="0" >

    <tr>
      <td width="400">&nbsp;</td>
      <td width="400" align="center"><input type="button" name="button2" value="新建实验" onclick="goNext()"/></td>
    </tr>
  </table>

</div>
</body>
</html>