import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int[] list, ans;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.next();
            String t = sc.next();

            int idx = 0;
            for (int i=0; i<t.length(); i++) {
                if (idx == s.length()) break;

                if (s.charAt(idx) == t.charAt(i)) idx++;
            }

            if (idx == s.length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}