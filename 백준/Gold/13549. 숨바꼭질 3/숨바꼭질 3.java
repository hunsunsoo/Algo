import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] list = new int[100001];

        Queue<Integer> q = new LinkedList<>();

        q.add(N);

        while (!q.isEmpty()) {
            int loc = q.poll();
//            System.out.println(loc + " " + list[loc]);
            if (loc == K) break;
            if (loc*2 == K) {
                list[loc*2] = list[loc];
                break;
            }

            // 순간이동
            if (loc*2 <= 100000 && list[loc*2] == 0) {
                q.add(loc*2);
                list[loc*2] = list[loc];
            }

            if (loc-1 >= 0 && list[loc-1] == 0) {
                q.add(loc-1);
                list[loc-1] = list[loc] + 1;
            }

            if (loc+1 <= 100000 && list[loc+1] == 0) {
                q.add(loc+1);
                list[loc+1] = list[loc] + 1;
            }
        }

        System.out.println(list[K]);
    }
}
