<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hibernate.dao.TCompanyDAO"%>
<%@page import="org.a805.service.impl.corpgovern.CountST"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory
,org.jfree.chart.JFreeChart,org.jfree.chart.servlet.*" %>
<%@page import="java.awt.Font"%>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.category.*"%>
<%@page import="org.jfree.chart.axis.*"%>
<%@page import="org.jfree.chart.title.*"%>
<%@page import="com.hibernate.dao.TIndexDAO"%>
<%@page import="com.hibernate.dao.TCompanyIndexDAO"%>
<%@page import="com.hibernate.entity.TCompanyIndexId"%>
<%@page import="com.hibernate.entity.TCompanyIndex"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.a805.service.impl.corpgovern.StService;"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>

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
<link rel="stylesheet" type="text/css" href="../css/resultPageStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/cssTopLeftHeadStatic.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<link rel="stylesheet" href="../css/tabStyle.css" />
<script type="text/javascript">
function goNext(){
window.location.href="clusteringOfAgglomerate.action";
}
function goBack(){
window.location.href="goClusteringAction.action";
}

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


</script>
<BODY>   

           <div style="font-size:14px" id="con">
         
           
        <%Map<String, Map<String, String>> finalResult = (Map<String, Map<String, String>>)request.getAttribute("finalResult");
        TCompanyDAO tCompanyDAO = new TCompanyDAO();
         TIndexDAO tIndexDAO = new TIndexDAO();
          TCompanyIndexDAO tCompanyIndexDAO = new TCompanyIndexDAO();
        
        		TreeSet<String> selectedStockId = new TreeSet<String>();
		TreeSet<String> selectedIndexId = new TreeSet<String>();
		ArrayList<String> selectedYears = new ArrayList<String>();
		if (session.getAttribute("selectedStockId") != null)
			selectedStockId = (TreeSet<String>) session
					.getAttribute("selectedStockId");
		if (session.getAttribute("selectedIndexId") != null)
			selectedIndexId = (TreeSet<String>) session
					.getAttribute("selectedIndexId");
		if (session.getAttribute("selectedYears") != null)
			selectedYears = (ArrayList<String>) session.getAttribute("selectedYears");
        
        int geneLenth = 1;
        
        //用于统计公司总数
        int companyCount = 0;
        //用于统计聚类的总类数
        int classCount = 0;
        //ST总个数
        int STcount = 0;
        //用于统计ST公司个数
        CountST countST = new CountST();
        //初始化jfreechart图表
        
        JFreeChart chart = null;
        
        
        
        
        
        
        
        
        
        
        int tabCount = 0;
           //生成tab选项卡
            out.println("<UL id='tags'>");
            
            Iterator<Map.Entry<String, Map<String, String>>> it = finalResult.entrySet().iterator();
            while(it.hasNext()){
            Map.Entry<String, Map<String, String>> entry = (Map.Entry<String, Map<String, String>>)it.next();
                  Map<String, String> map = entry.getValue();
           
           out.println("<LI class='selectTag'><A onClick=\"selectTag('tagContent"+tabCount++
            +"',this)\"href='javascript:void(0)'>第"+ tabCount +"类</A> </LI>");
            }
             out.println("<LI class='selectTag'><A onClick=\"selectTag('tagContent"+tabCount++
            +"',this)\"href='javascript:void(0)'>汇总</A> </LI>");
             out.println("</UL>");
           //下面是选项卡中的内容
           

           out.println("<DIV id=tagContent>");
           it = finalResult.entrySet().iterator();
           tabCount = 0;
           while(it.hasNext()){
           Map.Entry<String, Map<String, String>> entry = (Map.Entry<String, Map<String, String>>)it.next();

           Map<String, String> map = entry.getValue();
           Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
           
           classCount++;
           
             //用于隔行换色
         	int flag=0;
           //首行默认被选中
           if(tabCount == 0){
            out.println("<div class='tagContent selectTag' id='tagContent"+ tabCount++ +"'>");
           }
           else{
           out.println("<div class='tagContent' id='tagContent"+ tabCount++ +"'>");
           }
           //输出每类的汇总信息
           out.println("第"+ entry.getKey() +"类，" + "共" + map.size() + "个公司，其中ST公司"+
            StService.countST(map,selectedYears) + "个，ST比率："+((double)StService.countST(map,selectedYears))/map.size()+"<br/><br/>");
           companyCount += map.size();
           STcount+=StService.countST(map,selectedYears);
           //初始化DIV，输出表头
            out.println("<div align='left' style='width: 1000px; height: 350px;overflow: auto; cursor: default; display: inline; position: absolute;'>");
           out.println("<table  class='mytable' cellspacing='0'>");
           
           out.println("<tr class='FixedTitleRow'>");
           out.println("<td class='head FixedTitleColumn'  colspan='2'>&nbsp;</td>");
            for (String indexId : selectedIndexId) {
           out.println("<td style='text-align:center;' class='head' colspan='"+selectedYears.size()+"'>"+tIndexDAO.findById(indexId).getIndexName()+"</td>");
           }
           out.println("</tr>");
           
           
           out.println("<tr class='FixedTitleRow'>");
           out.println("<td class='head FixedTitleColumn'><div style='width:80px;'>股票代码</div></td>");
           out.println("<td class='head FixedTitleColumn'><div style='width:80px;'>公司简称</div></td>");
           for (String indexId : selectedIndexId) {
           			for(String year : selectedYears){
           out.println("<td class='head' style='text-align:center;'>" + year.substring(0,4) +"</td>");
           }
           }
           out.println("</tr>");
           
           
           
           //循环输出每个公司的值，隔行换色
           while(it2.hasNext()){
           Map.Entry<String, String> entry2 = it2.next();
           if(flag%2==0){
           //输出公司指标规约前的值
           out.println("<tr>");
           out.println("<td class='FixedDataColumn'>" + entry2.getKey() +"</td>");
           out.println("<td class='FixedDataColumn'>" + tCompanyDAO.findById(entry2.getKey()).getStockShortName() +"</td>");
           
           
           
           		for (String indexId : selectedIndexId) {
           			for(String year : selectedYears){
           			TCompanyIndex tCompanyIndex = tCompanyIndexDAO.findById(new TCompanyIndexId(entry2.getKey(),indexId,year));
           			Double d = 0.0;        		
           			if(tCompanyIndex!=null){
           			d = tCompanyIndex.getIndexValue();
           			}
           			DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###.00");	
           			if(d<1.0&&d>-1.0){
           			df = new DecimalFormat("0.0000");				
           			}
           			
					String dStr = df.format(d);
					//将当年的ST公司标红
					if(StService.isST(year.substring(0,4),entry2.getKey()))
					out.println("<td style='text-align:center;color:red;'>" + dStr +"</td>");
					else					
        		   out.println("<td style='text-align:center;'>" + dStr +"</td>");
           }
           }
           out.println("</tr>");
           //输出公司指标规约后的值
                      out.println("<tr>");
           out.println("<td class='FixedDataColumn'>" + entry2.getKey() +"</td>");
           out.println("<td class='FixedDataColumn'>" + tCompanyDAO.findById(entry2.getKey()).getStockShortName() +"</td>");
           
           String value = entry2.getValue();
           		for (String indexId : selectedIndexId) {
           			for(String year : selectedYears){
           //将当年的ST公司标红
					if(StService.isST(year.substring(0,4),entry2.getKey()))
					out.println("<td style='text-align:center;color:red;'>" + value.substring(0,geneLenth) +"</td>");
					else					
        		   out.println("<td style='text-align:center;'>" + value.substring(0,geneLenth) +"</td>");
           
           value = value.substring(1);
           }
           }
           out.println("</tr>");
           }
           else{
            //输出公司指标规约前的值
           out.println("<tr>");
           out.println("<td class='alt FixedDataColumn'>" + entry2.getKey() +"</td>");
           out.println("<td class='alt FixedDataColumn'>" + tCompanyDAO.findById(entry2.getKey()).getStockShortName() +"</td>");
           
           
           
           		for (String indexId : selectedIndexId) {
           			for(String year : selectedYears){
           			TCompanyIndex tCompanyIndex = tCompanyIndexDAO.findById(new TCompanyIndexId(entry2.getKey(),indexId,year));
           			Double d = 0.0;
           			if(tCompanyIndex!=null){
           			d = tCompanyIndex.getIndexValue();
           			}
           			DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###.00");	
           			if(d<1.0&&d>-1.0){
           			df = new DecimalFormat("0.0000");				
           			}
           			
					String dStr = df.format(d);
           //将当年的ST公司标红
					if(StService.isST(year.substring(0,4),entry2.getKey()))
					out.println("<td class='alt' style='text-align:center;color:red;'>" + dStr +"</td>");
					else					
        		   out.println("<td class='alt' style='text-align:center;'>" + dStr +"</td>");
           }
           }
           out.println("</tr>");
           //输出公司指标规约后的值
           out.println("<tr>");
           out.println("<td class='alt FixedDataColumn'>" + entry2.getKey() +"");
           out.println("<td class='alt FixedDataColumn'>" + tCompanyDAO.findById(entry2.getKey()).getStockShortName() +"");
           String value = entry2.getValue();
           
           		for (String indexId : selectedIndexId) {
           			for(String year : selectedYears){
                      //将当年的ST公司标红
					if(StService.isST(year.substring(0,4),entry2.getKey()))
					out.println("<td class='alt' style='text-align:center;color:red;'>" + value.substring(0,geneLenth) +"</td>");
					else					
        		   out.println("<td class='alt'style='text-align:center;'>" + value.substring(0,geneLenth) +"</td>");
           value = value.substring(1);
           }
           }
           out.println("</tr>");
           }
            flag++;
           }
           out.println("</table>");
           
           out.println("</div>");
           //开始输出图表
            DefaultPieDataset dpd = new DefaultPieDataset();
            dpd.setValue("非ST公司总数", (map.size() - StService.countST(map,selectedYears)));
    		dpd.setValue("ST公司总数", StService.countST(map,selectedYears));
          
          chart = ChartFactory.createPieChart("样本中ST比例",dpd, true, false, false);
          
          chart.getTitle().setFont(new Font("黑体",Font.BOLD,20));//设置标题字体
		 PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
		    piePlot.setLabelFont(new Font("黑体",Font.BOLD,15));
		    chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,15));
		    
		    String fileName = ServletUtilities.saveChartAsPNG(chart,400,300,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String urlPie = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
    
           DefaultCategoryDataset dataset=new DefaultCategoryDataset();
           dataset.setValue(map.size() ,"公司总数","公司总数");
    	dataset.setValue((map.size() - StService.countST(map,selectedYears)),"非ST总数","非ST总数");
	        dataset.setValue(StService.countST(map,selectedYears),"ST公司总数","ST公司总数");
	        
	        
	        chart=ChartFactory.createBarChart("", "", 
	                "公司数量", dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
	                chart.setTitle(new TextTitle("样本中各类公司数量",new Font("黑体",Font.BOLD,20)));//可以重新设置标题，替换“hi”标题
	        CategoryPlot plot=(CategoryPlot)chart.getPlot();//获得图标中间部分，即plot
	        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
	        
	        categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,15));//设置横坐标字体
	        CategoryAxis domainAxis=plot.getDomainAxis();
	         //水平底部列表
	         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
	         //水平底部标题
	         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,15));
	         //垂直标题
	         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
	         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
	          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
	          
	          fileName = ServletUtilities.saveChartAsPNG(chart,400,300,session); 
	          String urlBar = request.getContextPath() + "/DisplayChart?filename=" + fileName;
           
           out.println("<div align='left' style='width: 900px; height: 400px;overflow: auto; cursor: default; display: inline; position: absolute;top:500px'><img src="+ urlBar +" width='450' height='300'>");
           out.println("<img src="+ urlPie +" width='400' height='300'></div>");
           







 			out.println("</div>");
           }
           //输出汇总表
            out.println("<div class='tagContent' id='tagContent"+ tabCount++ +"'>");
            out.println("<table width='800' class='mytable' cellspacing='0'>");
           out.println("<tr>");
           out.println("<td class='head' width='80'>公司总数</td>");
           out.println("<td class='head' width='80'>非ST公司总数</td>");
           out.println("<td class='head' width='80'>ST公司总数</td>");
           out.println("<td style='text-align:left;' class='head'>ST比率</td>");
           out.println("</tr>");
           
           out.println("<tr>");
           out.println("<td  width='80'>"+ companyCount+"</td>");
           out.println("<td  width='80'>"+ (companyCount-STcount)+"</td>");
           out.println("<td  width='80'>"+STcount+"</td>");
           out.println("<td style='text-align:left;' >"+(double)STcount/companyCount +"</td>");
           out.println("</tr>");
           out.println("</table>");
           
            DefaultPieDataset dpd = new DefaultPieDataset();
            dpd.setValue("非ST公司总数", (companyCount - STcount));
    		dpd.setValue("ST公司总数", STcount);
          
          chart = ChartFactory.createPieChart("样本中ST比例",dpd, true, false, false);
          
          chart.getTitle().setFont(new Font("黑体",Font.BOLD,20));//设置标题字体
		 PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
		    piePlot.setLabelFont(new Font("黑体",Font.BOLD,15));
		    chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,15));
		    
		    String fileName = ServletUtilities.saveChartAsPNG(chart,400,300,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String urlPie = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
    
    	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
    	dataset.setValue(companyCount ,"公司总数","公司总数");
    	dataset.setValue((companyCount - STcount),"非ST总数","非ST总数");
	        dataset.setValue(STcount,"ST公司总数","ST公司总数");
	        
	        chart=ChartFactory.createBarChart("", "", 
	                "公司数量", dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
	                chart.setTitle(new TextTitle("样本中各类公司数量",new Font("黑体",Font.BOLD,20)));//可以重新设置标题，替换“hi”标题
	        CategoryPlot plot=(CategoryPlot)chart.getPlot();//获得图标中间部分，即plot
	        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
	        
	        categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,15));//设置横坐标字体
	        CategoryAxis domainAxis=plot.getDomainAxis();
	         //水平底部列表
	         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
	         //水平底部标题
	         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,15));
	         //垂直标题
	         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
	         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
	          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
	          
	          fileName = ServletUtilities.saveChartAsPNG(chart,400,300,session); 
	          String urlBar = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    
    
    
    
    
    
    
    
           
           out.println("<img src="+ urlBar +" width='400' height='300'>");
           out.println("<img src="+ urlPie +" width='400' height='300'>");
           
            out.println("</div>");
            out.println("</DIV>");
       
            %>
        

         <br/><br/>
        
		</div>

      
   
        
     

   
</BODY>
</HTML>
