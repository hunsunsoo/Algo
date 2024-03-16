import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = list[1];

        int max = dp[1];
        for (int i=2; i<=N; i++) {
            int idx = i;
            int temp = 0;
            while (idx > 0) {
                if (list[i] > list[idx]) {
                    temp = Math.max(temp, dp[idx]);
                }
                idx--;
            }
            dp[i] = temp+list[i];

            if (dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }
}