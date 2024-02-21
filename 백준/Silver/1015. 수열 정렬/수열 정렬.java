import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];
        int[] list2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = i;
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i=0; i<N; i++) {
            int idx = list[i][1];
            list2[idx] = i;
        }

        for(int i=0; i<N; i++) {
            System.out.print(list2[i]+" ");
        }

    }
}