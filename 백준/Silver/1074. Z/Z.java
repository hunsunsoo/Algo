import java.io.*;
import java.util.*;

public class Main {
    public static int N, R, C;
    public static int idx = 0;
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        ZZ(0,0,size);

    }
    public static void ZZ (int r, int c, int size) {
        if (size == 1) {
            System.out.println(idx);
            return;
        }

        int num = size/2;
        if (R < r+num && C < c+num) {
            ZZ(r, c, num);
        } else if (R < r+num && C >= c+num) {
            idx += num*num;
            ZZ(r, c+num, num);
        } else if (R >= r+num && C < c+num) {
            idx += num*num*2;
            ZZ(r+num, c, num);
        } else if (R >= r+num && C >= c+num) {
            idx += num*num*3;
            ZZ(r+num, c+num, num);
        }

    }
}