import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        int max = 0;
        int ans = -1;
        for (int i=0; i<N-1; i++) {
            int num = (list[i+1] - list[i]) / 2;

            if (num > max) {
                max = num;
                ans = (list[i+1] + list[i]) / 2;
            }
        }

        System.out.println(ans);
    }
}