import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;


import org.xml.sax.SAXException;

import routing.algoritma.dijkstra.Dijkstra;
import routing.model.Graph;
import routing.model.Vertex;
import tools.builder.GraphBuilder;
import tools.parser.model.OSMNode;

public class testDijkstra {


	public static void main(String[] args) throws ParserConfigurationException, SAXException,
			IOException {
		GraphBuilder builder = new GraphBuilder("data/surabaya.osm");
		Graph graph = builder.getGraph();
	
		Dijkstra dijkstra = new Dijkstra(graph);
		
		dijkstra.execute(graph.fromVertex("1357523729"));
		
		LinkedList<Vertex> path = dijkstra.getPath(graph.toVertex("1357523975"));
		System.out.print("[");
		for (Vertex vertex : path) {
			System.out.print(vertex + ", ");
		}
		System.out.print("]");
		System.out.println();
	}

}
