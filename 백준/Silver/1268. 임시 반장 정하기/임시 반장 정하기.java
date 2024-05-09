import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][5];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int idx = 0;
        for (int i=0; i<N; i++) {
            Set<Integer> set = new LinkedHashSet<>();  // i번 학생
            for (int j=0; j<5; j++) {
                for (int k=0; k<N; k++) { // k가 i랑 같은반인지?
                    if (map[i][j] == map[k][j] && i != k) {
                        set.add(k);
                    }
                }
            }

            if (set.size() > max) {
                max = set.size();
                idx = i;
            }
        }

        System.out.println(idx+1);
    }
}
