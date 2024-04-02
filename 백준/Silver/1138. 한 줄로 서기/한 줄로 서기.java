import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) { // 번호
            int num = Integer.parseInt(st.nextToken());

            for (int j=1; j<=N; j++) {
                if (num == 0 && list[j] == 0) { // 큰사람 없고, 내자리 들어갈수있으면
                    list[j] = i;
                    break;
                } else if (list[j] == 0){ // 큰 사람 들어갈 자리 있으면
                    num--;
                }
            }
        }

        for (int i=1; i<=N; i++) {
            System.out.print(list[i]+" ");
        }

    }
}
