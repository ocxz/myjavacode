package com.cxz.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * ��Ϸʵ���࣬�����˸���Ϸ�����һЩͨ�����Ժͷ��������ڿ���
 * @author sowhat
 *
 */
public class GameObject {

	private Image image;   // ����ͼƬ
	private double x=0,y=0;    // ��������
	private int speed=0;    // �ƶ��ٶ�
	private int weigth,height;    // ���峤��
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getWeigth() {
		return weigth;
	}
	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public GameObject(Image image, double x, double y, int speed, int weigth,
			int height) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.weigth = weigth;
		this.height = height;
	}
	public GameObject(Image image, double x, double y) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	
	
	
	public GameObject(double x, double y, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	public GameObject(double x, double y, int speed, int weigth, int height) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.weigth = weigth;
		this.height = height;
	}
	public GameObject(Image image, double x, double y, int speed) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	public GameObject(Image image, double x, double y, int weigth, int height) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.weigth = weigth;
		this.height = height;
	}
	public GameObject() {
		super();
	}
	
	/**
	 * �������Լ�
	 * @param g
	 */
	public void drawSelf(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	/**
	 * @return �õ�������Ӿ��Σ�����������ײ���
	 */
	public Rectangle getRectangle(){
		return new Rectangle((int)x, (int)y, weigth, height);
	}
}
