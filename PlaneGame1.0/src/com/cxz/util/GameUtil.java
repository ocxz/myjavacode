package com.cxz.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Ϸ�����࣬�����ṩ��ͼƬ�ķ���
 * @author sowhat
 *
 */
public class GameUtil {

	// �����๹�������˽�л��������ṩstatci���߷�������
	private GameUtil(){}
	
	/**
	 * ָ��ͼƬ��·��
	 * @param path
	 * @return   ����ͼƬ
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
