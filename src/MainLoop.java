package com.Edu;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class MainLoop implements Runnable{
	private int WIDTH = 720;
	private int HEIGHT = 480;
	private boolean running = false;
	private long window;
	private Thread thread;	
	public static void main(String[] args) throws Exception{
		new MainLoop().start();
	}
	public void start(){
		running = true;
		thread = new Thread(this, "Teste");
		thread.start();
	}
	public void init(){
		if(!glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World!", NULL, NULL);
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - WIDTH)/2, (videoMode.height() - HEIGHT)/2);
		glfwSetKeyCallback(window, new Entradas());
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		//GLContext.createFromCurrent();
		/*glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		glEnable(GL_DEPTH_TEST);
		System.out.println(glGetString(GL_VERSION));*/
	}
	public void run() {
		init();
		while(running){
			update();
			render();
			if(glfwWindowShouldClose(window)){
				running = false;
			}
		}
	}
	public void update(){
		glfwPollEvents();
		if(Entradas.entradas[GLFW_KEY_SPACE])System.out.println("Jump");
	}
	public void render(){
		glfwSwapBuffers(window);
	}
}
