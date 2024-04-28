import java.io.*;
import java.util.*;

public class Main {
    public static int N, max;
    public static int[] list, arr;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        hun(0);
        System.out.println(max);
    }
    public static void hun(int n) {
        if (n == N) {
            int sum = 0;
            for (int i=0; i<N-1; i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            if (sum > max) max = sum;
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                arr[n] = list[i];
                visited[i] = true;
                hun(n+1);
                visited[i] = false;
            }
        }
    }
}
