import java.io.*;
import java.util.*;
public class Main {
	static int[] arr; // 숫자배열
	static int[] ans; // 정답 배열
	
	static boolean[] visited; // 숫자의 TF 배열
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	arr = new int[N]; // 숫자배열은 N칸
    	for (int i=0; i<N; i++) {
    		arr[i] = i+1;
    	}
    	visited = new boolean[N]; // 방문배열은 N칸
    	
    	ans = new int[M]; // 정답배열은 M칸
    	comb(N,M,0);
	}
    public static void comb(int N, int M, int depth) {
    	// 기저조건
    	if (depth == M) {
    		for (int c : ans) {
    			System.out.print(c+" ");
    		}
    		System.out.println();
    		return;
    	}
    	
    	// 재귀조건
    	for (int i=0; i<arr.length; i++) {
    		if (!visited[i]) {
    			// 방문 한다
    			visited[i] = true;
    			ans[depth] = arr[i];
    			comb(N,M,depth+1);
    			
    			// 방문 끝났으면 다시 돌려놓기
    			visited[i] = false;
    		}
    	}
    	return;
    }
}
// N과 M(1)