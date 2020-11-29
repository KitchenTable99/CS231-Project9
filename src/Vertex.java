import java.util.ArrayList;

/**
 *  Vertex class to be used in graphs. Created for project09
 *
 * @author cbitting
 */

public class Vertex implements Comparable<Vertex>{
	
	private ArrayList<Vertex> neighbors;
	private int x, y;
	private boolean visible, visited;
	private double distance;
	private Vertex parent;
	
	public Vertex(int x, int y) {
		neighbors = new ArrayList<Vertex>();
		this.x = x;
		this.y = y;
		visible = false;
		visited = false;
		distance = 0;
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
	
	public double getDist() {
		return distance;
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
		if (this.getX() == other.getX() & (this.getY() == other.getY())) {
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
