import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] mbti = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i=0; i<N; i++) {
                mbti[i] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;
            if (N>=33) min = 0;
            else  {
                for (int i=0; i<N; i++) {
                    for (int j=i+1; j<N; j++) {
                        for (int k=j+1; k<N; k++) {
                            int cnt = 0;
                            for (int a=0; a<4; a++) {
                                if (mbti[i].charAt(a) != mbti[j].charAt(a)) cnt++;
                                if (mbti[i].charAt(a) != mbti[k].charAt(a)) cnt++;
                                if (mbti[j].charAt(a) != mbti[k].charAt(a)) cnt++;
                            }
                            if (cnt < min) min = cnt;
                        }
                    }
                }
            }

            System.out.println(min);
        }
    }
}
