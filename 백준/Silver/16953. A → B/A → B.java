import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(B);

        int cnt = 1;
        boolean chk = false;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == A) {
                chk = true;
                break;
            }

            if (num%2 == 0) {
                if (num/2 >= A) q.add(num/2);
            }
            if (num%10 == 1) {
                if (num/10 >= A) q.add((num-1)/10);
            }
            cnt++;
        }

        if (chk) System.out.println(cnt);
        else System.out.println(-1);
    }
}