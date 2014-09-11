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
	font-size: 18px;
	font-weight: bold;
}
.selectStyle {
	width: 350px;
}
</style>

<script type="text/javascript">
	function submitForm1(){
	$.ajax({
	type:"POST",
	url:"queryIndex.action",
	data:$('#form1').serialize(),
	success:function(data){
	$('#leftdiv').empty().append(data);
	}
	});
	} 
	
	function submitForm2(){
	$.ajax({
	type:"POST",
	url:"selectIndex.action",
	data:$('#form2').serialize(),
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	} 
	
	function submitForm3(){
	$.ajax({
	type:"POST",
	url:"unSelectIndex.action",
	data:$('#form3').serialize(),
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	} 
	
	function clearAll(){
	if(window.confirm("您确定要清空所选吗？")){
	$.ajax({
	type:"POST",
	url:"clearAllIndex.action",
	data:"xiaomeng",
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	}
	} 
	
	function refresh(){
	$.ajax({
	type:"POST",
	url:"refreshIndex.action",
	data:"xiaomeng",
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	} 
	
	function goNext(){
	document.form4.submit();
	}
	
	function goBack(){
	window.location.href="goCompanySelectAction.action";
	}

</script>
	</HEAD>
	


<body>
<div align="center" class="font1">
			  <p>选择指标</p>
				<hr/>
</div>
 <form action="goGuiyueAction.action" method="post" name="form4" id="form4">
     <input type="hidden" name="expId" value="<%=request.getAttribute("expId") %>">
     </form>

<div align="center">

<form action="" method="post" name="form1" id="form1">
指标类型：<input name="indexType" type="text" />&nbsp;&nbsp;
 <input type="button" value="点击查询" onclick="submitForm1()"/>
 </form>
</div>

<div align="center">
  <table width="800" border="0">
  	<tr>
	<td>待选公司</td>
	<td></td>
	<td align="center">已选公司</td>
	</tr>
    <tr>
      <td width="350" height="300"> 
      <form action="" method="post" name="form2" id="form2">
      <div id="leftdiv">
      <SELECT name="left" id="left" size="20" multiple class="selectStyle">
 
  </SELECT></div></form>
  </td>
      <td width="100" align="center"><label>
	  选中<br/>
        <input type="button" value="-->" onclick="submitForm2()"/>
		<br/><br/>
		取消<br/>
        <input type="button" value="<--" onclick="submitForm3()"/>
        <br/><br/><br/><br/>
        	<input type="button" value="全清" onclick="clearAll()"/>
        	<br/>
	<input type="button" value="刷新" onclick="refresh()" />
      </label></td>
      <td width="350">
            <form action="" method="post" name="form3" id="form3">
      <div id="rightdiv">
      <select name="right" id="right" size="20" multiple class="selectStyle">
      </select></div></form></td>
    </tr>
  </table>
</div>
<div align="center">
  <table width="800" border="0" >
    <tr>
      <td width="400">&nbsp;</td>
      <td width="400" align="center"><input type="button" value="下一步" onclick="goNext()"/></td>
    </tr>
  </table>

</div>
</body>
</html>