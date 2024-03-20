import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[101];
        int[] game = new int[101];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            game[a] = b;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            game[a] = b;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        for(int i=2; i<=100; i++) list[i] = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int num = q.poll();

            if (num == 100) {
                break;
            }

            for (int i=1; i<=6; i++) {
                if (num+i > 100) {
                    continue;
                }

                if (game[num+i] == 0) {
                    if (list[num]+1 < list[num+i]) {
                        q.add(num+i);
                        list[num+i] = list[num]+1;
                    }
                }
                else {
                    if (list[num]+1 < list[game[num+i]]) {
                        q.add(game[num+i]);
                        list[game[num+i]] = list[num]+1;
                    }
                }
            }
        }

        System.out.println(list[100]);
    }
}