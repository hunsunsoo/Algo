import java.io.*;
import java.util.*;

public class Main {
    public static int N, S, cnt;
    public static int[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        DFS(0, 0);

        if (S == 0) cnt--;

        System.out.println(cnt);

    }
    public static void DFS(int depth, int sum) {
        if (depth == N) {
            if (sum == S) cnt++;
            return;
        }

        DFS(depth+1, sum+list[depth]); // 포함하기
        DFS(depth+1, sum); // 포함안하기
    }
}