import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = 1;

        for (int i=2; i<=N; i++) {
            int temp = 0;
            for (int j=i-1; j>0; j--) {
                if (list[i] > list[j]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp+1;
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            if (dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }
}