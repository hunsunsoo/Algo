import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][M];
        int N = Integer.parseInt(st.nextToken());
        int[][] list = new int[N][3];

        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = 1;
            }
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] temp = new int[2*M-1];
        for (int d=0; d<N; d++) { // 날짜 증가
            // 1 증가
            for (int i=list[d][0]; i<list[d][1]+list[d][0]; i++) {
                temp[i] += 1;
            }

            // 2 증가
            for (int i=list[d][1]+list[d][0]; i<list[d][2]+list[d][1]+list[d][0]; i++) {
                temp[i] += 2;
            }
        }

        int idx = 0;
        // 왼쪽 아래 -> 위
        for (int i=M-1; i>=0; i--) {
            map[i][0] = temp[idx]+1;
            idx++;
        }

        for (int j=1; j<M; j++) {
            map[0][j] = temp[idx]+1;
            idx++;
        }

        // 가운데
        for (int i=1; i<M; i++) {
            for (int j=1; j<M; j++) {
                map[i][j] = map[i-1][j];
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}