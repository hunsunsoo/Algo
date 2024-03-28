import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N+2][N+2];

        for (int i=1; i<=N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j+1] = s.charAt(j);
            }
        }

        int cnt1 = 1; // 적록색약x
        int cnt2 = 1; // 적록색약
        int[][] cntmap = new int[N+2][N+2];
        cntmap[1][1] = 1;

        int[] vx = {0,0,1,-1};
        int[] vy = {1,-1,0,0};

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if ((i == 1 && j == 1) || cntmap[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i,j});
                    while (!q.isEmpty()) {
                        int a = q.peek()[0];
                        int b = q.poll()[1];

                        for (int v=0; v<4; v++) {
                            if (map[a+vx[v]][b+vy[v]] == map[a][b] && cntmap[a+vx[v]][b+vy[v]] == 0) {
                                q.add(new int[] {a+vx[v], b+vy[v]});
                                cntmap[a+vx[v]][b+vy[v]] = cnt1;
                            }
                        }
                    }
                    cnt1++;
                }
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        int[][] cntmap2 = new int[N+2][N+2];
        cntmap2[1][1] = 1;

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if ((i == 1 && j == 1) || cntmap2[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i,j});
                    while (!q.isEmpty()) {
                        int a = q.peek()[0];
                        int b = q.poll()[1];

                        for (int v=0; v<4; v++) {
                            if (map[a+vx[v]][b+vy[v]] == map[a][b] && cntmap2[a+vx[v]][b+vy[v]] == 0) {
                                q.add(new int[] {a+vx[v], b+vy[v]});
                                cntmap2[a+vx[v]][b+vy[v]] = cnt2;
                            }
                        }
                    }
                    cnt2++;
                }
            }
        }

        System.out.println((cnt1-1)+" "+(cnt2-1));
    }
}