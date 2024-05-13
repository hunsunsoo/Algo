import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] list = s.split("\\.");
        StringBuilder sb = new StringBuilder();

        boolean chk = true;
        for (int i=0; i<list.length; i++) {
            int a = list[i].length()/4;
            int b = list[i].length()%4;
            int c = b/2;
            int d = b%2;

            if (d != 0) {
                chk = false;
                break;
            }

            for (int x=0; x<a; x++) sb.append("AAAA");

            for (int x=0; x<c; x++) sb.append("BB");

            if (i != list.length-1) sb.append(".");
        }
        if (chk) {
            int length = sb.toString().length();
            for (int i=0; i<s.length()-length; i++) {
                sb.append(".");
            }
            System.out.println(sb);
        }
        else System.out.println(-1);
    }
}