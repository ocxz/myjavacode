package com.cxz.core;

import com.cxz.GameFrames.GameFrame01;
import com.cxz.GameFrames.GameFrame02;
import com.cxz.imp.IFrame;

public class PaintFrame {

	public static void drawFrame(IFrame f){
		System.out.println("�����߳�");
		System.out.println("����ѭ��");
		System.out.println("�鿴��Ϣջ");
		
		//��ʼ������
		f.paint();
		
		System.out.println("�������棬����Ч��");
	}
	
	public static void main(String[] args) {
		PaintFrame.drawFrame(new GameFrame01());
		System.out.println("***********************************");
		PaintFrame.drawFrame(new GameFrame02());
	}
}
