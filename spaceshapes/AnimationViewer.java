package spaceshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Simple GUI program to show an animation of shapes in a confined space. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimised, and maximised. The state of an
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Maric Kim
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Shapes to animate.
	private List<Shape> _shapes;

	private Timer _timer = new Timer(DELAY, this);
	
	private CarrierShape _topLevelNest;
	private CarrierShape _midLevelNest;
	private CarrierShape _bottomLevelNest;
	
	private RectangleShape recty;
	private CarrierShape _shape1;
	private CarrierShape _shape2;
	private CarrierShape _shape3;
	private CarrierShape _shape4;
	private DynamicShape _shape5;
	private DynamicShape _shape6;
	private HexagonShape _shape7;
	private OvalShape _shape8;

	/**
	 * Creates an AnimationViewer instance with a list of Shape objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		this.setBackground(Color.BLACK);
		_shapes = new ArrayList<Shape>();
	
		_shape1= new CarrierShape(70,120,3,2,500,200);
		_shape2= new CarrierShape(600,250,-3,1,150,200,"CoolShapes");
		_shape3= new CarrierShape(30,60,-1,4,80,60, "Yeah not much");
		_shape4= new CarrierShape(230,60,2,1,200,100);
		_shape5= new DynamicShape(100,200,3,4,120,60, "yeah",Color.GREEN);
		_shape6= new DynamicShape(70,30,1,2,80,30, "what",Color.PINK);
		_shape7= new HexagonShape(0,0,1,1,60,30);
		_shape8= new OvalShape(3,2,9,8,20,10, "HUH");
		// Populate the list of Shapes
		
		_shape1.add(_shape4);
		_shape2.add(_shape3);
		_shape4.add(_shape6);
		_shape3.add(_shape7);
		_shape2.add(_shape8);
		_shapes.add(_shape1);
		_shapes.add(_shape2);
		_shapes.add(_shape5);
		
		_topLevelNest = new CarrierShape(0, 0, 1, 2, 100, 100, "weekweek");
		_midLevelNest = new CarrierShape(50, 50, 1, -1, 50, 50, "rorror");
		_bottomLevelNest = new CarrierShape(15, 10, 1, 1, 10, 10);
	
		
		recty=new RectangleShape(120,150,-1,2,200,120, "recty");
		_shapes.add(recty);
		_midLevelNest.add(_bottomLevelNest);
		_topLevelNest.add(_midLevelNest);
		_shapes.add(_topLevelNest);
		
		
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Shape s : _shapes) {
			s.paint(painter);
			s.move(width, height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
