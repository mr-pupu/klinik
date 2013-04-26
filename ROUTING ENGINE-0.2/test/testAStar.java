import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import routing.algoritma.astar.AStar;
import routing.algoritma.astar.AStarHeuristic;
import routing.model.Graph;
import routing.model.Vertex;
import tools.builder.GraphBuilder;
import tools.parser.model.OSMNode;


public class testAStar {
		
	public testAStar () throws ParserConfigurationException, SAXException, IOException {
		System.out.println("BAca Graph .......");
		
		GraphBuilder builder = new GraphBuilder("data/surabaya.osm");
		Graph graph = builder.getGraph();
		System.out.println("graph loader ....");
		
		System.out.println("instantiate AStar ");
		AStarHeuristic heuristic = new EuclidianHeuristic();
		AStar aStar = new AStar(graph, heuristic);
		
		System.out.println("get shortest path ...");
		Vertex start = graph.fromVertex("1357523729");
		
		Vertex goal = graph.toVertex("1357523975");
		aStar.execute(start, goal);
		
		LinkedList<Vertex> path = aStar.getPath();
		System.out.print("[");
		for (Vertex vertex : path) {
			System.out.print(vertex + ", ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	class EuclidianHeuristic implements AStarHeuristic {

		@Override
		public double getNilaiHeuristic(Vertex source, Vertex goal) {
		
			OSMNode start = source.getNode();
			OSMNode finish = source.getNode();
		
			double x = start.getPoint().getX() - finish.getPoint().getX();
			double y = start.getPoint().getY() - finish.getPoint().getY();
			
			return Math.sqrt(x*x + y*y);
			
		}
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new testAStar();
	}

}
