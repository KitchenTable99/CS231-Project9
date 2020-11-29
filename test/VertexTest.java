import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VertexTest {
	
	Vertex vertex, other;
	
	@BeforeEach
	void init() {
		vertex = new Vertex(3, 4, 10);
		other = new Vertex(3, 5, 16);
	}

	@Test
	void constructorTest() {
		assertEquals(vertex.getNeighbors(), new ArrayList<Vertex>());
		assertEquals(vertex.getX(), 3);
		assertEquals(vertex.getY(), 4);
		assertFalse(vertex.isVisible());
		assertFalse(vertex.isVisited());
		assertEquals(vertex.getCost(), 10);
		assertEquals(vertex.getParent(), null);
	}
	
	@Test
	void neighborTest() {
		vertex.connect(other);
		assertEquals(vertex.getNeighbor(3, 5), other);
	}
	
	@Test
	void numNeighborsTest() {
		assertEquals(vertex.numNeighbors(), 0);
		vertex.connect(other);
		assertEquals(vertex.numNeighbors(), 1);
	}
	
	@Test
	void distanceTest() {
		Vertex specialTriangle = new Vertex(6, 8, 100);
		assertEquals(5, vertex.distance(specialTriangle));
	}
	
	@Test
	void compareToTest() {
		// cost less
		assertTrue(vertex.compareTo(other) < 0);
		// equal cost
		Vertex identical = new Vertex(4, 4, 10);
		assertEquals(vertex.compareTo(identical), 0);
		// cost more
		Vertex cheap = new Vertex(1, 2, 1);
		assertTrue(vertex.compareTo(cheap)  > 0);
	}

}
