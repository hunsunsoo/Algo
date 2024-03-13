import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[10];
        for (int i=1; i<10; i++) list[i] = 1; // 0 1 1 1 ... 1

        for (int t=1; t<N; t++) { // 연산할 횟수
            int[] temp = new int[10];
            temp[0] = list[1];
            for (int i=1; i<9; i++) {
                temp[i] = list[i-1] + list[i+1];
            }
            temp[9] = list[8];

            for (int i=0; i<10; i++) {
                list[i] = temp[i]%1000000000;
            }
        }

        long sum = 0;
        for (int i=0; i<10; i++) {
            sum += list[i];
        }
        System.out.println(sum%1000000000);
    }
}