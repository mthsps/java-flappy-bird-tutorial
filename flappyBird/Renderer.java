package flappyBird;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		
		FlappyBird.flappyBird.repaint(arg0);
		
	}

}
