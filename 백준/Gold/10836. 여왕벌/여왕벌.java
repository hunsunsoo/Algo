import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][M];
        int[][] temp = new int[M][M];
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

        // 애벌레 성장
        for (int d=0; d<N; d++) { // 날짜 증가
            int plus = 0;
            // 왼쪽 아래 -> 위
            for (int i=M-1; i>=0; i--) {
                while (true) {
                    if (list[d][plus] > 0) {
                        map[i][0] += plus;
                        list[d][plus]--;
                        break;
                    } else {
                        plus++;
                    }
                }
            }

            // 맨윗줄
            for (int j=1; j<M; j++) {
                while (true) {
                    if (list[d][plus] > 0) {
                        map[0][j] += plus;
                        list[d][plus]--;
                        break;
                    } else {
                        plus++;
                    }
                }
            }

            // 가운데
//            for (int i=1; i<M; i++) {
//                for (int j=1; j<M; j++) {
//                    int max = Math.max(Math.max(temp[i][j-1], temp[i-1][j-1]), temp[i-1][j]);
//                    temp[i][j] = max;
//                }
//            }

            // map + temp
//            for (int i=0; i<M; i++) {
//                for (int j=0; j<M; j++) {
//                    map[i][j] += temp[i][j];
//                }
//            }
        }
        for (int i=1; i<M; i++) {
            for (int j=1; j<M; j++) {
                map[i][j] = map[i-1][j];
            }
        }

        // 출력
        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}