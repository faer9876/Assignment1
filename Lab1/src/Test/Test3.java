package Test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

	public class FriendshipTest {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person(“Rachel”);
		Person ross = new Person(“Ross”);
		Person ben = new Person(“Ben”);
		Person kramer = new Person(“Kramer”);
		Person tom = new Person(“Tom”);
		Person jack = new Person(“Jack”);
@Test
		public void addVertextest() {
			assertEquals(true, graph.addVertex(rachel));
			assertEquals(true, graph.addVertex(ross));
			assertEquals(true, graph.addVertex(ben));
			assertEquals(false, graph.addVertex(rachel));
			assertEquals(false, graph.addVertex(ross));
			assertEquals(false, graph.addVertex(ben));
}

@Test
	public void addEdgetest() { 
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		assertEquals(true, graph.addEdge(rachel, ross));
		assertEquals(true, graph.addEdge(ross, rachel));
		assertEquals(true, graph.addEdge(ross, ben));
		assertEquals(true, graph.addEdge(ben, ross));
		assertEquals(false, graph.addEdge(jack, ross)); 
		assertEquals(false, graph.addEdge(ben, tom));
		assertEquals(false, graph.addEdge(jack, tom));
}

@Test
	public void getDistancetest() {
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		assertEquals(1, graph.getDistance(rachel, ross), 0.001);
		assertEquals(2, graph.getDistance(rachel, ben), 0.001);
		assertEquals(0, graph.getDistance(rachel, rachel), 0.001);
		assertEquals(-1, graph.getDistance(rachel, kramer), 0.001);
		assertEquals(-2, graph.getDistance(tom, rachel), 0.001);
		assertEquals(-2, graph.getDistance(rachel, jack), 0.001);
		assertEquals(-2, graph.getDistance(tom, jack), 0.001);
}
