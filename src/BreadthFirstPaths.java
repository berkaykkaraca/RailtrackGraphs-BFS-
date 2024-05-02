public class BreadthFirstPaths {
	//-----------------------------------------------------
	// Title: BFS class
	// Author: Berkay Kaan Karaca
	
	// Section: 1
	// Assignment: 1
	// Description: This class creates a BFS object for using bfs algorithm
	//-----------------------------------------------------
	
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
public BreadthFirstPaths(Graph G) {
	marked = new boolean[G.V()];
	distTo = new int[G.V()];
    edgeTo = new int[G.V()];
}

	public int bfs(Graph graph, int s,int t) {
		//--------------------------------------------------------
		 // Summary: it uses bfs algorithm to check distance betweeen 2 vertexes
		 //--------------------------------------------------------
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		marked[s] = true;
		distTo[s] = 0;
		while (!q.isEmpty()) {
			
			int v = q.dequeue();
			for (int w : graph.adj(v)) {
				if (!marked[w]) {
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					if(w==t) {
						return distTo[t];
					}
					
				}
			}

		}
		return -1;
	}
	public int distTo(int v) {
        return distTo[v];
    }
	}








