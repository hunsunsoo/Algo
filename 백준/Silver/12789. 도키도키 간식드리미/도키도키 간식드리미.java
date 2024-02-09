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

        Stack<Integer> stack = new Stack<>();

        boolean chk = true;

        int idx = 1;
        for (int i=0; i<N; i++) {
            if (list[i] == idx) idx++;
            else {
                if (!stack.isEmpty() && stack.peek() == idx) {
                    stack.pop();
                    idx++;
                    i--;
                } else stack.add(list[i]);
            }
//            System.out.println(idx+ " " +stack);
        }

        while (!stack.isEmpty()) {
            if (stack.pop() == idx) idx++;
            else chk = false;
        }

        if (chk) System.out.println("Nice");
        else System.out.println("Sad");

    }
}