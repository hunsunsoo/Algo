import java.io.*;
import java.util.*;

public class Main {
    public static int[] vx = {1, -1, 0, 0};
    public static int[] vy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) q.add(new int[] {i,j});
            }
        }

        int cnt_day = 0;
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];

            for (int i=0; i<4; i++) {
                int a = x+vx[i];
                int b = y+vy[i];

                if (a<0 || b<0 || a>=N || b>=M) {
                    continue;
                }

                if (map[a][b] == 0) {
                    q.add(new int[] {a,b});
                    map[a][b] = map[x][y]+1;
                }
            }
        }

        int max = 0;
        outer : for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    max = -1;
                    break outer;
                }

                if (map[i][j] > max) max = map[i][j];
            }
        }

        if (max == -1) System.out.println(-1);
        else  System.out.println(max-1);
    }
}