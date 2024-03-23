import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s);
        int M = Integer.parseInt(br.readLine());
        int[] btn = new int[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<M; i++) {
                btn[Integer.parseInt(st.nextToken())] = -1;
            }
        }

        int cnt0 = Math.abs(N-100); // + - 만 눌렀음

        int left_num = N;
        while (left_num>0) {
            boolean chk = true;
            for (int i=0; i<String.valueOf(left_num).length(); i++) {
                int num = (int) (left_num/Math.pow(10,i)%10);
                if (btn[num] == -1) {
                    chk = false;
                    break;
                }
            }
            if (chk) break;
            else left_num--;
        }
        if (left_num == 0 && btn[0] == -1) left_num = 100;

        int right_num = N;
        while (right_num<999900) {
            boolean chk = true;
            for (int i=0; i<String.valueOf(right_num).length(); i++) {
                int num = (int) (right_num/Math.pow(10,i)%10);
                if (btn[num] == -1) {
                    chk = false;
                    break;
                }
            }
            if (chk) break;
            else right_num++;
        }

        int cnt1 = String.valueOf(left_num).length() + Math.abs(left_num-N);
        int cnt2 = String.valueOf(right_num).length() + Math.abs(right_num-N);

        System.out.println(Math.min(cnt0, Math.min(cnt1, cnt2)));
    }
}