public class Graph {
	//-----------------------------------------------------
	// Title: Graph class
	// Author: Berkay Kaan Karaca
	
	// Section: 1
	// Assignment: 1
	// Description: Creates a graph object to implement its functions.
	//-----------------------------------------------------
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	private static final String NEWLINE = System.getProperty("line.separator");

	public Graph(int V) {
		this.V = V;
		E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}

	public void addEdge(int v, int w) {
		//--------------------------------------------------------
		 // Summary: this function helps to adding an edge
		 //--------------------------------------------------------
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public int V() {
		return V;
	}

	public boolean hasEdge(int vertex1, int vertex2) {
		for (int w : adj[vertex1]) {

			if (w == vertex2) {
				return true;
			}
		}
		return false;
	}
public Graph copy() {
	//--------------------------------------------------------
	 // Summary: this function creates a copy of a graph
	 //--------------------------------------------------------
	Graph copiedGraph = new Graph(V);

    for (int i = 0; i < V; i++) {
        if (adj[i] != null) {
            for (int j : adj[i]) {
                copiedGraph.addEdge(i, j);
            }
        }
    }

    return copiedGraph;
	
}
	public void findNewTracks(Graph g, int X, int Y) {
		//--------------------------------------------------------
		 // Summary: this method finds the all the possible new edges while between 2 vertexes' distance stay same.
		 //--------------------------------------------------------
		BreadthFirstPaths b = new BreadthFirstPaths(g);
		Graph temp;
		int[] vertex1 = new int[g.V*g.V];
		int[] vertex2= new int[g.V*g.V];
		int count =0;
			
		int distance = b.bfs(g, X, Y);
		for (int i = 0; i < g.V(); i++) {
			for (int j = 0; j < g.V(); j++) {
				BreadthFirstPaths bf = new BreadthFirstPaths(g);
				temp = g.copy();
				if (!g.hasEdge(i, j) && i != j) {
					temp.addEdge(i, j);
					if (bf.bfs(temp, X, Y) == distance) {
						g.addEdge(i, j);
						vertex1[count]=i+1;
						vertex2[count]=j+1;
						count++;
					}
				}
			}
		}
		System.out.println(count);
		for(int i = 0;i<count;i++) {
			System.out.println(vertex1[i]+" "+vertex2[i]);
			
		}

	}

}