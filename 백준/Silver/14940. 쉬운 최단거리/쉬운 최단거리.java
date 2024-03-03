import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map, arr;
    public static boolean[][] visited;
    public static int[] vx = {1, -1, 0, 0};
    public static int[] vy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        arr = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];

        int x = 0;
        int y = 0;

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x = i; y = j;
                }
            }
        }

        BFS(x, y);

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (map[i][j] == 1 && arr[i][j] == 0) arr[i][j] = -1;
            }
        }


        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        arr[x][y] = 0;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int curr_x = q.peek()[0];
            int curr_y = q.poll()[1];

            for (int i=0; i<4; i++) {
                if (map[curr_x+vx[i]][curr_y+vy[i]] != 0 && !visited[curr_x+vx[i]][curr_y+vy[i]]) {
                    q.add(new int[]{curr_x+vx[i], curr_y+vy[i]});
                    arr[curr_x+vx[i]][curr_y+vy[i]] = arr[curr_x][curr_y]+1;
                    visited[curr_x+vx[i]][curr_y+vy[i]] = true;
                }
            }

        }

    }
}