import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            String P = br.readLine(); // 함수
            int N = Integer.parseInt(br.readLine()); // 배열 크기
            Deque<Integer> deque = new ArrayDeque<>();
            String s = br.readLine();
            s = s.replace("[", "");
            s = s.replace("]", "");
            String[] slist = s.split(",");

            for (int i=0; i<N; i++) {
                deque.add(Integer.parseInt(slist[i]));
            }

            boolean chk = true;
            int dir = 1; // 정방향 1, 역방향 -1
            for (int i=0; i<P.length(); i++) {
                if (P.charAt(i) == 'R') {
                    dir *= -1;
                } else if (P.charAt(i) == 'D') {
                    if (deque.isEmpty()) {
                        chk = false;
                        break;
                    }
                    if (dir == 1) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if (!chk) {
                System.out.println("error");
            } else {
                int size = deque.size();

                sb.append("[");

                if (dir == 1) {
                    for (int i=0; i<size-1; i++) {
                        sb.append(deque.pollFirst());
                        sb.append(",");
                    }
                } else {
                    for (int i=0; i<size-1; i++) {
                        sb.append(deque.pollLast());
                        sb.append(",");
                    }
                }

                if (size != 0) sb.append(deque.poll());
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}