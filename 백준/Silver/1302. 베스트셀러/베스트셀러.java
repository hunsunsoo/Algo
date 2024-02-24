import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        int max = 0;
        for (int i=0; i<N; i++) {
            String s = br.readLine();
            if (map.get(s) != null) {
                map.put(s, map.get(s)+1);
            } else {
                map.put(s, 1);
            }
            max = Math.max(max, map.get(s));
        }

        List<String> list = new ArrayList<>();

        for (String s: map.keySet()) {
            if (map.get(s) == max) {
                list.add(s);
            }
        }
        list.sort(String::compareTo);

        System.out.println(list.get(0));
    }
}