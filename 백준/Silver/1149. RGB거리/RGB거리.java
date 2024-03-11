import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        for (int i=1; i<N; i++) {
            // 빨
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
            // 초
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
            // 파
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]));

    }
}