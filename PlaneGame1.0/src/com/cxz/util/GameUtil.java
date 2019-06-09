package com.cxz.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏工具类，用于提供画图片的方法
 * @author sowhat
 *
 */
public class GameUtil {

	// 工具类构造器最好私有化，对外提供statci工具方法即可
	private GameUtil(){}
	
	/**
	 * 指定图片的路径
	 * @param path
	 * @return   返回图片
	 */
	public static Image getImage(String path){
		BufferedImage bi = null;
		
		URL url = GameUtil.class.getClassLoader().getResource(path);
		try {
			bi = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}
