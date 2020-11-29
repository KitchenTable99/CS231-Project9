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
	private double cost;
	private Vertex parent;
	
	public Vertex(int x, int y, double cost) {
		neighbors = new ArrayList<Vertex>();
		this.x = x;
		this.y = y;
		visible = false;
		visited = false;
		this.cost = cost;
		parent = null;
	}
	
	// accessors and mutators
	public ArrayList<Vertex> getNeighbors() {
		return neighbors;
	}
	
	public Vertex getNeighbor(int x, int y) {
		// set up
		Vertex neighbor = null;
		boolean found = false;
		// go through neighbor list loooking for ints
		for (Vertex v : neighbors) {
			neighbor = v;
			if (v.getX() == x && v.getY() == y) {
				found = true;
				break;
			}
		}
		if (found) {
			return neighbor;
		} else {
			return null;
		}
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
	
	public double getCost() {
		return cost;
	}
	
	public Vertex getParent() {
		return parent;
	}
		
	public double distance(Vertex other) {
		// set up variables
		double x1 = x;
		double x2 = other.getX();
		double y1 = y;
		double y2 = other.getY();
		// create legs
		double ac = Math.abs(y2 - y1);
		double cb = Math.abs(x2 - x1);
		// find hypot
		return Math.hypot(ac, cb);
		
	}
	
	public void connect(Vertex other) {
		neighbors.add(other);
	}
	
	public int numNeighbors() {
		return neighbors.size();
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
		double oCost = o.getCost();
		return (int) (cost - oCost);
	}

}
