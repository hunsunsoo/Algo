import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<M; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }

        }
        System.out.println(sb);
    }
}
