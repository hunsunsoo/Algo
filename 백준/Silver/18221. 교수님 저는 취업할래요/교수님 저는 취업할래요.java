import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 5) {
                    a = i;
                    b = j;
                } else if (map[i][j] == 2) {
                    c = i;
                    d = j;
                }
            }
        }

        int num = 0;
        for (int i=Math.min(a,c); i<=Math.max(a,c); i++) {
            for (int j=Math.min(b,d); j<=Math.max(b,d); j++) {
                if (map[i][j] == 1) num++;
            }
        }

        double aa = Math.sqrt(Math.pow(a-c, 2)+Math.pow(b-d,2));
        if (num >= 3 && aa >= 5) System.out.println(1);
        else System.out.println(0);
    }
}
