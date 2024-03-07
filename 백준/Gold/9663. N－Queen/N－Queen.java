import java.io.*;
import java.util.*;

public class Main {
    public static int N, cnt=0;
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        Queen(0);
        System.out.println(cnt);
    }
    public static void Queen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int j=0; j<N; j++) { // 열
            boolean chk = true;
            for (int i=0; i<depth; i++) { // 행
                // 왼 대각
                if (j-depth+i >= 0 && map[i][j-depth+i] == 1) {
                    chk = false;
                }
                // 바로 위
                if (map[i][j] == 1) {
                    chk = false;
                }
                // 오른 대각
                if (j+depth-i<N && map[i][j+depth-i] == 1) {
                    chk = false;
                }
            }
            // 놔도 되면
            if (chk) {
                map[depth][j] = 1;
                Queen(depth+1);
                map[depth][j] = 0;
            }
        }
    }
}