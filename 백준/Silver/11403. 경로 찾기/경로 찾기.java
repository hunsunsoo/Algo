import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N+1];
            q.add(i);
            while (!q.isEmpty()) {
                int num = q.poll();
                for (int j=1; j<=N; j++) {
                    if (map[num][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        result[i][j] = 1;
                        q.add(j);
                    }
                }
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}