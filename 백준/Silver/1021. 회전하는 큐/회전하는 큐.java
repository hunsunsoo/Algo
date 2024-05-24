import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            deque.add(i);
        }
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i=0; i<M; i++) {
            int first = deque.peekFirst();
            int last = deque.peekLast();
            int num = list[i];

            int cnt = 0;
            if (first == num) {
                deque.pollFirst();
            } else {
                while (first != num) {
                    deque.add(deque.pollFirst());
                    first = deque.peekFirst();
                    cnt++;
                }
                if (deque.size()/2 >= cnt) {
                    ans += cnt;
                } else {
                    ans += deque.size()-cnt;
                }
                deque.pollFirst();
            }
        }
        System.out.println(ans);
    }
}