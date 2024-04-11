import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] list = new Integer[N-1];

        int dasom = Integer.parseInt(br.readLine());
        for (int i=0; i<N-1; i++) list[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (true) {
            Arrays.sort(list, Collections.reverseOrder());
            if (N==1 || list[0] < dasom) break;
            else {
                dasom++;
                list[0]--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
