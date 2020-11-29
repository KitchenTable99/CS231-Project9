import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

	Graph graph, empty;
	
	@SuppressWarnings("serial")
	@BeforeEach
	void init() {
		ArrayList<Vertex> innards = new ArrayList<Vertex>() {{
			add(new Vertex(1, 1, 1e+7));
			add(new Vertex(3, 1, 1e+7));
			add(new Vertex(7, 4, 1e+7));
			add(new Vertex(1, 7, 1e+7));
			add(new Vertex(3, 7, 1e+7));
		}};
		graph = new Graph(innards);
		empty = new Graph();
	}
	
	@SuppressWarnings("serial")
	@Test
	void constructorTest() {
		// empty
		assertEquals(new ArrayList<Vertex>(), empty.getContents());
		// pre-made
		ArrayList<Vertex> innards = new ArrayList<Vertex>() {{
			add(new Vertex(1, 1, 1e+7));
			add(new Vertex(3, 1, 1e+7));
			add(new Vertex(7, 4, 1e+7));
			add(new Vertex(1, 7, 1e+7));
			add(new Vertex(3, 7, 1e+7));
		}};
		assertEquals(innards, graph.getContents());
	}
	
	@Test
	void vertexCount() {
		assertEquals(0, empty.vertexCount());
		assertEquals(5, graph.vertexCount());
	}
	
	@Test
	void inGraph() {
		assertFalse(empty.inGraph(new Vertex(1, 3, 1)));
		assertTrue(graph.inGraph(new Vertex(1, 7, 1)));
	}
	
	@Test
	void addUniEdge() {
		// check for adding to contents
		empty.addUniEdge(new Vertex(1, 1, 10), new Vertex(3, 1, 10));
		assertEquals(2, empty.vertexCount());
		assertNotEquals(null, empty.getVertexAt(1, 1).getNeighbor(3, 1));
		assertEquals(null, empty.getVertexAt(3, 1).getNeighbor(1, 1));
		// check for no need to add
		graph.addUniEdge(graph.getVertexAt(1, 1), graph.getVertexAt(3, 1));
		assertNotEquals(null, graph.getVertexAt(1, 1).getNeighbor(3, 1));
		assertEquals(null, graph.getVertexAt(3, 1).getNeighbor(1, 1));	
	}
	
	@Test
	void addBiEdge() {
		// check for adding to contents
		empty.addBiEdge(new Vertex(1, 1, 10), new Vertex(3, 1, 10));
		assertEquals(2, empty.vertexCount());
		assertNotEquals(null, empty.getVertexAt(1, 1).getNeighbor(3, 1));
		assertNotEquals(null, empty.getVertexAt(3, 1).getNeighbor(1, 1));
		// check for no need to add
		graph.addBiEdge(graph.getVertexAt(1, 1), graph.getVertexAt(3, 1));
		assertNotEquals(null, graph.getVertexAt(1, 1).getNeighbor(3, 1));
		assertEquals(null, graph.getVertexAt(3, 1).getNeighbor(1, 1));
	}

}
