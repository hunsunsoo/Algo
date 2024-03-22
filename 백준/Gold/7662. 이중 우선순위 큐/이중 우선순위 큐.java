import java.io.*;
import java.util.*;

public class Main {
    public static PriorityQueue<Integer> q, qq;
    public static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            q = new PriorityQueue<>();
            qq = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>(); // q.remove가 시간복잡도가 커서 map으로 관리함

            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                Integer num = Integer.parseInt(st.nextToken());

                if (s.equals("I")) {
                    q.add(num);
                    qq.add(num);
                    map.put(num, map.getOrDefault(num, 0)+1);
                } else if (s.equals("D")) {
                    if (map.size() == 0) continue;

                    if (num == -1) {
                        delete(q);
                    } else if (num == 1) {
                        delete(qq);
                    }
                }
            }


            if (map.size() == 0) sb.append("EMPTY").append('\n');
            else {
                int q_num = delete(qq);
                sb.append(q_num).append(" ");
                if (map.size() > 0) q_num = delete(q);
                sb.append(q_num).append('\n');
            }
        }
        System.out.println(sb);
    }
    public static int delete(Queue<Integer> q) {
        int q_num = 0;
        while (true) {
            q_num = q.poll();
            int cnt = map.getOrDefault(q_num, 0);
            if (cnt == 0) continue; // 이미 제거된 값임

            if (cnt == 1) map.remove(q_num); // 하나 남은거면 지워버림
            else map.put(q_num, cnt-1); // 그 이상이면 하나만 뺌
            break;
        }

        return q_num;
    }
}