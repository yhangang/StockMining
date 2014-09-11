package org.a805.tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
* 生成验证码图片
*/
public class MakeCertPic {
	 //验证码图片中可以出现的字符集，可以根据需要修改
	 private char mapTable[]={
	   '0','1','2','3','4','5','6','7','8','9'
	 };
	/** 功能：生成彩色验证码图片
	 参数weidth为生成图片的宽度，参数height为生成图片的高度，参数os为页面的输出流
	*/
	 public String getCertPic(int width,int height,OutputStream os){
	  if(width<=0)
	   width=60;
	  if(height<=0)
	   height=17;
	  BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	  //获取图形上下文
	  Graphics g = image.getGraphics();
	  
	  //设定背景颜色
	  g.setColor(Color.WHITE);
	  g.fillRect(0,0,width,height);
	  //画边框
	  g.setColor(new Color(156,233,244));
	  g.drawRect(0,0,width+1,height+1);
	  //随机产生的验证码
	  String strEnsure = "";
	  //4代表4为验证码，如果要产生更多位的验证码，则加大数值
	  for(int i = 0;i<4;++i){
	   strEnsure += mapTable[(int) (mapTable.length*Math.random())];
	  }
	  //将认证码显示到图像中，如果要生成更多位的验证码，增加drawString语句
	  g.setColor(Color.BLUE);
	  g.setFont(new Font("Atlantic Inline",Font.BOLD,16));
	  String str = strEnsure.substring(0,1);
	  g.drawString(str,8,13);
	  g.setColor(Color.BLACK);
	  str = strEnsure.substring(1,2);
	  g.drawString(str, 20, 13);
	  g.setColor(Color.RED);
	  str = strEnsure.substring(2,3);
	  g.drawString(str, 35,13);
	  g.setColor(Color.MAGENTA);
	  str = strEnsure.substring(3,4);
	  g.drawString(str, 45, 13);
	  //随机产生2个干扰点
	  Random rand = new Random();
	  for(int i=0; i<10; i++){
	   int x = rand.nextInt(width);
	   int y = rand.nextInt(height);
	   //g.drawOval(x,y,1,1);
	  }
	  //释放图形上下文
	  g.dispose();
	  try{
	   //输出图形到页面
	   ImageIO.write(image, "JPEG", os);
	   
	  }catch (IOException e){
	   return "";
	  }
	  return strEnsure;
	 }

}