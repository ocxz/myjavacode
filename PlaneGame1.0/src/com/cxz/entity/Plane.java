package com.cxz.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{

	private boolean left,right,up,down;
	private boolean live = true;
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public Plane(){
	}
	public Plane(Image image, double x, double y, int speed){
		super(image, x, y, speed);
		setWeigth(image.getWidth(null));
		setHeight(image.getHeight(null));
	}
	
	
	@Override
	public void drawSelf(Graphics g) {
		
		if(live){
			if(left)  setX(getX()-getSpeed());
			if(right) setX(getX()+getSpeed());
			if(up)    setY(getY()-getSpeed());
			if(down)  setY(getY()+getSpeed());
			g.drawImage(getImage(), (int)getX(), (int)getY(), null);
		}
	}
	
	/**
	 * 按下某个键，添加方向
	 * @param e
	 */
	public void addDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	/**
	 * 释放某个键，取消方向
	 * @param e
	 */
	public void minusDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}

}
