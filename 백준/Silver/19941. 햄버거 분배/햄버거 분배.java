import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        int[] list = new int[s.length()];

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'H') list[i] = -1; // 햄버거 -1
            else list[i] = 0;
        }

        int[] dp = new int[s.length()];

        int cnt = 1;
        for (int i=0; i<list.length; i++) {
            if (list[i] == -1) { // 햄버거 일때
                // 앞에 못먹은 사람이 있나?
                boolean chk = false;
                for (int j=K; j>=1; j--) {
                    if (i-j >= 0 && list[i-j] == 0) {
                        list[i-j] = cnt++;
                        chk = true;
                        break;
                    }
                }
                // 뒤에 못먹은 사람이 있나?
                if (!chk) {
                    for (int j=1; j<=K; j++) {
                        if (i+j <= N-1 && list[i+j] == 0) {
                            list[i+j] = cnt++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt-1);
    }
}