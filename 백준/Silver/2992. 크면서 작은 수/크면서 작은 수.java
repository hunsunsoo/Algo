import java.io.*;
import java.util.*;

public class Main {
    public static int[] list;
    public static boolean[] visited;
    public static HashSet<Integer> arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        list = new int[N.length()];

        for (int i=0; i<N.length(); i++) {
            list[i] = N.charAt(i)-48;
        }

        visited = new boolean[N.length()];
        arr = new HashSet<>();

        perm(0, N.length(), N.length());

        ArrayList<Integer> map = new ArrayList<>(arr);

        Collections.sort(map);
        for (int i=0; i<map.size(); i++) {
            if (map.get(i) == Integer.parseInt(N)) {
                if (i == map.size()-1) System.out.println(0);
                else {
                    System.out.println(map.get(i+1));
                    break;
                }
            }
        }

    }
    public static void perm(int depth, int n, int r) {
        if (depth == r) {
            String s = "";
            for (int i=0; i<n; i++) {
                s += list[i];
            }
            arr.add(Integer.parseInt(s));
        }

        for (int i=depth; i<n; i++) {
            swap(depth, i);
            perm(depth+1, n, r);
            swap(depth, i);
        }
    }
    public static void swap(int depth, int i) {
        int temp = list[depth];
        list[depth] = list[i];
        list[i] = temp;
    }
}