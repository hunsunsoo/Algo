import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] map;
    public static boolean chk = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, map[0][0]);

        if (chk) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
    public static void DFS(int a, int b, int jump) {
        if (map[a][b] == -1) {
            chk = true;
            return;
        }
        
        if (jump == 0) {
            return;
        }

        // 아래
        if (a+jump < N) DFS(a+jump, b, map[a+jump][b]);

        // 오른쪽
        if (b+jump < N) DFS(a, b+jump, map[a][b+jump]);
    }
}