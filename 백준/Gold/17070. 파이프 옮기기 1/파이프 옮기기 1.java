import java.io.*;
import java.util.*;

public class Main {
    public static int N, cnt;
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0;
        int y = 1;
        int dir = 1;

        cnt = 0;
        Pipe(x, y, dir);
        System.out.println(cnt);
    }
    public static void Pipe(int x, int y, int dir) {
        if (x == N-1 && y == N-1) {
            cnt++;
            return;
        }
        else if (x == N-1 && dir == 3) {
            return;
        } else if (y == N-1 && dir == 1) {
            return;
        }

        if (dir == 1) {
            if (y<N-1 && map[x][y+1] != 1) Pipe(x, y+1, 1);
            if (x<N-1 && y<N-1 && map[x+1][y] != 1 && map[x+1][y+1] != 1 && map[x][y+1] != 1) Pipe(x+1, y+1, 2);
        } else if (dir == 2) {
            if (y<N-1 && map[x][y+1] != 1) Pipe(x, y+1, 1);
            if (x<N-1 && y<N-1 && map[x+1][y] != 1 && map[x+1][y+1] != 1 && map[x][y+1] != 1) Pipe(x+1, y+1, 2);
            if (x<N-1 && map[x+1][y] != 1) Pipe(x+1,y,3);
        } else if (dir == 3) {
            if (x<N-1 && y<N-1 && map[x+1][y] != 1 && map[x+1][y+1] != 1 && map[x][y+1] != 1) Pipe(x+1, y+1, 2);
            if (x<N-1 && map[x+1][y] != 1) Pipe(x+1,y,3);
        }
    }
}