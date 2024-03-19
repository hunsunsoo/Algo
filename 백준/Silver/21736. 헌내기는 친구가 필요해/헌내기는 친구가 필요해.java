import java.io.*;
import java.util.*;

public class Main {
    public static int[] vx = {1, -1, 0, 0};
    public static int[] vy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N+2][M+2];

        int x = 0;
        int y = 0;
        for (int i=1; i<=N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j+1] = s.charAt(j);
                if (map[i][j+1] == 'I') {
                    x = i;
                    y = j+1;
                }
            }
        }

        boolean[][] visited = new boolean[N+2][M+2];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int xx = q.peek()[0];
            int yy = q.poll()[1];

            // 4방향
            for (int i=0; i<4; i++) {
                int a = xx+vx[i];
                int b = yy+vy[i];
                if (!visited[a][b]) {
                    if (map[a][b] == 'O') {
                        q.add(new int[] {a,b});
                        visited[a][b] = true;
                    } else if (map[a][b] == 'P') {
                        q.add(new int[] {a,b});
                        visited[a][b] = true;
                        cnt++;
                    }
                }
            }
        }

        if (cnt != 0) System.out.println(cnt);
        else System.out.println("TT");
    }
}