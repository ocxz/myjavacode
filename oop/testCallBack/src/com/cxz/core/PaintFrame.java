package com.cxz.core;

import com.cxz.GameFrames.GameFrame01;
import com.cxz.GameFrames.GameFrame02;
import com.cxz.imp.IFrame;

public class PaintFrame {

	public static void drawFrame(IFrame f){
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息栈");
		
		//开始画窗口
		f.paint();
		
		System.out.println("启动缓存，增加效率");
	}
	
	public static void main(String[] args) {
		PaintFrame.drawFrame(new GameFrame01());
		System.out.println("***********************************");
		PaintFrame.drawFrame(new GameFrame02());
	}
}
