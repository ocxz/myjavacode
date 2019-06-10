package com.cxz.GameFrames;

import com.cxz.imp.IFrame;

public class GameFrame01 implements IFrame{

	@Override
	public void paint() {
		System.out.println("GameFrame01的paint方法执行，画game01游戏窗口");
	}

}
