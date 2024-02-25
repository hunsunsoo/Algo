import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] map;
    public static HashSet<Integer> list;
    public static boolean chk = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1]; // node
        for (int i=1; i<=N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());
        list = new HashSet<>(); // list 팬클럽
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<S; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        DFS(1);

        if (chk) System.out.println("yes");
        else System.out.println("Yes");
    }
    public static void DFS(int a) {
        if (list.contains(a)) {
            return;
        }

        if (map[a].isEmpty()){
            chk = true;
            return;
        }

        for (int i=0; i<map[a].size(); i++) {
            if (!map[map[a].get(i)].isEmpty()) { // 다음 갈 노드에 다음 지점이 있으면
                DFS(map[a].get(i)); // 그쪽으로 가세요
            } else if (map[map[a].get(i)].isEmpty() && !list.contains(map[a].get(i))) {
                chk = true;
            }
        }
    }
}