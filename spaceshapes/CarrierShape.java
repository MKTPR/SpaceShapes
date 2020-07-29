package spaceshapes;

public class CarrierShape extends Shape{

	protected Shape[] _shapes = new Shape[100];
	protected int _index;
	//Carrier Shape objects
	public CarrierShape() {
		super();
	}

	//Object with location
	public CarrierShape(int x, int y){
		super(x,y);
	}

	//Object with location, velocity and direction
	public CarrierShape(int x, int y, int deltaX, int deltaY){
		super(x,y,deltaX,deltaY);
	}

	//Object with location, velocity, direction, width and height
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height){
		super(x,y,deltaX,deltaY,width,height);
		_index=0;

	}
	
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text){
		super(x,y,deltaX,deltaY,width,height,text);
		_index=0;

	}

	//Moves Carrier shape within the boards specified by arguments width and height
	public void move(int width, int height){
		for (int i=0;i<_index;i++) {
			_shapes[i].move(_width, _height);
		}
		super.move(width, height);
	}

	//Carrier shape object by drawing a rectangle around the edge of its bounding box. Then Carriershape object's children are then painted.
	public void paint2(Painter painter){
		painter.drawRect(_x,_y,_width,_height);
		painter.translate(_x, _y);
		for (int i=0;i<_index;i++) {
			_shapes[i].paint(painter);
		}
		painter.translate(-_x, -_y);
	}

	/**
	 * Attempts to add a shape to a carrier shape object.
	 * If successful, a two way link is  established between the CarrierShape and the newly added shape
	 * @param shape - the shape to be added
	 * @ throws IllegalArgument Exception if an attempt is made to add a Shape to a CarrierShape instance
	 * and it already exists.
	 * Also exception thrown when shape does not fit within the bounds of the CarrierShape object.
	 */
	void add(Shape shape) throws IllegalArgumentException {
		if (contains(shape)) {
			throw new IllegalArgumentException();
		}
		else if ((shape.width()>_width)||(shape.height()>_height)) {
			throw new IllegalArgumentException();
		}
		else if (((shape.width()+shape._x)>_width)||(shape.height()+shape._y)>_height){
			throw new IllegalArgumentException();
		}
		else if (shape.parent()!=null) {
			throw new IllegalArgumentException();
		}
		else {
			_shapes[_index]=shape;
			_index++;
			shape._parent[0]=this;
		}
	}


	/**
	 * Removes a particular Shape from a CarrierShape instance
	 * Once removed, the twoway link between the CarrierShape and its former child is destroyed
	 * This method has no effect if the Shape specified to remove is not a child of the CarrierShape
	 * Note that this method has package visibility  for reasons that will become apparent in SpaceShape III. 
	 *  @param shape the shape to be removed . 
	 */
	void remove(Shape shape) {
		int x=indexOf(shape);
		if (x!=-1) {
			for (int i=x;i<_index;i++) {
				_shapes[i]=_shapes[i+1];
			}
		}
		_index--;
		shape._parent[0]=null;
	}

	/**
	 * Returns the Shape at a specified position within a CarrierShape .
	 * If the position specified is less than zero or greater than the number of children 
	 * stored in the CarrierShape less one this method throws an  IndexOutOfBoundsException . 
	 *  @param index the specified index position .
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		if ((index<0)||(index>=_index)) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return _shapes[index];
		}
	
	}

	/**
	 * Returns the number of children contained within a CarrierShape object.
	 * Note this method is not  recursive, it simply returns the  number of children at
	 * the top level within the callee CarrierShape object.
	 */
	public int shapeCount() {
		return (_index);
	}

	/**
	 * Returns the index of a specific child within a carriershape object. If the shape
	 * specified is not within, method return -1. other wise, 0~ shapeCount()-1.
	 * @param - shape requested.
	 */
	public int indexOf(Shape shape) {
		for (int i=0;i<_index;i++) {
			if (_index==0) {
				return -1;
			}
			else if (_shapes[i] == (shape)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns true if the Shape argument is a child of the CarrierShape object on which
	 * this method is called, false otherwise.
	 */
	public boolean contains(Shape shape) {
		if (indexOf(shape)==-1) {
			return false;
		}
		else {
			return true;
		}
	}

	
	
}
