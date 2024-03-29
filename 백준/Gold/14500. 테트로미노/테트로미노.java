import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //  ㅡ   ㅁ   ㄴ   ㄴ  ㄱ   ㅜ
        int result = 0;
        // ㅡ
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M-3; j++) {
                int cnt = 0;
                cnt += map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                if (cnt > result) result = cnt;
            }
        }
        // ㅣ
        for (int i=1; i<=N-3; i++) {
            for (int j=1; j<=M; j++) {
                int cnt = 0;
                cnt += map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                if (cnt > result) result = cnt;
            }
        }
        // ㅁ
        for (int i=1; i<=N-1; i++) {
            for (int j=1; j<=M-1; j++) {
                int cnt = 0;
                cnt += map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
                if (cnt > result) result = cnt;
            }
        }
        // ㄴ,ㄱ && ㄴㄱ && ㅏ,ㅓ (3x2)
        for (int i=1; i<=N-2; i++) {
            for (int j=1; j<=M-1; j++) {
                // ㄴ
                int cnt = 0;
                cnt += map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                if (cnt > result) result = cnt;
                // 대칭
                cnt = 0;
                cnt += map[i][j+1] + map[i+1][j+1] + map[i+2][j] + map[i+2][j+1];
                if (cnt > result) result = cnt;
                // ㄱ
                cnt = 0;
                cnt += map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                if (cnt > result) result = cnt;
                // 대칭
                cnt = 0;
                cnt += map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
                if (cnt > result) result = cnt;
                // ㄴㄱ
                cnt = 0;
                cnt += map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                if (cnt > result) result = cnt;
                // 대칭
                cnt = 0;
                cnt += map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                if (cnt > result) result = cnt;
                // ㅏ
                cnt = 0;
                cnt += map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                if (cnt > result) result = cnt;
                // ㅓ
                cnt = 0;
                cnt += map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                if (cnt > result) result = cnt;
            }
        }
        // reㄴ, reㄱ && reㄴreㄱ && ㅜ, ㅗ
        for (int i=1; i<=N-1; i++) {
            for (int j=1; j<=M-2; j++) {
                // reㄴ
                int cnt = 0;
                cnt += map[i][j+2] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                if (cnt > result) result = cnt;
                // 대칭
                cnt = 0;
                cnt += map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                if (cnt > result) result = cnt;
                // reㄱ
                cnt = 0;
                cnt += map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
                if (cnt > result) result = cnt;
                // 대칭
                cnt = 0;
                cnt += map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
                if (cnt > result) result = cnt;
                // reㄴreㄱ
                cnt = 0;
                cnt += map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i+1][j+1];
                if (cnt > result) result = cnt;
                // 대칭
                cnt = 0;
                cnt += map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                if (cnt > result) result = cnt;
                // ㅜ
                cnt = 0;
                cnt += map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                if (cnt > result) result = cnt;
                // ㅗ
                cnt = 0;
                cnt += map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                if (cnt > result) result = cnt;
            }
        }

        System.out.println(result);
    }
}