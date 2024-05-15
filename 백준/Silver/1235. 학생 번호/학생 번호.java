import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N];
        for (int i=0; i<N; i++) {
            list[i] = br.readLine();
        }

        int length = list[0].length();
        for (int l=1; l<=length; l++) {
            Set<String> set = new HashSet<>();
            for (int i=0; i<N; i++) {
                String s = list[i].substring(length-l);
                set.add(s);
            }
            if (set.size() == N) {
                System.out.println(l);
                break;
            }
        }
    }
}
