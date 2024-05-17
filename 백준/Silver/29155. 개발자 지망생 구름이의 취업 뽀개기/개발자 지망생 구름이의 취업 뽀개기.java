import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int chk = 0;
        for (int i=0; i<5; i++) {
            step[i] = Integer.parseInt(st.nextToken());
            if (step[i] > 0) chk++;
        }

        ArrayList<Integer>[] list = new ArrayList[5];
        for (int i=0; i<5; i++) list[i] = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<5; i++) {
            Collections.sort(list[i]);
        }

        int ans = (chk-1)*60;

        for (int i=0; i<5; i++) {
            if (list[i].size() == 1) {
                ans += list[i].get(0);
                continue;
            }

            for (int j=0; j<step[i]-1; j++) {
                ans += list[i].get(j);
                ans += list[i].get(j+1)-list[i].get(j);
            }
            ans += list[i].get(step[i]-1);
        }
        System.out.println(ans);
    }
}
