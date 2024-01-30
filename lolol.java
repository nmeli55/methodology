
import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class lolol extends GraphicsProgram {
	//დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა
	//მარცხენა კედლის შუა წერტილიდან მარჯვენა კედლამდე. 
	private static final int RADIUS = 100;
	private static final int PAUSE_MS = 30;
	public void run() {
		GOval circle = new GOval(RADIUS, RADIUS);
		int startX = 0;
		int startY = getHeight()/2 - RADIUS;
		circle.setLocation(startX, startY);
		add(circle);
		circle.setFilled(true);
		circle.setColor(Color.GREEN);
		int finalX = getWidth() - RADIUS;
		int vx = 5;
		int vy = 0;
		
		while(circle.getX() <= finalX ) {
			circle.move(vx, vy);
			pause(PAUSE_MS);
		}
		
	
	}
}
