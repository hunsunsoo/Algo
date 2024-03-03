import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+2][M+2];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        // 앞 뒤
        for (int j=1; j<=M; j++) {
            int temp = map[0][j]; // 0
            for (int i=1; i<=N+1; i++) {
                cnt += Math.abs(map[i][j] - temp);
                temp = map[i][j];
            }
        }

        // 양 옆
        for (int i=1; i<=N; i++) {
            int temp = map[i][0];
            for (int j=1; j<=M+1; j++) {
                cnt += Math.abs(map[i][j] - temp);
                temp = map[i][j];
            }
        }

        // 위 아래
        cnt += N*M*2;

        System.out.println(cnt);
    }
}