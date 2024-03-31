import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[M][N][H];

        Queue<int[]> q = new LinkedList<>();
        for (int h=0; h<H; h++) {
            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j][h] = Integer.parseInt(st.nextToken());
                    if (map[i][j][h] == 1) q.add(new int[] {i,j,h});
                }
            }
        }

        int[] vx = {1, -1, 0, 0, 0, 0};
        int[] vy = {0, 0, 1, -1, 0, 0};
        int[] vz = {0, 0, 0, 0, 1, -1};

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int z = q.poll()[2];

            for (int v=0; v<6; v++) {
                // map 범위
                if (x+vx[v] >= 0 && x+vx[v] < M && y+vy[v] >= 0 && y+vy[v] < N && z+vz[v] >= 0 && z+vz[v] < H) {
                    // 익힐 토마토가 있으면
                    if (map[x+vx[v]][y+vy[v]][z+vz[v]] == 0) {
                        map[x+vx[v]][y+vy[v]][z+vz[v]] = map[x][y][z]+1;
//                        if (map[x][y][z]+1 > max) max = map[x][y][z]+1;
                        q.add(new int[] {x+vx[v], y+vy[v], z+vz[v]});
                    }
                }
            }
        }
        int max = 0;
        boolean chk = false;
        outer: for (int h=0; h<H; h++) {
            for (int i=0; i<M; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][j][h] > max) max = map[i][j][h];
                    if (map[i][j][h] == 0) {
                        chk = true;
                        break outer;
                    }
                }
            }
        }
        if (chk) System.out.println(-1);
        else System.out.println(max-1);
    }
}
