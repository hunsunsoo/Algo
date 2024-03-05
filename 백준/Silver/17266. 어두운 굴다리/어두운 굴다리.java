import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] light = new int[M+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = 0;
        for (int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            light[i] = num - temp;
            temp = num;
        }
        light[M] = N - temp;

        int left = 1;
        int right = 100001;

        while (left < right) {
            int mid = (left+right)/2;

            boolean chk = true;
            if (light[0] > mid) chk = false;
            for (int i=1; i<M; i++) {
                if (light[i] > mid*2) {
                    chk = false;
                }
            }
            if (light[M] > mid) chk = false;

            if (chk) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        System.out.println(left);
    }
}