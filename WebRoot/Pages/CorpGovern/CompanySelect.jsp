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
	url:"queryCompany.action",
	data:$('#form1').serialize(),
	success:function(data){
	$('#leftdiv').empty().append(data);
	}
	});
	} 
	
	function submitForm2(){
	$.ajax({
	type:"POST",
	url:"selectCompany.action",
	data:$('#form2').serialize(),
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	} 
	
	function submitForm3(){
	$.ajax({
	type:"POST",
	url:"unSelectCompany.action",
	data:$('#form3').serialize(),
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	} 
	
	function clearAllCompany(){
	if(window.confirm("您确定要清空所选吗？")){
	$.ajax({
	type:"POST",
	url:"clearAllCompany.action",
	data:"xiaomeng",
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	}
	} 
	
	function refreshCompany(){
	$.ajax({
	type:"POST",
	url:"refreshCompany.action",
	data:"xiaomeng",
	success:function(data){
	$('#rightdiv').empty().append(data);
	}
	});
	} 
	function goBack(){
	window.location.href="goExpInfoAction.action";
	}
	function goNext(){
	document.form4.submit();
	}

</script>
	</HEAD>
	


<body>
<div align="center" class="font1">
			  <p>选择公司</p>
				<hr/>
</div>
 <form action="goIndexSelectAction.action" method="post" name="form4" id="form4">
     <input type="hidden" name="expId" value="<%=request.getAttribute("expId") %>">
     </form>

<br/>
<div align="center">

<form action="" method="post" name="form1" id="form1">
CSRC行业：<input name="classificationOfCsrc" type="text" />&nbsp;&nbsp;
GICS行业：<input name="classificationOfGics" type="text" />&nbsp;&nbsp;
地区：<input name="area" type="text"  />&nbsp;&nbsp;
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
        <input type="button" name="Submit" value="-->" onclick="submitForm2()"/>
		<br/><br/>
		取消<br/>
        <input type="button" name="Submit2" value="<--" onclick="submitForm3()"/>
        <br/><br/><br/><br/>
        	<input type="button" name="button2" value="全清" onclick="clearAllCompany()"/>
        	<br/>
	<input type="button" name="button2" value="刷新" onclick="refreshCompany()" />
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
      <td width="400" align="center"><input type="button" name="button2" value="下一步" onclick="goNext()"/></td>
    </tr>
  </table>

</div>
</body>
</html>