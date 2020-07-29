package spaceshapes.views;

import java.util.ArrayList;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

public class Task1 implements TreeModel{

	ShapeModel _shapemodel;
	
	protected ArrayList<TreeModelListener> listeners= new ArrayList<TreeModelListener>();

	public Task1(ShapeModel model) {
		_shapemodel=model;
	}


	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		listeners.add(arg0);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		listeners.add(arg0);

	}

	@Override
	public Object getChild(Object arg0, int arg1) {
		if (!(arg0==null)) {
		if (isLeaf(arg0)) {
			return null;
		}
		if (arg1>=getChildCount(arg0)) {
			return null;
		}
		return ((CarrierShape) arg0).shapeAt(arg1);
		}
		return null;
	}

	@Override
	public int getChildCount(Object arg0) {
		if (arg0 instanceof CarrierShape) {
			return ((CarrierShape) arg0).shapeCount();
		}
		else return 0;
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		if ((arg0 ==null)||(arg1 ==null)) {
			return -1;
		}
		if (!(isLeaf(arg0))){
		return ((CarrierShape) arg0).indexOf((Shape) arg1);
		}
		else return -1;
	}

	@Override
	public Object getRoot() {
		if (_shapemodel.root()!=null) {
			return _shapemodel.root();
		}
		return null;
	}

	@Override
	public boolean isLeaf(Object arg0) {
		if (!(arg0 instanceof CarrierShape)) {
			return true;
		}
		return false;
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		
	}

}
