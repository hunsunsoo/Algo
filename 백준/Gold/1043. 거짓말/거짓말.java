import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>(); // 진실을 아는 사람 list
        if (K != 0) {
            for (int i=0; i<K; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        ArrayList<Integer>[] party = new ArrayList[M+1]; // 파티 arraylist
        for (int i=1; i<=M; i++) party[i] = new ArrayList<>();
        boolean[] chk = new boolean[M];

        for (int p=1; p<=M; p++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 파티 참석 인원

            // arraylist.add
            for (int i=0; i<num; i++) party[p].add(Integer.parseInt(st.nextToken()));
        }

        // 사람 기준 Arraylist
        ArrayList<Integer>[] person = new ArrayList[N+1];
        for (int i=1; i<=N; i++) person[i] = new ArrayList<>();
        for (int i=1; i<=M; i++) {
            for (int a=0; a<party[i].size(); a++) {
                int aa = party[i].get(a);
                for (int b=0; b<party[i].size(); b++) {
                    int bb = party[i].get(b);
                    if (aa != bb) {
                        person[aa].add(bb);
                    }
                }
            }
        }

        // 거짓말 하면 안되는 사람들 전부 list로 합쳐버림
        boolean[] visited = new boolean[N+1];
        int length = list.size();
        for (int i=0; i<length; i++) {
            visited[list.get(i)] = true;

            Queue<Integer> q = new LinkedList<>();
            q.add(list.get(i));

            while (!q.isEmpty()) {
                int num = q.poll();

                for (int j=0; j<person[num].size(); j++) {
                    if (!visited[person[num].get(j)]){
                        q.add(person[num].get(j));
                        list.add(person[num].get(j));
                        visited[person[num].get(j)] = true;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i=1; i<=M; i++) { // party
            boolean c = true;
            for (int j=0; j<list.size(); j++) { // list
                if (party[i].contains(list.get(j))) {
                    c = false;
                    break;
                }
            }
            if (c) cnt++;
        }

        System.out.println(cnt);

    }
}