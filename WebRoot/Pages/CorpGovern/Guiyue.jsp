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
</HEAD>

<script type="text/javascript">
function goNext(){
document.form1.submit();
}
function goBack(){
window.location.href="goIndexSelectAction.action";
}

</script>
<BODY>
           <div align="center" class="font1">
              <p>规约</p>
              <hr>
            </div>
            
            <div align="right" style="font-size:14px"><a href="#">显示已选公司指标及数值</a></div>
           
           <div>
           <form action="goClusteringAction.action" name="form1" method="post">
            <input type="hidden" name="expId" value="<%=request.getAttribute("expId") %>">
           <table>
          <tr>
            <td width="148" align="right">规约方法：</td>
            <td width="148"><label>
              <select name="guiyueMethod" size="1">
                <option value="平均值规约" selected>平均值规约</option>
                <option>按增长率</option>
              </select>
            </label></td>
            <td width="149" align="right">规约深度：</td>
            <td width="172"><label>
              <select name="select2" size="1">
                <option selected>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
              </select>
            </label></td>
            <td width="126" align="right">权重深度：</td>
            <td width="141"><label>
              <select name="weight" size="1">
                <option value="1" selected>1</option>
              </select>
            </label></td>
            <td width="115">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="7" class="font1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;遗传过程              </td>
            </tr>
          <tr>
            <td colspan="2" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第一层遗传算法：</td>
            <td colspan="2" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第二层遗传算法</td>
            <td colspan="2" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第三层遗传算法</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">群体长度：</td>
            <td><label>
              <input name="textfield" type="text" size="15">
            </label></td>
            <td align="right">群体长度：</td>
            <td><label>
              <input name="textfield4" type="text" size="15">
            </label></td>
            <td align="right">群体长度：</td>
            <td><label>
              <input name="textfield7" type="text" size="15">
            </label></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">交换概率：</td>
            <td><label>
              <input name="textfield2" type="text" size="15">
            </label></td>
            <td align="right">交换概率：</td>
            <td><label>
              <input name="textfield5" type="text" size="15">
            </label></td>
            <td align="right">交换概率：</td>
            <td><label>
              <input name="textfield8" type="text" size="15">
            </label></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">变异概率：</td>
            <td><label>
              <input name="textfield3" type="text" size="15">
            </label></td>
            <td align="right">变异概率：</td>
            <td><label>
              <input name="textfield6" type="text" size="15">
            </label></td>
            <td align="right">变异概率：</td>
            <td><label>
              <input name="textfield9" type="text" size="15">
            </label></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">&nbsp;</td>
            <td>&nbsp;</td>
            <td align="right">&nbsp;</td>
            <td>&nbsp;</td>
            <td align="left">&nbsp;</td>
            <td colspan="2">&nbsp;</td>
          </tr>
	</table>
	</form>
		</div>

      
        <div align="center">
								
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="Input" type="button" value="下一步" onclick="goNext()">
		</div>
        
     

   
</BODY>
</HTML>
