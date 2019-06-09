package com.cxz.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.cxz.util.GameUtil;

public class Explode {

	private double x, y;
	private int count;
	private static Image[] images = new Image[16];
	
	public Explode(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}


	

	static{
		for (int i=0; i<images.length; i++){
			images[i] = GameUtil.getImage("images/explode/e" + (i+1) + ".gif");
//			images[i].getWidth(null);
		}
	}
	
	public void drawSelf(Graphics g){
		if(count<15){
			g.drawImage(images[count], (int)x, (int)y, null);
			count++;
		}
	}
}
