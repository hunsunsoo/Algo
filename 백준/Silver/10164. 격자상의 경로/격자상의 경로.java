import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        if (K != 0) {
            int n = K/M;
            int m = (K%M)-1;

            for (int i=0; i<=m; i++) map[0][i] = 1;
            for (int i=0; i<=n; i++) map[i][0] = 1;

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=m; j++) {
                    map[i][j] = map[i-1][j] + map[i][j-1];
                }
            }
            int cnt1 = map[n][m];

            for (int i=m; i<M; i++) map[n][i] = 1;
            for (int i=n; i<N; i++) map[i][m] = 1;

            for (int i=n+1; i<N; i++) {
                for (int j=m+1; j<M; j++) {
                    map[i][j] = map[i-1][j] + map[i][j-1];
                }
            }
            int cnt2 = map[N-1][M-1];

            System.out.println(cnt1*cnt2);
        } else {
            for (int i=0; i<M; i++) map[0][i] = 1;
            for (int i=0; i<N; i++) map[i][0] = 1;

            for (int i=1; i<N; i++) {
                for (int j=1; j<M; j++) {
                    map[i][j] = map[i-1][j] + map[i][j-1];
                }
            }
            System.out.println(map[N-1][M-1]);
        }
    }
}