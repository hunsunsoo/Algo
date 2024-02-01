import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int[] list, ans;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            Long num = Long.parseLong(br.readLine());
            if (map.get(num) != null) map.put(num, map.get(num)+1);
            else map.put(num, 1);
        }

        int max = 0;
        Long max_num = 0L;
        for (Long c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                max_num = c;
            } else if (map.get(c) == max) {
                max_num = Math.min(max_num, c);
            }
        }

        System.out.println(max_num);
    }
}