import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = list[0];

        int max = list[0];
        for (int i=1; i<N; i++) {
            dp[i] = Math.max(0, dp[i-1]) + list[i];
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}