import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] list = {'I', 'O'};

        int result = 0;
        for (int i=0; i<M-2*N; i++) {
            int cnt = 0;
            for (int j=0; j<2*N+1; j++) {
                int num = j%2;
                if (s.charAt(i+j) == list[num]) cnt++;
                else break;
            }
            if (cnt == 2*N+1) result++;
        }

        System.out.println(result);
    }
}
