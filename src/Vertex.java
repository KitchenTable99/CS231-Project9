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
	
	
	/**
	 * @return the ArrayList<Vertex> of neighbors
	 */
	public ArrayList<Vertex> getNeighbors() {
		return neighbors;
	}
	
	/**
	 * @param x position of neighbor
	 * @param y position of neighbor
	 * @return Vertex object of neighbor if in neighbor list. Returns null if not
	 */
	public Vertex getNeighbor(int x, int y) {
		// set up
		Vertex neighbor = null;
		// go through neighbor list loooking for ints
		for (Vertex v : neighbors) {
			if (v.getX() == x && v.getY() == y) {
				neighbor = v;
				break;
			}
		}
		return neighbor;
	}
	
	/**
	 * @return x position
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return y position
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return if object visible
	 */
	public boolean isVisible() {
		return visible;
	}
	
	/**
	 * @return if object visited
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * @return the internal cost field
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * @return the parent vertex.
	 */
	public Vertex getParent() {
		return parent;
	}
		
	/**
	 * @param other Vertex to compare with
	 * @return the Euclidean distance between two vertexes
	 */
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
	
	/**
	 * @param other Vertex to connect this one to
	 */
	public void connect(Vertex other) {
		neighbors.add(other);
	}
	
	/**
	 * @return the number of neighbors
	 */
	public int numNeighbors() {
		return neighbors.size();
	}
	
	/**
	 * @param other Vertex to compare to
	 * @return if the Vertexes are equal
	 */
	public boolean equals(Vertex other) {
		if (this.getX() == other.getX() & (this.getY() == other.getY())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "num neighbors: " + this.numNeighbors();
		toReturn += "\tcost: " + cost;
		toReturn += "\tmarked: " + visited;
		return toReturn;
	}

	@Override
	public int compareTo(Vertex o) {
		double oCost = o.getCost();
		return (int) (cost - oCost);
	}

}
