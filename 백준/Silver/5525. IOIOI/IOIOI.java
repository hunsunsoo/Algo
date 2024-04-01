import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] list = new int[M];
        if (s.charAt(0) == 'I') list[0] = 1;

        int result = 0;
        for (int i=1; i<M; i++) {
            if (list[i-1] == 0) {
                if (s.charAt(i) == 'I') list[i] = list[i-1]+1;
            } else if (list[i-1]%2 == 0) { // 직전값 O
                if (s.charAt(i) == 'I') list[i] = list[i-1]+1;
                else { // 카운트
                    if ((list[i-1]-1)/2 + 1 - N > 0) result += (list[i-1]-1)/2 + 1 - N;
                }
            } else { // 직전값 I
                if (s.charAt(i) == 'O') list[i] = list[i-1]+1;
                else { // 카운트
                    if ((list[i-1]-1)/2 + 1 - N > 0) result += (list[i-1]-1)/2 + 1 - N;
                    list[i] = 1;
                }
            }
        }
        if ((list[M-1]-1)/2 + 1 - N > 0) result += (list[M-1]-1)/2 + 1 - N;

        System.out.println(result);
    }
}
