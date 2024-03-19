import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N+1][3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                map[i][2] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][3];
            dp[1][1] = map[1][1];
            dp[1][2] = map[1][2];

            if (N > 1) {
                dp[2][1] = dp[1][2] + map[2][1];
                dp[2][2] = dp[1][1] + map[2][2];
            }

            for (int i=3; i<=N; i++) {
                int temp = Math.max(dp[i-2][1], dp[i-2][2]);

                if (temp > dp[i-1][2]) {
                    dp[i][1] = temp + map[i][1];
                } else {
                    dp[i][1] = dp[i-1][2] + map[i][1];
                }

                if (temp > dp[i-1][1]) {
                    dp[i][2] = temp + map[i][2];
                } else {
                    dp[i][2] = dp[i-1][1] + map[i][2];
                }
            }

            int max = 0;
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=2; j++) {
                    if (dp[i][j] > max) max = dp[i][j];
                }
            }
            System.out.println(max);
        }
    }
}