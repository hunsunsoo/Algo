import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            ArrayList<Character> arr = new ArrayList<>();
            for (int j=0; j<s.length(); j++) {
                arr.add(s.charAt(j));
            }
            Collections.sort(arr);

            String ss = "";
            for (int j=0; j<s.length(); j++) {
                ss += arr.get(j);
            }
            set.add(ss);
        }
        System.out.println(set.size());
    }
}
