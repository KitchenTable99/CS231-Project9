import java.util.ArrayList;

/**
 *  Vertex class to be used in graphs. Created for project08
 *
 * @author cbitting
 */

public class Vertex implements Comparable<Vertex>{
	
	private Vertex[] neighbors;
	private int x, y;
	private boolean visible, visited;
	private double distFromRoot;
	private Vertex parent;
	
	public Vertex(int x, int y) {
		neighbors = new Vertex[4];
		this.x = x;
		this.y = y;
		visible = false;
		visited = false;
		distFromRoot = 0;
		parent = null;
	}
	
	// accessors and mutators
	public ArrayList<Vertex> getNeighbors() {
		return null;
	}
	
	public Vertex isNeighbor(int x, int y) {
		return null;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public double getRootDist() {
		return distFromRoot;
	}
	
	public Vertex getParent() {
		return parent;
	}
		
	public double distance(Vertex other) {
		return 0;
	}
	
	public void connect(Vertex other) {
		return;
	}
	
	public int numNeighbors() {
		return 0;
	}
	
	public boolean equals(Vertex other) {
		if ((this.getX() == other.getX() & (this.getY() == other.getY()))) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return null;
	}

	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
