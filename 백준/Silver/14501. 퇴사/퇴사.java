import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N+1][2];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];
        for (int i=1; i<=N; i++) {
            // 초기값 설정
            for (int j=1; j<i; j++) {
                if (dp[j] > dp[i]) {
                    dp[i] = dp[j];
                }
            }

            int nextday = i+list[i][0];
            if (nextday <= N+1) {
                dp[nextday] = Math.max(dp[nextday], dp[i]+list[i][1]);
            }

        }

        int max = 0;
        for (int i=1; i<=N+1; i++) {
            if (dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }
}