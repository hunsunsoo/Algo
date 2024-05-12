import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = 1;
        int end = M;

        int J = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i=0; i<J; i++) {
            int loc = Integer.parseInt(br.readLine()); // 사과 위치

            if (loc >= start && loc <= end) continue;

            if (loc < start) {
                int temp = start-loc;
                ans += temp;
                start -= temp;
                end -= temp;
            } else if (loc > end) {
                int temp = loc-end;
                ans += temp;
                start += temp;
                end += temp;
            }
        }
        System.out.println(ans);
    }
}
