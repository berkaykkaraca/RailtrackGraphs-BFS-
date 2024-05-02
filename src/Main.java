import java.util.Scanner;
public class Main {
	//-----------------------------------------------------
	// Title: Main class
	// Author: Berkay Kaan Karaca
	
	// Section: 1
	// Assignment: 1
	// Description: Main class for creating a graph and new tracks
	//-----------------------------------------------------

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		System.out.println();
		Graph g = new Graph(N);
		BreadthFirstPaths bfs = new BreadthFirstPaths(g);
		for(int i = 0;i<M;i++) {
			int a = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			g.addEdge(a, c);
		}
	
		g.findNewTracks(g, X-1, Y-1);

	
	
	}

}
