import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int[] list, ans;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            int cnt = 0;
            boolean ischecked = true;
            for (int i=1; i<s.length()-1; i++) {
                char c0 = s.charAt(i-1);
                char c = s.charAt(i);
                char c1 = s.charAt(i+1);
                int v0 = -1;
                int v = -1;
                int v1 = -1;

                for (int j=0; j<5; j++) {
                    if (c0 == vowel[j]) v0 = 1;
                    if (c == vowel[j]) {
                        v = 1;
                        cnt++;
                    }
                    if (c1 == vowel[j]) v1 = 1;
                }

                // 세개 연속   모음 or 자음
                if (v0 == v && v == v1) ischecked = false;

                // 두개 연속 같은 글자 (ee oo 제외)
                if (c0 == c && c != 'e' && c != 'o') ischecked = false;
                if (c == c1 && c != 'e' && c != 'o') ischecked = false;
            }

            for (int j=0; j<5; j++) {
                if (s.charAt(0) == vowel[j]) cnt++;
                if (s.charAt(s.length()-1) == vowel[j]) cnt++;
            }

            System.out.print("<"+s+">"+" is ");
            if (ischecked && cnt >=1) {
                System.out.println("acceptable.");
            } else System.out.println("not acceptable.");

        }

    }
}