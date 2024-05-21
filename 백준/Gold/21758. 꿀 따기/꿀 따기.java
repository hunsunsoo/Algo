import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[N];
        left[0] = list[0];
        for (int i=1; i<N; i++) {
            left[i] = left[i-1] + list[i];
        }
        int[] right = new int[N];
        right[N-1] = list[N-1];
        for (int i=N-2; i>=0; i--) {
            right[i] = right[i+1] + list[i];
        }

        // 양 쪽 끝 시작이면, 그 사이 구간 어짜피 다돌고 꿀 있는부분만 한번더 더함
        int max1 = 0;
        for (int i=1; i<N-1; i++) {
            max1 = Math.max(list[i], max1);
        }
        max1 += left[N-2] - left[0];
        // 한 쪽 끝 시작이면,
        // 일단 맨끝은 고정 시작 => 그 다음 벌 위치는 누적합 비교해봐야할듯
        // 왼쪽 시작 (꿀 오른쪽)
        int max2 = 0;
        int bee1 = 0;
        int bee2 = 0;
        for (int i=1; i<N-1; i++) {
            bee1 = left[N-1] - left[0] - list[i];
            bee2 = left[N-1] - left[i];
            max2 = Math.max(max2, bee1 + bee2);
        }

        // 오른쪽 시작 (꿀 왼쪽)
        int max3 = 0;
        bee1 = 0;
        bee2 = 0;
        for (int i=N-2; i>0; i--) {
            bee1 = right[0] - right[N-1] - list[i];
            bee2 = right[0] - right[i];
            max3 = Math.max(max3, bee1 + bee2);
        }

        System.out.println(Math.max(max1,Math.max(max2,max3)));
    }
}
