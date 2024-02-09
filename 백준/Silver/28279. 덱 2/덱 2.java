import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());

            if (X == 1) {
                int num = Integer.parseInt(st.nextToken());
                deq.addFirst(num);
            } else if (X == 2) {
                int num = Integer.parseInt(st.nextToken());
                deq.addLast(num);
            } else if (X == 3) {
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq.pollFirst()).append('\n');
            } else if (X == 4) {
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq.pollLast()).append('\n');
            } else if (X == 5) {
                sb.append(deq.size()).append('\n');
            } else if (X == 6) {
                if (deq.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else if (X == 7) {
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq.peekFirst()).append('\n');
            } else if (X == 8) {
                if (deq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deq.peekLast()).append('\n');
            }
        }
        System.out.println(sb);

    }
}