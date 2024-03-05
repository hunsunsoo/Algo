import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken(); // Y F O

        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            if (map.get(s) == null) map.put(s, 1);
            else map.put(s, map.get(s)+1);
        }

        int[] list = new int[map.size()];
        int idx = 0;
        for (int i : map.values()) {
            list[idx++] = i;
        }

        int cnt = 0;
        if (type.equals("Y")) cnt = 1;
        else if (type.equals("F")) cnt = 2;
        else if (type.equals("O")) cnt = 3;

        System.out.println(map.size()/cnt);
    }
}