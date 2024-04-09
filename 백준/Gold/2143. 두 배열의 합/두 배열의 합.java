import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] listA = new int[N];
        for (int i=0; i<N; i++) {
            listA[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] listB = new int[M];
        for (int i=0; i<M; i++) {
            listB[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        for (int i=0; i<N; i++) {
            int sum = 0;
            for (int j=i; j<N; j++) {
                sum += listA[j];
                A.add(sum);
            }
        }
        for (int i=0; i<M; i++) {
            int sum = 0;
            for (int j=i; j<M; j++) {
                sum += listB[j];
                B.add(sum);
            }
        }

        Collections.sort(A);
        Collections.sort(B);

        long cnt  = 0;
        int left = 0;
        int right = B.size()-1;

        while (left < A.size() && right >= 0) {
            int sum = A.get(left) + B.get(right);

            if (sum == T) {
                // (만족 하는 A의 갯수 * 만족하는 B의 갯수) 를 더해줘야함
                int a = A.get(left);
                int b = B.get(right);
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
            } else if (sum < T) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(cnt);
    }
}
