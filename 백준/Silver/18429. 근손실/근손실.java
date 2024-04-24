import java.io.*;
import java.util.*;

public class Main {
    public static int N, K, cnt=0;
    public static int[] list;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];

        exercise(0, 500);
        System.out.println(cnt);
    }
    public static void exercise (int day, int w) {
        if (day == N) {
            cnt++;
            return;
        }

        for (int i=0; i<N; i++) {
            if (visited[i]) continue;

            if (w+list[i]-K >= 500) {
                visited[i] = true;
                exercise(day+1, w+list[i]-K);
                visited[i] = false;
            }
        }
    }
}
