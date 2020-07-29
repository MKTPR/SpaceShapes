package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and RectangleShape.
 * 
 * @author Maric
 * 
 */
public class TestShape {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to see if oval shape is properly drawn.
	 */
	@Test 
	public void testOvalDrawn() {
		OvalShape shape= new OvalShape(100,20,12,15);
		shape.paint(_painter);
		assertEquals("(oval 100,20,25,35)",_painter.toString());
	}
	@Test 
	public void testHexagonDrawn() {
		HexagonShape shape= new HexagonShape(100,20,12,15);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,20)(line 112,20,125,37)(line 125,37,112,55)(line 112,55,100,37)",_painter.toString());
	}
	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", 
				_painter.toString());
	}
	@Test 
	public void testOvalSimpleMove() {
		OvalShape shape= new OvalShape(100,20,12,15);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)",_painter.toString());		
	}
	@Test 
	public void testHexagonSimpleMove() {
		HexagonShape shape= new HexagonShape(100,20,12,15);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,20)(line 112,20,125,37)(line 125,37,112,55)(line 112,55,100,37)(line 112,52,124,35)(line 124,35,137,52)(line 137,52,124,70)(line 124,70,112,52)",_painter.toString());		
	}
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", _painter.toString());
	}
	@Test
	public void testOvalMoveWithBounceOffRight() {
		OvalShape shape = new OvalShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)"
				+ "(oval 98,50,25,35)",_painter.toString());
	}
	@Test
	public void testHexagonMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,20)(line 112,20,125,37)(line 125,37,112,55)(line 112,55,100,37)(line 110,52,122,35)(line 122,35,135,52)(line 135,52,122,70)(line 122,70,110,52)(line 98,67,110,50)(line 110,50,123,67)(line 123,67,110,85)(line 110,85,98,67)",_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", _painter.toString());
	}
	
	@Test
	public void testOvalMoveWithBounceOffLeft() {
		OvalShape shape = new OvalShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"
				+ "(oval 12,50,25,35)",_painter.toString());
	}
	@Test
	public void testHexagonMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,37,22,20)(line 22,20,35,37)(line 35,37,22,55)(line 22,55,10,37)(line 0,52,12,35)(line 12,35,25,52)(line 25,52,12,70)(line 12,70,0,52)(line 12,67,24,50)(line 24,50,37,67)(line 37,67,24,85)(line 24,85,12,67)",_painter.toString());
	}
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		RectangleShape shape = new RectangleShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,90,25,35)(rectangle 0,100,25,35)"
				+ "(rectangle 12,85,25,35)", _painter.toString());
	}
	@Test
	public void testOvalMoveWithBounceOffBottomAndRight() {
		OvalShape shape = new OvalShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(oval 10,90,25,35)(oval 0,100,25,35)"
				+ "(oval 12,85,25,35)", _painter.toString());
	}
	@Test
	public void testHexagonMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,107,22,90)(line 22,90,35,107)(line 35,107,22,125)(line 22,125,10,107)(line 0,117,12,100)(line 12,100,25,117)(line 25,117,12,135)(line 12,135,0,117)(line 12,102,24,85)(line 24,85,37,102)(line 37,102,24,120)(line 24,120,12,102)", _painter.toString());
	}
	@Test
	public void testDynamicShapeBounceOffLeft() {
		DynamicShape shape = new DynamicShape(10, 90, -12, 0);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 10,90,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=255,g=255,b=255](rectangle 0,90,25,35)java.awt.Color[r=212,g=212,b=212]", _painter.toString());
	}
	@Test
	public void testDynamicShapeBounceOffBottom() {
		DynamicShape shape = new DynamicShape(10, 90, 0, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 10,90,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=212,g=212,b=212](rectangle 10,100,25,35)java.awt.Color[r=255,g=255,b=255]", _painter.toString());
	}
	
	@Test
	public void testDynamicShapeBounceOffRight() {
		DynamicShape shape = new DynamicShape(115, 90, 12, 0);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 115,90,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=255,g=255,b=255](rectangle 100,90,25,35)java.awt.Color[r=212,g=212,b=212]",_painter.toString());
	}
	
	@Test
	public void testDynamicShapeBounceOffTop() {
		DynamicShape shape = new DynamicShape(10, 10, 0, -15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 10,10,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=212,g=212,b=212](rectangle 10,0,25,35)java.awt.Color[r=255,g=255,b=255]", _painter.toString());
	}
	
	@Test
	public void testDynamicShapeBounceOffTopAndLeft() {
		DynamicShape shape = new DynamicShape(10, 10, -6, -15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 10,10,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=212,g=212,b=212](rectangle 4,0,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=255,g=255,b=255](rectangle 0,15,25,35)java.awt.Color[r=212,g=212,b=212]",_painter.toString());
	}
	
	@Test
	public void testDynamicShapeBounceOffTopAndRight() {
		DynamicShape shape = new DynamicShape(80, 10, 12, -15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 80,10,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=212,g=212,b=212](rectangle 92,0,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=255,g=255,b=255](rectangle 100,15,25,35)java.awt.Color[r=212,g=212,b=212]",_painter.toString());
	}
	
	@Test
	public void testDynamicShapeBounceOffBottomAndLeft() {
		DynamicShape shape = new DynamicShape(10, 90, -6, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 10,90,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=212,g=212,b=212](rectangle 4,100,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=255,g=255,b=255](rectangle 0,85,25,35)java.awt.Color[r=212,g=212,b=212]",_painter.toString());
	}
	
	@Test
	public void testDynamicShapeBounceOffBottomAndRight() {
		DynamicShape shape = new DynamicShape(80, 90, 12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("java.awt.Color[r=212,g=212,b=212](rectangle 80,90,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=212,g=212,b=212](rectangle 92,100,25,35)java.awt.Color[r=255,g=255,b=255]java.awt.Color[r=255,g=255,b=255](rectangle 100,85,25,35)java.awt.Color[r=212,g=212,b=212]",_painter.toString());	
	}
}
