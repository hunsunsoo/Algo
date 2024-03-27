import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] friend;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friend = new ArrayList[N+1];
        for (int i=1; i<=N; i++) friend[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a].add(b);
            friend[b].add(a);
        }

        int[] list = new int[N+1];

        for (int i=1; i<=N; i++) {
            int[] temp = new int[N+1];
            kevin(i, temp);
            int cnt = 0;
            for (int a=1; a<=N; a++) {
                cnt += temp[a]-1;
            }
            list[i] = cnt;
        }

        int min = Integer.MAX_VALUE;
        int min_idx = 0;
        for (int i=1; i<=N; i++) {
            if (list[i]<min) {
                min = list[i];
                min_idx = i;
            }
        }
        System.out.println(min_idx);
    }
    public static void kevin(int a, int[] temp) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        temp[a] = 1;
        while (!q.isEmpty()) {
            int num = q.poll();

            for (int i=0; i<friend[num].size(); i++) {
                if (temp[friend[num].get(i)] == 0) {
                    q.add(friend[num].get(i));
                    temp[friend[num].get(i)] = temp[num]+1;
                }
            }
        }
    }
}