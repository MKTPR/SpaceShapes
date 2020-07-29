package spaceshapes.views;

import spaceshapes.Shape;
import spaceshapes.ShapeModel;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelListener;

public class Task2 extends Task1 implements ShapeModelListener{

	TreeModelEvent tevent;
	Shape[] paths;
	Shape[] child= new Shape[1];
	int[] index=new int[1];

	public Task2(ShapeModel model) {
		super(model);
	}

	@Override
	public void update(ShapeModelEvent event) {
		ShapeModelEvent.EventType eventType = event.eventType();

		if (eventType == ShapeModelEvent.EventType.ShapeRemoved) {
			for(TreeModelListener listener : listeners) {
				if (event.parent()!=null) {
					
					paths= new Shape[((event.parent()).path()).size()];
					paths= ((event.parent()).path()).toArray(paths);
					child[0]= event.operand();
					index[0]= event.index();
					tevent= new TreeModelEvent(event.source(),paths,index,child );

					listener.treeNodesRemoved(tevent);
				}
			}
		}	

		if (eventType == ShapeModelEvent.EventType.ShapeAdded) {
			for(TreeModelListener listener : listeners) {
				if (event.parent()!=null) {
					paths= new Shape[((event.parent()).path()).size()];
					paths= ((event.parent()).path()).toArray(paths);
					child[0]= event.operand();
					index[0]= event.index();
					tevent= new TreeModelEvent(event.source(),paths,index,child );

					listener.treeNodesInserted(tevent);
				}
			}	
		}
	}

}



