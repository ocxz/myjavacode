package com.cxz.ThreadApp;

import com.cxz.ThreadCreat.Rabbit;
import com.cxz.ThreadCreat.Tortoise;

public class RTApp {

	public static void main(String[] args) {
		
		Rabbit rabbit = new Rabbit();
		Tortoise tortoise = new Tortoise();
		
		rabbit.start();
		tortoise.start();
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("main==> " +i);
			
		}
	}
}
