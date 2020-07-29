package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Maric
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;
	private int x;
	private int y;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}
	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}
	
	public void getColor() {
		_g.getColor();
	}
	
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}

	@Override
	public void setColor(Color color) {		
		_g.setColor(color);
	}

	@Override
	public void translate(int x, int y) {
		_g.translate(x, y);
		
	}
	@Override
	public void drawCentredText(String text, Shape h) {
		FontMetrics metrics=_g.getFontMetrics();
		x= h._x + (h._width - metrics.stringWidth(text))/2;
		y= h._y + (h._height + (metrics.getAscent()-metrics.getDescent()))/2;
		
		_g.drawString(text, x, y);
	}

	@Override
	public void drawImage(Image _picture, int _x, int _y, int _width, int _height) {
		_g.drawImage(_picture,_x,_y,_width,_height, null);
	}
}
