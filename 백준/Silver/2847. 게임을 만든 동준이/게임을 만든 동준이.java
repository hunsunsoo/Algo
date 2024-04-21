import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i=N-1; i>0; i--) {
            if (list[i] <= list[i-1]) {
                int num = list[i-1]-list[i]+1;
                cnt += num;
                list[i-1] -= num;
            }
        }
        System.out.println(cnt);
    }
}
