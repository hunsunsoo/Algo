import java.io.*;
import java.util.*;

public class Main {
    public static int[] list;
    public static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[10];
        for (int i=0; i<10; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[10];
        exam(arr, 0);

        System.out.println(ans);
    }
    public static void exam(int[] arr, int depth) {
        if (depth == 10) {
            int cnt = 0;
            for (int i=0; i<10; i++) {
                if (list[i] == arr[i]) cnt++;
            }
            if (cnt >= 5) ans++;
            return;
        }

        if (depth < 2) {
            for (int i=1; i<=5; i++) {
                arr[depth] = i;
                exam(arr, depth+1);
            }
        } else {
            for (int i=1; i<=5; i++) {
                if (arr[depth-2] == i && arr[depth-1] == i) continue;

                arr[depth] = i;
                exam(arr,depth+1);
            }
        }
    }
}