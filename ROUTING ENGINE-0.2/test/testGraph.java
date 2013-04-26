import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;


import org.xml.sax.SAXException;

import routing.model.Edge;
import routing.model.Graph;
import routing.model.Vertex;
import tools.builder.GraphBuilder;
import tools.parser.model.OSMNode;


public class testGraph {
	public static void main(String [] args) throws ParserConfigurationException, SAXException, IOException{
		GraphBuilder builder = new GraphBuilder("data/surabaya.osm");
		Graph graph = builder.getGraph();
		
		//TODO test graph size
//		System.out.println(graph.getSize()); // 22176
		
		//TODO test match vertex to osmNode		
//		String key = graph.toVertex("1357523729").toString();
//		for(OSMNode node : builder.getNodesInGraph()){
//			if (node.id.equals(key)){
//				System.out.println(node.getPoint());
//			}
//		}
		
		//TODO test vertex in graph
		for(Vertex vertex : graph.getVertexs()){
			System.out.print(vertex +" adj : ");
			for (Edge edge : vertex.adjacencies){
				
				System.out.print(edge.getToVertex() + " ");
			}
			System.out.println();
		}
		
	}
}
