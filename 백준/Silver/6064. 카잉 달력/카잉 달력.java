import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken())-1;
            int Y = Integer.parseInt(st.nextToken())-1;

            // M N 최소 공배수가 최대 year
            // year % M = x    year % N = y
            boolean chk = false;
            for (int i=X; i< N*M; i += M) {  // M에 맞춰놓고 year 증가
                if (i % N == Y) {
                    System.out.println(i+1);
                    chk = true;
                    break;
                }
            }

            if (!chk) System.out.println(-1);
        }
    }
}