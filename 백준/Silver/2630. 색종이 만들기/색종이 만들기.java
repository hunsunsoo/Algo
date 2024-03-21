import java.io.*;
import java.util.*;

public class Main {
    public static int N, blue, white;
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0;
        blue = 0;
        paper(N,0 ,0);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void paper(int size, int x, int y) {
        // 종이가 한 종류인지 검증
        int cnt_b = 0;
        int cnt_w = 0;
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (map[i][j] == 1) cnt_b++;
                else cnt_w++;
            }
        }

        if (cnt_w == 0) {
            blue++;
            return;
        } else if (cnt_b == 0){
            white++;
            return;
        } else {
            paper(size/2, x, y);
            paper(size/2, x, y+size/2);
            paper(size/2, x+size/2, y);
            paper(size/2, x+size/2, y+size/2);
        }

    }
}