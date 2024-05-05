import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] list;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];
        visited = new boolean[N];

        hh(0);
    }
    public static void hh(int n) {
        if (n == N) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<N; i++) {
                sb.append(list[i]+" ");
            }
            System.out.println(sb);
        }

        for (int i=0; i<N; i++) {
            if (visited[i]) continue;

            list[n] = i+1;
            visited[i] = true;
            hh(n+1);
            visited[i] = false;
        }
    }
}
