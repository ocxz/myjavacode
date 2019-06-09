package com.cxz.game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;


import com.cxz.entity.Explode;
import com.cxz.entity.Plane;
import com.cxz.entity.Shell;
import com.cxz.util.GameUtil;

/**
 * 飞机游戏的主窗口
 * @author sowhat
 *
 */
public class MyGameFrame extends JFrame{
	
	Image bg = GameUtil.getImage("images/bg.jpg");
	Image planeImage = GameUtil.getImage("images/plane.png");
	Plane plane = new Plane(planeImage, 250, 250, 4);
	Shell[] shells = new Shell[25];
	Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
	Explode bao;
	Date startTime = new Date();
	private int count = 0;
	private boolean end = true;
	
	public void paint(Graphics g) {                //画的方法，会被自动调用
		
		Color color = g.getColor();         // 将画笔原来的颜色保存
		Font  font = g.getFont();         // 将画笔原来的字体保存

		g.drawImage(bg, 0, 0, null);
		
		plane.drawSelf(g);
		for(int i=0; i<shells.length; i++){
			shells[i].drawSelf(g);
			if(shells[i].getRectangle().intersects(plane.getRectangle())){
				plane.setLive(false);
				if(bao == null){
					bao = new Explode(plane.getX(), plane.getY());
				}
				g.setColor(Color.YELLOW);
				g.setFont(new Font("宋体", Font.BOLD, 15));
				g.drawString("存货", 250, 50);
				bao.drawSelf(g);
			}
		}

		
		//还原画笔
		g.setColor(color);
		g.setFont(font);
	}
	
	public Color getRandomColor(Color[] colors){
		int index = (int)(Math.random()*colors.length);
		return colors[index];
	}

	private Image offScreenImage = null;
	 
	/**
	 * 加入双缓冲，解决闪烁问题
	 */
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WEIGHT,Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	/**
	 * 初始化窗口
	 */
	public void lauchFrame(){
		
		this.setTitle("sowhat程序作品");
		this.setSize(Constant.GAME_WEIGHT,Constant.GAME_HEIGHT);
		this.setLocation(350, 100);
		for(int i=0; i<shells.length; i++){
			shells[i] = new Shell();
			shells[i].setColor(getRandomColor(colors));
		}
		
		//添加窗口事件，匿名类来实现，实现窗口的关闭
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 添加按键事件监听
		this.addKeyListener(new KeyMonitor());
		
		new PaintThread().start();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyGameFrame  myGameFrame = new MyGameFrame();
		myGameFrame.lauchFrame();
	}
	
	
	/**
	 * 内部类  方便调用方法repaint();
	 * 线程类，创建一个线程，帮我们一直重画窗口
	 * @author sowhat
	 *
	 */
	class PaintThread extends Thread{
		@Override
		public void run() {
			try {
				while (true) {
					repaint();
					sleep(40);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
	  }
	}
	
	/**
	 * 键盘事件监听类
	 * @author sowhat
	 *
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
}
