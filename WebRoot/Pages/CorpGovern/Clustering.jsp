<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="../css/tableSetStyle.css" />
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
.font1{
	font-size: 18px;
	font-weight: bold;
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>

<script type="text/javascript">
function goNext(){
document.form1.submit();
}
function goBack(){
window.location.href="goGuiyueAction.action";
}


</script>
<BODY>
           <div align="center" class="font1">
              <p>聚类</p>
              <hr>
            </div>
            
            <div align="right" style="font-size:14px"><a href="#">显示已选公司指标及数值</a></div>
            <div align="right" style="font-size:14px"><a href="#">显示规约后时段基因</a></div>
            <div align="right" style="font-size:14px"><a href="#">显示数值及时段基因</a></div>
           
           <div>
           <form method="post" name="form1" action="clusteringOfAgglomerate.action">
            <input type="hidden" name="expId" value="<%=request.getAttribute("expId") %>">
           <table>
          <tr>
            <td width="148" align="right">聚类方法：</td>
            <td width="148"><label>
              <select name="clusteringMethod" size="1">
                <option value="系统聚类法" selected>系统聚类法</option>
                <option value="K-means聚类">K-means聚类</option>
                <option value="中心点法">中心点法</option>
              </select>
            </label></td>
            <td width="149" align="right">结果表示：</td>
            <td width="172"><label>
              <select name="select2" size="1">
                <option selected>文字表达</option>
                <option>图形表示</option>
              </select>
            </label></td>
            <td width="126" align="right">聚为几类：</td>
            <td width="141"><label>
              <select name="classes" size="1">
                <option value="2" >2</option>
                <option value="3" >3</option>
                <option value="4" >4</option>
                <option value="5" >5</option>
                <option value="6" >6</option>
                <option value="7" >7</option>
                <option value="8" >8</option>
                <option value="9" >9</option>
                <option value="10" >10</option>
              </select>
            </label></td>
            <td width="115">&nbsp;</td>
          </tr>
        
	</table>
	</form>

         <br/><br/><br/> <br/><br/><br/> <br/><br/><br/> <br/>
		</div>

      
        <div align="center">
								
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="Input" type="button" value="下一步" onclick="goNext()">
		</div>
        
     

   
</BODY>
</HTML>
