import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> q_num = new LinkedList<>();
            Queue<String> q_list = new LinkedList<>();

            boolean[] visited = new boolean[10000];
            visited[A] = true;
            q_num.add(A);
            q_list.add("");

            while (!q_num.isEmpty()) {
                int num = q_num.poll();
                String s = q_list.poll();
//                System.out.println(num);

                if (num == B) {
                    sb.append(s).append('\n');
                    break;
                }

                int temp = DSLR(num, 1);
                if (!visited[temp]) {
                    q_num.add(temp);
                    q_list.add(s+"D");
                    visited[temp] = true;
                }

                temp = DSLR(num, 2);
                if (!visited[temp]) {
                    q_num.add(temp);
                    q_list.add(s+"S");
                    visited[temp] = true;
                }

                temp = DSLR(num, 3);
                if (!visited[temp]) {
                    q_num.add(temp);
                    q_list.add(s+"L");
                    visited[temp] = true;
                }

                temp = DSLR(num, 4);
                if (!visited[temp]) {
                    q_num.add(temp);
                    q_list.add(s+"R");
                    visited[temp] = true;
                }
            }
        }
        System.out.println(sb);
    }
    public static int DSLR (int num, int n) {
        if (n == 1) { // D
            return num*2%10000;
        } else if (n == 2) { // S
            if (num == 0) return 9999;
            else return num-1;
        } else if (n == 3) { // L
            return num%1000*10+num/1000;
        } else { // R
            return num/10+num%10*1000;
        }
    }
}
