import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> A = new ArrayList<>();
        ArrayList<Long> B = new ArrayList<>();

        func(0,N/2,0, A, list);
        func(N/2,N,0, B, list);

        Collections.sort(A);
        Collections.sort(B);

//        System.out.println(A);
//        System.out.println(B);

        long cnt = 0;
        int left = 0;
        int right = B.size()-1;
        while (left < A.size() && right >= 0) {
            long sum = A.get(left) + B.get(right);

            if (sum == S) {
                long a = A.get(left);
                long b = B.get(right);
                long Acnt = 0;
                long Bcnt = 0;

                while (left < A.size() && A.get(left) == a) {
                    Acnt++;
                    left++;
                }
                while (right >= 0 && B.get(right) == b) {
                    Bcnt++;
                    right--;
                }

                cnt += Acnt * Bcnt;
            } else if (sum < S) {
                left++;
            } else {
                right--;
            }
        }

        if (S == 0) System.out.println(cnt-1);
        else System.out.println(cnt);
    }
    public static void func(int idx, int end, long sum, ArrayList<Long> Array, int[] list) {
        if (idx == end) {
            Array.add(sum);
            return;
        }

        func(idx+1, end, sum+list[idx], Array, list);
        func(idx+1, end, sum, Array, list);
    }
}
