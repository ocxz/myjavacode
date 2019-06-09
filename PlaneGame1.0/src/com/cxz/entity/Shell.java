package com.cxz.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.cxz.game.Constant;

public class Shell extends GameObject{
	
	private double x = 100;
	private double y = 100;
	private int speed = 4;
	private int weight = 10;
	private int height = 10;
	private Color color = Color.YELLOW;
	private double degree = Math.random()*Math.PI*2;
	

	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Shell(){
		setX(x);
		setY(y);
		setSpeed(speed);
		setWeigth(weight);
		setHeight(height);
	}
	public Shell(double x, double y, int speed){
		super(x, y, speed);	
	}

	public Shell(double x, double y, int speed, int weight, int height){
		this(x,y,speed);
		this.weight = weight;
		this.height = height;
	}
	public Shell(double x, double y, int speed, int weight, int height, Color color){
		this(x,y,speed,weight,height);
		this.color = color;
	}
	
	
	@Override
	public void drawSelf(Graphics g) {
		Color c = g.getColor();
		g.setColor(this.color);
		if((int)getX()<10 || (int)getX()>Constant.GAME_WEIGHT-20) degree = Math.PI - degree;
		if((int)getY()<30 || (int)getY()>Constant.GAME_HEIGHT-20) degree = - degree;
		this.setX(getX()+getSpeed()*Math.cos(degree));
		this.setY(getY()+getSpeed()*Math.sin(degree));
		g.fillOval((int)getX(), (int)getY(), weight, height);
		
		
		g.setColor(c);
	}
}
