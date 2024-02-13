import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            if (name1.equals("ChongChong") || name2.equals("ChongChong")) {
                map.put(name1, 1);
                map.put(name2, 1);
            } else if (map.get(name1) != null && map.get(name1) == 1) {
                map.put(name1, 1);
                map.put(name2, 1);
            } else if  (map.get(name2) != null && map.get(name2) == 1) {
                map.put(name1, 1);
                map.put(name2, 1);
            } else {
                map.put(name1, 0);
                map.put(name2, 0);
            }
        }

        int cnt = 0;
        for (String s : map.keySet()) {
            if (map.get(s) == 1) cnt++;
        }

        System.out.println(cnt);
    }
}