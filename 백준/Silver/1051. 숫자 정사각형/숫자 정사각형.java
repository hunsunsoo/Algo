import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = s.charAt(j)-48;
            }
        }

        int size = Math.min(N, M);

        outer : while (size > 1) {
            for (int i=0; i<=N-size; i++) {
                for (int j=0; j<=M-size; j++) {
                    if (map[i][j] == map[i][j+size-1] && map[i][j] == map[i+size-1][j] && map[i][j] == map[i+size-1][j+size-1]) {
                        break outer;
                    }
                }
            }
            size--;
        }
        System.out.println(size*size);
    }
}
