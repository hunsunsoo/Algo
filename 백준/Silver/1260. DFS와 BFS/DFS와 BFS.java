import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static boolean[] visited2;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	map = new int[N+1][N+1];
    	visited = new boolean[N+1];
    	visited2 = new boolean[N+1];
    	
    	int M = sc.nextInt();
    	int v = sc.nextInt();
    	for (int i=0; i<M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		map[a][b] = 1;
    		map[b][a] = 1;
    	}
    	DFS(v);
    	System.out.println();
    	BFS(v);
    }
    
    public static void DFS(int v) {
    	visited[v] = true;
    	System.out.print(v+" ");
    	
    	for (int i=1; i<=N; i++) {
    		if (!visited[i] && map[v][i] == 1) {
    			DFS(i);
    		}
    		
    	}
    }
    
    public static void BFS(int v) {
    	visited2[v] = true;
    	queue.add(v);
    	
    	while (!queue.isEmpty()) {
    		int curr = queue.poll();
    		System.out.print(curr+" ");
    		for (int i=1; i<=N; i++) {
    			if (!visited2[i] && map[curr][i] == 1) {
    				queue.add(i);
    				visited2[i] = true;
    			}
    		}
    	}
    }
}
