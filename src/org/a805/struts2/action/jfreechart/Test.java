package org.a805.struts2.action.jfreechart;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionSupport;

public class Test extends ActionSupport{
	 private JFreeChart chart;//这里变量名必须是chart，不能是其他变量名


	    public JFreeChart getChart()//getChart()方法是必须的，setChart()可以不写.
	    {                            //在action中的chart属性的get方法中，创建chart对象，然后进行设置plot主体和颜色；以及legend颜色和字体
	    
	        chart = ChartFactory.createBarChart("兴趣统计结果", "项目", "结果", this
	                .getDataset(), PlotOrientation.VERTICAL, false, false, false);
	        
	        
	        chart.setTitle(new TextTitle("兴趣统计结果",new Font("黑体",Font.BOLD,22)));
	        
	        CategoryPlot plot = (CategoryPlot)chart.getPlot();
	        
	        CategoryAxis categoryAxis = plot.getDomainAxis();
	        
	        categoryAxis.setLabelFont(new Font("宋体",Font.BOLD,22));
	        
	        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);//设置角度
	        
	        NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
	        
	        numberAxis.setLabelFont(new Font("宋体",Font.BOLD,22));
	        
	        
	      
	        CategoryAxis domainAxis=plot.getDomainAxis();
	         //水平底部列表
	         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));
	         //水平底部标题
	         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));
	         //垂直标题
	         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
	         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
	          
	        
	        
	        return chart;
	    }


	    @Override
	    public String execute() throws Exception
	    {
	        return SUCCESS;
	    }

	  

	    @SuppressWarnings("unchecked")
	    private CategoryDataset getDataset() //得到数据集。
	    {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	        dataset.setValue(10,"a","管理人员");
	        dataset.setValue(20,"b","市场人员");
	        dataset.setValue(40,"c","开发人员");
	        dataset.setValue(15,"d","其他人员");

	        return dataset;
	    }

}
