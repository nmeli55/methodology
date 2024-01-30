import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class cxriliMidterm extends GraphicsProgram {
	private static final double ROWS = 8;
	private static final double COLUMNS = 8;
	private GRect firstBlack = null;
	private GRect secondBlack = null;
	public void run() {
		drawGrid();
		addMouseListeners();
	}

	private void drawGrid() {
		double length = Math.min(getWidth(), getHeight()) / ROWS;
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				GRect cell = new GRect(length, length);
				cell.setFilled(true);
				cell.setFillColor(Color.WHITE);
				add(cell, i * length, j * length);
			}
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		GObject obj = (GRect)getElementAt(e.getX(), e.getY());
		if( obj == null ) {
			return;
		}
		
		if(obj.setFillColor() == Color.WHITE) {
			obj.setFillColor(Color.BLACK);
			if(firstBlack == null) {
				firstBlack = obj;
			} else if (secondBlack == null){
				secondBlack = obj;
			} else {
				firstBlack.setFillColor(Color.WHITE);
				firstBlack = secondBlack;
				secondBlack = obj;
			}
		} else {
			obj.setFillColor(Color.WHITE);
			if(obj == firstBlack) {
			} else {
				firstBlack = secondBlack;
			}
			secondBlack = null;
		}
	}

}
