<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>数据查看</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
<script type="text/javascript" src="../js/jquery.js"></script>
<link rel="stylesheet" href="../css/tabStyle.css" />
</HEAD>

  <SCRIPT type=text/javascript>
function selectTag(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("tags").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag";
	// 操作内容
	for(i=0; j=document.getElementById("tagContent"+i); i++){
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";
	
	
}
</SCRIPT>


<body onload="">
<center>
<DIV id=con>
  <UL id=tags>
    <LI class="selectTag"><A onClick="selectTag('tagContent0',this)"
  href='javascript:void(0)'>标签一</A> </LI>
    <LI><A onClick="selectTag('tagContent1',this)" 
  href='javascript:void(0)'>标签二二二二</A> </LI>
    <LI><A onClick="selectTag('tagContent2',this)" 
  href='javascript:void(0)'>自适应宽度的标签</A> </LI>
  </UL>
  <DIV id=tagContent>
    <DIV class='tagContent selectTag' id='tagContent0'>第一个标签的内容</DIV>
    <DIV class='tagContent' id='tagContent1'>第二个标签的内容</DIV>
    <DIV class='tagContent' id='tagContent2'>第三个标签的内容</DIV>
  </DIV>
</DIV>

</center>
</body>
</HTML>
