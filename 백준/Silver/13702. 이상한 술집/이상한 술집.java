import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        long left = 1;
        long right = 0;
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, list[i]);
        }
        right++;

        while (left < right) {
            int cnt = 0;
            long mid = (left+right)/2;
            for (int i=0; i<N; i++) {
                cnt += list[i]/mid;
            }

            if (cnt >= K) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        System.out.println(left-1);
    }
}