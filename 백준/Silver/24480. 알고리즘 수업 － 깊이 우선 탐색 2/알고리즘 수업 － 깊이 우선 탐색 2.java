import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] map;
    public static int[] list;
    public static boolean[] visited;
    public static int cnt = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        for (int i=1; i<=N; i++) map[i] = new ArrayList<>();
        visited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for (int i=1; i<=N; i++) Collections.sort(map[i], Collections.reverseOrder());
        
        list = new int[N+1];
        DFS(R);

        for (int i=1; i<=N; i++) {
            System.out.println(list[i]);
        }

    }
    public static void DFS(int start) {
        list[start] = cnt;
        visited[start] = true;

        if (!map[start].isEmpty()) {
            for (int i=0; i<map[start].size(); i++) {
                if (!visited[map[start].get(i)]) {
                    cnt++;
                    DFS(map[start].get(i));
                }
            }
        }
    }
}