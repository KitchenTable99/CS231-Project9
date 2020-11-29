import java.util.ArrayList;

/**
 *  Graph class. Created for project09
 *
 * @author cbitting
 */

public class Graph {
	
	ArrayList<Vertex> contents;
	
	public Graph() {
		contents = new ArrayList<Vertex>();
	}
	
	public Graph(ArrayList<Vertex> internals) {
		contents = internals;
	}
	
	/**
	 * @param x position
	 * @param y position
	 * @return Vertex object stored at that position or null if no Vertex present
	 */
	public Vertex getVertexAt(int x, int y) {
		return null;
	}
	
	/**
	 * @return the contents of the Graph
	 */
	public ArrayList<Vertex> getContents() {
		return contents;
	}
	
	/**
	 * @return the number of vertices in the graph
	 */
	public int vertexCount() {
		return 0;
	}
	
	/**
	 * @param query the vertex to search for
	 * @return whether or not the vertex is present
	 */
	public boolean inGraph(Vertex query) {
		return false;
	}
	
	/**
	 * adds v1 and v2 to the graph (if necessary) and adds an edge connecting v1 to v2, creating a uni-directional link
	 * @param v1 Vertex 1
	 * @param v2 Vertex 2
	 */
	public void addUniEdge(Vertex v1, Vertex v2) {
		return;
	}
	
	/**
	 * adds v1 and v2 to the graph (if necessary), adds an edge connecting v1 to v2, and adds a second edge connecting v2 to v1,
	 * creating a bi-directional link
	 * @param v1 Vertex 1
	 * @param v2 Vertex 2
	 */
	public void addBiEdge(Vertex v1, Vertex v2) {
		return;
	}
	
	/**
	 * implements a single-source shortest-path algorithm for the Graph using Dijkstra's algorithm
	 * @param v0 starting Vertex
	 */
	public void shortestPath(Vertex v0) {
		return;
	}

}
