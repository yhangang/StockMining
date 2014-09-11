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
	var t1 = document.getElementById('startyear').value;
	var t2 = document.getElementById('endyear').value;
	
	t1=t1.substr(0, 4) + "-01-01"; 
	t2=t2.substr(0, 4) + "-01-01"; 
	
	 if(Date.parse(t1.replace("-","/")) > Date.parse(t2.replace("-","/"))){
  	alert("开始时间大于结束时间，请检查!");
  	return false;
 }
	
	window.wholeform.submit();
	}
	

		
		

</script>
	</HEAD>
	


<body>
<div align="center" class="font1">
			  <p>时期选择</p>
				<hr/>
</div>
<div align="center">
<form name="wholeform" action="goCompanySelectAction.action" method="post">
<input type="hidden" name="expId" value="<%=request.getAttribute("expId") %>">
<table width="800" border="0" >

<tr><td class="font1">
  研究的时间跨度：&nbsp;
  <select name="startyear"  id="startyear">
  <option value="2002-01-01">2002-01-01</option>
  <option value="2003-01-01">2003-01-01</option>
  <option value="2004-01-01">2004-01-01</option>
  <option value="2005-01-01">2005-01-01</option>
  <option value="2006-01-01">2006-01-01</option>
  <option value="2007-01-01">2007-01-01</option>
  </select>
至
  <select name="endyear"  id="endyear">
  <option value="2002-01-01">2002-01-01</option>
  <option value="2003-01-01">2003-01-01</option>
  <option value="2004-01-01">2004-01-01</option>
  <option value="2005-01-01">2005-01-01</option>
  <option value="2006-01-01">2006-01-01</option>
  <option value="2007-01-01">2007-01-01</option>
  </select>
</td></tr>

</table>
</form>
</div>



<div align="center">
  <table width="800" border="0" >

    <tr>
      <td width="400">&nbsp;</td>
      <td width="400" align="center"><input type="button" name="button2" value="选择时期" onclick="goNext()"/></td>
    </tr>
  </table>

</div>
</body>
</html>