import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        QuadTree(0, 0, N);
        System.out.println(sb);

    }
    public static void QuadTree(int x, int y, int size) {
        if (isCheck(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }

        int newSize = size/2;

        sb.append('(');

        QuadTree(x, y, newSize);
        QuadTree(x, y+newSize, newSize);
        QuadTree(x+newSize, y, newSize);
        QuadTree(x+newSize, y+newSize, newSize);

        sb.append(')');
    }

    public static boolean isCheck(int x, int y, int size) {
        int value = map[x][y];

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (value != map[i][j]) return false;
            }
        }

        return true;
    }
}