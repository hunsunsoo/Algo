import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int tc=0; tc<N; tc++) {
            String s = br.readLine();
            int[] list = new int[26];

            char temp = s.charAt(0);
            list[s.charAt(0)-97]++;
            boolean chk = true;
            for (int i=1; i<s.length(); i++) {
                if (list[s.charAt(i)-97] == 0) list[s.charAt(i)-97]++;
                else {
                    if (s.charAt(i) != temp) chk = false;
                    else list[s.charAt(i)-97]++;
                }
                temp = s.charAt(i);
            }
            if (chk) cnt++;
        }

        System.out.println(cnt);
    }
}