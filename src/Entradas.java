package com.Edu;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;

public class Entradas implements GLFWKeyCallbackI{
	
	public static boolean[] entradas = new boolean[65536];

	@Override
	public void invoke(long arg0, int arg1, int arg2, int arg3, int arg4) {
		entradas[arg1] = arg3 != GLFW.GLFW_RELEASE;
		// TODO Auto-generated method stub
		
	}

}
