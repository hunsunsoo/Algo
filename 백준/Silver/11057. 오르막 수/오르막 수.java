import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10]; // 뒤의 차수가 1의 자리 수
        for (int i=0; i<10; i++) {
            dp[1][i] = 1;  // 초기값 전부 1
        }

        for (int n=2; n<=N; n++) {
            for (int i=0; i<10; i++) {
                for (int j=i; j<10; j++) {
                    dp[n][i] += dp[n-1][j];
                }
                dp[n][i] %= 10007;
            }
        }

        long sum = 0;
        for (int i=0; i<10; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum%10007);
    }
}
