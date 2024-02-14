import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tt = Integer.parseInt(st.nextToken());
            int[] list = new int[20];

            for (int i=0; i<20; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            for (int i=0; i<20; i++) {
                for (int j=i-1; j>=0; j--) {
                    if (list[i] < list[j]) ans++;
                }
            }

            System.out.println(tc+" "+ans);
        }
    }
}