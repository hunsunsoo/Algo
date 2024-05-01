import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static ArrayList<Integer> list;
    public static int[] arr;
    public static boolean[] visited;
    public static Set<String> set;
    public static HashMap<String, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        arr = new int[M];
        visited = new boolean[N];
        set = new LinkedHashSet<>();
        back(0);

        for (String s : set) {
            System.out.println(s);
        }
    }
    public static void back (int idx) {
        if (idx == M) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<M; i++) {
                sb.append(arr[i]+" ");
            }
//            System.out.println(sb);
            set.add(String.valueOf(sb));
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                arr[idx] = list.get(i);
                visited[i] = true;
                back(idx+1);
                visited[i] = false;
            }
        }
    }
}
