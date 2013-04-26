package routing.algoritma.astar;


import routing.model.Vertex;

public interface AStarHeuristic {

	public double getNilaiHeuristic(Vertex source, Vertex goal);
}
