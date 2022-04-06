package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener {
	
	public static FlappyBird flappyBird;
	
	public final int WIDTH = 800, HEIGHT = 800;
	
	public Renderer renderer;
	
	public Rectangle bird;
	
	public ArrayList<Rectangle> columns;
	
	public FlappyBird() {
		
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		
		jframe.add(renderer);
		jframe.setTitle("Flappy Bird");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setResizable(false);
		jframe.setVisible(true);
		
		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		columns = new ArrayList<Rectangle>();
		
		timer.start();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		renderer.repaint();
		
	}
	
	public void paintColumn(Graphics arg0, Rectangle column) {
		
		arg0.setColor(Color.green.darker());
		arg0.fillRect(column.x, column.y, column.width, column.height);
		
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
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		flappyBird = new FlappyBird();
		
	}

}
