import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[53];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[num]++;
        }

        // A 65->1  a 97->27
        String s = br.readLine();

        for (int i=0; i<N; i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                list[s.charAt(i)-64]--;
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                list[s.charAt(i)-70]--;
            } else {
                list[0]--;
            }
        }

        boolean chk = true;
        for (int i=0; i<53; i++) {
            if (list[i] > 0) {
                chk = false;
                break;
            }
        }

        if (chk) System.out.println("y");
        else System.out.println("n");
    }
}