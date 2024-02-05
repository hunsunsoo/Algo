import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[100001];

        for (int i=1; i<=N; i++) {
            list[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j*j <= i; j++) {
                if (list[i] > list[i - (j*j)] + 1) {
                    list[i] = list[i - (j*j)] + 1;
                }
            }
        }

        System.out.println(list[N]);

    }
}