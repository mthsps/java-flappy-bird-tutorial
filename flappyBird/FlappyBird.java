package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener {
	
	public static FlappyBird flappyBird;
	
	public final int WIDTH = 800, HEIGHT = 800;
	
	public Renderer renderer;
	
	public Rectangle bird;
	
	public ArrayList<Rectangle> columns;
	
	public int ticks, yMotion, score;
	
	public boolean gameOver, started;
	
	public Random rand;
	
	public FlappyBird() {
		
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		rand = new Random();
		
		jframe.add(renderer);
		jframe.setTitle("Flappy Bird");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setResizable(false);
		jframe.setVisible(true);
		
		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		columns = new ArrayList<Rectangle>();
		
		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);
		
		timer.start();
		
	}
	
	public void addColumn(boolean start) {
		
		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);
		
		if(start) {
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height -120, width, height));
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		} else {
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height -120, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
		}
		
		
	}
	
	public void paintColumn(Graphics arg0, Rectangle column) {
		
		arg0.setColor(Color.green.darker());
		arg0.fillRect(column.x, column.y, column.width, column.height);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		renderer.repaint();
		
	}
	
	
	public void repaint(Graphics arg0) {
		
		arg0.setColor(Color.cyan);
		arg0.fillRect(0, 0, WIDTH, HEIGHT);
		
		arg0.setColor(Color.orange);
		arg0.fillRect(0, HEIGHT -120, WIDTH, 120);
		
		arg0.setColor(Color.green);
		arg0.fillRect(0, HEIGHT -120, WIDTH, 20);
		
		arg0.setColor(Color.red);
		arg0.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		
		for(Rectangle column : columns) {
			paintColumn(arg0,column);
		}
		
		arg0.setColor(Color.white);
		arg0.setFont(new Font("Arial", 1, 100));
		
		if (!started) arg0.drawString("Click to start!", 75, HEIGHT / 2 - 50);
		
		if (gameOver) arg0.drawString("Game Over!", 100, HEIGHT / 2 - 50);
		
		if (!gameOver && started) arg0.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
		
	}
	
	public static void main(String[] args) {
		
		flappyBird = new FlappyBird();
		
	}

}
