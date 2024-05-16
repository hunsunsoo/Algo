import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            sum += list[i];
        }

        Arrays.sort(list);
        long ans = 0;
        for (int i=N-1; i>=0; i--) {
            sum -= list[i];
            ans += sum*list[i];
        }

        System.out.println(ans);
    }
}
