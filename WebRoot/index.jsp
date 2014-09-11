<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<%
	if (session.getAttribute("loginName") != null) {
	response.sendRedirect("loginAction.action");
	}%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>01Lab算法平台 用户登录</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<LINK href="images/public.css" type=text/css rel=stylesheet>
		<LINK href="images/login.css" type=text/css rel=stylesheet>
		<STYLE type=text/css>
</STYLE>
		<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
	</HEAD>
	<script type="text/javascript">

	function submit(){
		document.forms[0].submit();
	} 
	function keyPress(e){
	var ev= window.event||e;
	 if (ev.keyCode == 13) {
  	 document.forms[0].submit();
  	}
	} 
		
	function refresh(){
		var img = document.getElementById("img_validation");
		img.src="regexAction.action?bbb=" + Math.floor(Math.random()*100000);
	}
	
	<%if(request.getAttribute("msg")!=null){
%>
	alert("<%=request.getAttribute("msg") %>");
 <%}%>
</script>


	<BODY>
		<form name="form1" action="loginAction.action" method="post">
			<DIV id=div1>
				<TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800
					align=center>
					<TBODY>
						<TR id=main>
							<TD>
								<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
									<TBODY>
										<TR>
											<TD colSpan=4>
												&nbsp;
											</TD>
										</TR>
										<TR height=30>
											<TD width=380>
												&nbsp;
											</TD>
											<TD>
												&nbsp;
											</TD>
											<TD>
												&nbsp;
											</TD>
											<TD>
												&nbsp;
											</TD>
										</TR>
										<TR height=40>
											<TD rowSpan=4>
												&nbsp;
											</TD>
											<TD>
												用户名：
											</TD>
											<TD>
												<INPUT class=textbox id=txtUserName name="username">
											</TD>
											<TD width=120>
												&nbsp;
											</TD>
										</TR>
										<TR height=40>
											<TD>
												密 码：
											</TD>
											<TD>
												<INPUT class=textbox id=txtUserPassword type=password
													name="pwd">
											</TD>
											<TD width=120>
												&nbsp;
											</TD>
										</TR>
										<TR height=40>
											<TD>
												验证码：
											</TD>
											<TD vAlign=center colSpan=2>
												<INPUT id=txtSN size=8 name="recertCode" onKeyPress="keyPress(event)">
												&nbsp;
												<img id="img_validation"
													style="width: 25%; height: 24px; float: none; margin-top: 7px;"
													src="regexAction.action" onclick="refresh()" />
											</TD>
										</TR>
										<TR height=40>
											<TD style="font-size:12px;font-weight: bold;"><a href="registerUser.action">没有账号？点击注册</a></TD>
											<TD align=right>
												<INPUT id=btnLogin type=button value=" 登 录 " name=btnLogin onclick="submit()">
											</TD>
											<TD width=120>
												&nbsp;
											</TD>
										</TR>
										<TR height=110>
											<TD colSpan=4>
												&nbsp;
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR id=root height=104>
							<TD>
								&nbsp;
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
			<DIV id=div2 style="DISPLAY: none"></DIV>
			</CONTENTTEMPLATE>
		</form>
	</BODY>
</HTML>
