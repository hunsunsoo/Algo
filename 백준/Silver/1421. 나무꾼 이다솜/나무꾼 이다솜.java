import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        int max = 0;
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, list[i]);
        }

        long ans = 0;
        for (int L=max; L>0; L--) {
            long sum = 0;
            for (int i=0; i<N; i++) {
                int cnt = 0;
                if (list[i] >= L) {
                    if (list[i] % L == 0) cnt = list[i]/L-1;
                    else cnt = list[i]/L;

                    if (W*L*(list[i]/L) > cnt*C) sum += W*L*(list[i]/L) - cnt*C;
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);

    }
}