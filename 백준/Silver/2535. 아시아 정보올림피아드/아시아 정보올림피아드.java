import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][3];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });

        int nation = 2;
        if (list[0][0] == list[1][0]) {
            for (int i=2; i<N; i++) {
                if (list[0][0] != list[i][0]) {
                    nation = i;
                    break;
                }
            }
        }

        System.out.println(list[0][0]+" "+list[0][1]);
        System.out.println(list[1][0]+" "+list[1][1]);
        System.out.println(list[nation][0]+" "+list[nation][1]);
    }
}
