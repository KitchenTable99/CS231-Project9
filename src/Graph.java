import java.util.ArrayList;
import java.util.PriorityQueue;

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
		Vertex toReturn = null;
		for (Vertex v : contents) {
			if (v.getX() == x && v.getY() == y) {
				toReturn = v;
				break;
			}
		}		
		return toReturn;
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
		return contents.size();
	}
	
	/**
	 * @param query the vertex to search for
	 * @return whether or not the vertex is present
	 */
	public boolean inGraph(Vertex query) {
		Vertex foo = this.getVertexAt(query.getX(), query.getY());
		if (foo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * adds v1 and v2 to the graph (if necessary) and adds an edge connecting v1 to v2, creating a uni-directional link
	 * @param v1 Vertex 1
	 * @param v2 Vertex 2
	 */
	public void addUniEdge(Vertex v1, Vertex v2) {
		// add vertices if needed
		if (!inGraph(v1)) {
			contents.add(v1);
		}
		if (!inGraph(v2)) {
			contents.add(v2);
		}
		// connect
		v1.connect(v2);
		return;		
	}
	
	/**
	 * adds v1 and v2 to the graph (if necessary), adds an edge connecting v1 to v2, and adds a second edge connecting v2 to v1,
	 * creating a bi-directional link
	 * @param v1 Vertex 1
	 * @param v2 Vertex 2
	 */
	public void addBiEdge(Vertex v1, Vertex v2) {
		// add vertices if needed
		if (!inGraph(v1)) {
			contents.add(v1);
		}
		if (!inGraph(v2)) {
			contents.add(v2);
		}
		// connect
		v1.connect(v2);
		v2.connect(v1);
		return;
	}
	
	/**
	 * implements a single-source shortest-path algorithm for the Graph using Dijkstra's algorithm
	 * @param v0 starting Vertex
	 */
	public void shortestPath(Vertex v0) {
		// initialize all vertices to have a large cost, and a null parent
		for (Vertex v : contents) {
			v.setCost(1e+7);
			v.setVisited(false);
		}
		// create priority queue
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		// add v0 with a cost of 0
		v0.setCost(0);
		pq.add(v0);
		// while the queue isn't empty
		while (!pq.isEmpty()) {
			// take lowest cost off
			Vertex focus = pq.poll();
			// if visited, continue
			if (focus.isVisited()) {
				continue;
			}
			// mark as visited
			focus.setVisited(true);
			// for each neighbor
			for (Vertex v : focus.getNeighbors()) {
				// find distance between focus node and neighbor
				double distance = focus.distance(v);
				// if neighbor not visited already and the calculated distance is "better"
				if (!(v.isVisited()) && distance < v.getCost()) {
					// update cost
					v.setCost(focus.getCost() + distance);
					// make focus parent of neighbor
					v.setParent(focus);
					// add neighbor to queue
					pq.add(v);
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		// make vertices
		Vertex a = new Vertex(2, 9);
		Vertex b = new Vertex(1, 3);
		Vertex c = new Vertex(3, 1);
		Vertex d = new Vertex(2, 10);
		Vertex e = new Vertex(6, 12);
		Vertex f = new Vertex(4, 9);
		Vertex g = new Vertex(11, 1);
		Vertex h = new Vertex(11, 5);
		Vertex i = new Vertex(8, 12);
		Vertex j = new Vertex(12, 10);
		Vertex k = new Vertex(7, 5);
		
		// place on graph
		Graph graph = new Graph();
		graph.addBiEdge(a, b);
		graph.addBiEdge(a, d);
		graph.addBiEdge(a, f);
		graph.addBiEdge(b, c);
		graph.addBiEdge(c, i);
		graph.addBiEdge(d, e);
		graph.addBiEdge(e, f);
		graph.addBiEdge(e, i);
		graph.addBiEdge(f, h);
		graph.addBiEdge(g, h);
		graph.addBiEdge(h, j);
		graph.addBiEdge(i, k);
		graph.addBiEdge(j, k);
		
		// run using a as starting point
		graph.shortestPath(a);
		// print out costs
		System.out.println("For starting point a:");
		for (Vertex v : graph.getContents()) {
			System.out.println(v);
		}
		System.out.println();
		// run using k as starting point
		graph.shortestPath(k);
		// print out costs
		System.out.println("For starting point k:");
		for (Vertex v : graph.getContents()) {
			System.out.println(v);
		}
	}

}
