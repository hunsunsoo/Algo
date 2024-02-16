import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        int left = 0;
        int right = 1;
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, list[i]);
            right += list[i];
        }

        while (left < right) {
            int mid = (left+right)/2;

            int cnt = 1;
            int money = mid;
            for (int i=0; i<N; i++) {
                if (list[i] <= money) {
                    money -= list[i];
                } else {
                    cnt++;
                    money = mid - list[i];
                }
            }

            if (cnt > M) {
                left = mid+1;
            } else {
                right = mid;
            }

//            System.out.println(cnt+ " "+ left+ " "+ right);
        }

        System.out.println(left);

    }
}