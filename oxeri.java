import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class oxeri extends GraphicsProgram {
	private static final double RADIUS = 100;
	public GOval ball;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		addMouseListeners();
		ball = new GOval(RADIUS, RADIUS);
		ball.setFilled(true);
		ball.setColor(rgen.nextColor());
		add(ball, getWidth()/2 - RADIUS, getHeight()/2 - RADIUS);
	}
	
	public void mouseDragged(MouseEvent e) {
		double y = getHeight()/2 + (getHeight()- e.getY());
		if(e.getX() > getWidth()/2) {
			double x = e.getX();
		} else {
			double x = getWidth()/2 -
		}
		
		ball.setSize(, RADIUS);
	}
	
}
