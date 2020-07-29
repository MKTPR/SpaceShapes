package spaceshapes;

import java.awt.Color;

public class DynamicShape extends Shape {

	

	protected Color _inputcolor=Color.white;

	public DynamicShape() {
		super();
	}
	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
		super(x,y,deltaX,deltaY,width,height);
		_inputcolor=color;
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color color) {
		super(x,y,deltaX,deltaY,width,height,text);
		_inputcolor=color;
	}

	public void paint2(Painter painter) {
		if (_filled) {
			painter.setColor(_inputcolor);
			painter.fillRect(_x, _y, _width, _height);
			painter.setColor(new Color(212, 212, 212));
		}
		else {
		
			painter.drawRect(_x,_y,_width,_height);
		
		}
	}
	
}
