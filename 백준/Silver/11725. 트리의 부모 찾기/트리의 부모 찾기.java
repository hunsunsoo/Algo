import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] node = new int[N+1];
        node[1] = -1;
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for (int i=1; i<=N; i++) list[i] = new ArrayList<>();

        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int num = q.poll();

            for (int i=0; i<list[num].size(); i++) {
                if (node[list[num].get(i)] == 0) {
                    node[list[num].get(i)] = num;
                    q.add(list[num].get(i));
                }
            }
        }

        for (int i=2; i<=N; i++) {
            System.out.println(node[i]);
        }
    }
}