import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int[] list, ans;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                break;
            }

            list = new int[K];
            visited = new boolean[K];

            for (int i=0; i<K; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            System.out.println();
        }
    }
    public static void comb(int start, int depth) {
        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<list.length; i++) {
                if (visited[i]) sb.append(list[i]+" ");

            }
            System.out.println(sb);
            return;
        }

        for (int i=start; i<K; i++) {
            if (!visited[i]) { // 방문 안했을경우
                visited[i] = true; // 방문처리
                comb(i, depth+1); // 백트래킹

                visited[i] = false; // 갔다왔으면 방문처리 취소
            }
        }
        return;
    }
}