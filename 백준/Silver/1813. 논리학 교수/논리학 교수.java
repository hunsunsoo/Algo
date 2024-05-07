import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[51];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[Integer.parseInt(st.nextToken())]++;
        }

        int ans = 0;
        for (int i=N; i>=0; i--) {
            if (list[i] == i) {
                ans = i;
                break;
            }
        }

        if (ans == 0 && list[0] != 0) ans = -1;
        System.out.println(ans);
    }
}
