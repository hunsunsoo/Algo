import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] vr = {1, -1, 0, 0};
        int[] vc = {0, 0, 1, -1};

        int cnt = 0;
        int max = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    cnt++;

                    int size = 0;
                    while (!queue.isEmpty()) {
                        int r = queue.peek()[0];
                        int c = queue.poll()[1];
                        size++;

                        for (int v=0; v<4; v++) {
                            if (r+vr[v] >= 0 && r+vr[v] < N && c+vc[v] >= 0 && c+vc[v] < M && map[r+vr[v]][c+vc[v]] == 1 && !visited[r+vr[v]][c+vc[v]]) {
                                queue.add(new int[]{r+vr[v], c+vc[v]});
                                visited[r+vr[v]][c+vc[v]] = true;
                            }
                        }
                    }

                    if (size > max) max = size;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
}