package org.testImgToBase64;
/**
* @author JoPson E-mail:jopson@sina.com
* @version 创建时间：2017年1月22日 上午9:16:13
*/

import java.awt.AlphaComposite;
import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics2D;  
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileOutputStream;  
 
import javax.imageio.ImageIO;  
 
public class WaterMarkUtils {  
   /** 
    * 图片添加水印 
    * @param srcImgPath 需要添加水印的图片的路径 
    * @param outImgPath 添加水印后图片输出路径 
    * @param markContentColor 水印文字的颜色 
    * @param waterMarkContent 水印的文字 
    */  
   public void mark(String srcImgPath, String outImgPath, Color markContentColor, String waterMarkContent) {  
       try {  
           // 读取原图片信息  
           File srcImgFile = new File(srcImgPath);  
           Image srcImg = ImageIO.read(srcImgFile);  
           int srcImgWidth = srcImg.getWidth(null);  
           int srcImgHeight = srcImg.getHeight(null);  
           System.out.println("宽度:"+srcImgHeight);
           System.out.println("高度:"+srcImgWidth);
           // 加水印  
           BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);  
           Graphics2D g = bufImg.createGraphics();  
           g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);  
           g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
           Font font = new Font("Droid Sans Fallback", Font.PLAIN, 36);   
           g.setColor(markContentColor); //根据图片的背景设置水印颜色  
           g.setFont(font);  
           //int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;  
           //int y = srcImgHeight - 3;  
           int x = 89;  
           int y = 528;  
           g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,1.0f));
           g.drawString(waterMarkContent, x, y);  
           g.dispose();  
           // 输出图片  
           FileOutputStream outImgStream = new FileOutputStream(outImgPath);  
           ImageIO.write(bufImg, "jpg", outImgStream);  
           outImgStream.flush();  
           outImgStream.close();  
       } catch (Exception e) {  
           e.printStackTrace();  
       }  
   }  
     
   /** 
    * 获取水印文字总长度 
    * @param waterMarkContent 水印的文字 
    * @param g 
    * @return 水印文字总长度 
    */  
   public int getWatermarkLength(String waterMarkContent, Graphics2D g) {  
       return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());  
   }  
     
   public static void main(String[] args) {  
       // 原图位置, 输出图片位置, 水印文字颜色, 水印文字  
       new WaterMarkUtils().mark("d:/353412610272544231(1).jpg", "d:/353412610272544231(1).jpg", Color.white, "123689.00元");  
  }  
}  