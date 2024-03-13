import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<=i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];

        dp[0][0] = map[0][0];

        for (int i=1; i<N; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) {
                    dp[i][j] = dp[i-1][j]+map[i][j];
                } else if (j==i) {
                    dp[i][j] = dp[i-1][i-1]+map[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+map[i][j];
                }
            }
        }

        int max = 0;
        for (int i=0; i<N; i++) {
            if (dp[N-1][i] > max) max = dp[N-1][i];
        }
        System.out.println(max);
    }
}